package info.martinussen.scwcd.hfsj.ch4.integration;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

/**
 * Junit in action p 17 Running parameterized tests
 * @author HMS
 *
 */
@RunWith(value = Parameterized.class)
public class Ch4HUITCase {
  
  private static final String EXPECTED_PREFIX = "try: ";
  
  private WebClient webClient;
  private HtmlPage startForm;
  
  private String testColor;
  private String expected1;
  private String expected2;
  
  @Parameters
  public static Collection<String[]> getTestParameters(){
    return Arrays.asList(new String[][]{
        {"amber", "Jack Amber", "Red Moose"}, // value, expected1, expected2
        {"light", "Jail Pale Ale", "Gout Stout"},
        {"brown", "Jail Pale Ale", "Gout Stout"},
        {"dark", "Jail Pale Ale", "Gout Stout"}
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
    startForm = (HtmlPage) webClient.getPage("http://localhost:8081/ch4");
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
  }
  

  @After
  public void tearDown(){
    startForm = null;
    webClient = null;
  }
  
}
