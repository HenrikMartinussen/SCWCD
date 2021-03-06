package info.martinussen.scwcd.hfsj.ch4.integration;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Junit in action p 17 Running parameterized tests
 * @author HMS
 *
 */
@RunWith(value = Parameterized.class)
public class Ch4HUITCase {

  private static final String SCHEME           = "http://";
  private static final String HOST_NAME        = "localhost";
  private static final String PORT             = "8081";
  private static final String RESOURCE_TO_OPEN = "ch4/";
  private static final String URL              = SCHEME + HOST_NAME + ":" + PORT + "/" + RESOURCE_TO_OPEN;
  private static final String EXPECTED_PREFIX  = "try: ";
  
  private WebClient webClient;
  private HtmlPage  startForm;
  
  private String    testColor;
  private String    expected1;
  private String    expected2;
  
  @Parameters
  public static Collection<String[]> getTestParameters(){
    return Arrays.asList(new String[][]{
      // value,   expected1,       expected2
        {"amber", "Jack Amber",    "Red Moose"},
        {"light", "Jail Pale Ale", "Gout Stout"},
        {"brown", "Jail Pale Ale", "Gout Stout"},
        {"dark",  "Jail Pale Ale", "Gout Stout"}
    });
  }
  
  public Ch4HUITCase(String testColor, String expected1, String expected2){
    this.testColor = testColor;
    this.expected1 = expected1;
    this.expected2 = expected2;
  }
  
  @Before
  public void setUp() throws IOException{
    webClient = new WebClient();
    startForm = webClient.getPage(URL);
  }
  
  @Test
  public void testCh4() throws IOException{
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
    HtmlOption option = select.getOptionByValue(testColor);
    select.setSelectedAttribute(option, true);
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) startForm.getElementsByTagName("input").item(0);
    
    HtmlPage resultPage = submit.click();
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
    
    assertTrue("Unexpected text", p.asText().contains(EXPECTED_PREFIX + expected1)); 
    assertTrue("Unexpected text", p.asText().contains(EXPECTED_PREFIX + expected2));

    HtmlHeading1 header = (HtmlHeading1) resultPage.getElementsByTagName("h1").item(0);
    assertTrue("Unexpected header", header.asText().contains("Beer recommendations JSP"));
  }
  

  @After
  public void tearDown(){
    startForm = null;
    webClient.closeAllWindows();
    webClient = null;
  }
  
}
