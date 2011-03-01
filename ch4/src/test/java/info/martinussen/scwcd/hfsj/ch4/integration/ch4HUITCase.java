package info.martinussen.scwcd.hfsj.ch4.integration;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class ch4HUITCase {
  private WebClient webClient;
  private HtmlPage startForm;
  
  @Before
  public void setUp() throws IOException{
    webClient = new WebClient();
    startForm = (HtmlPage) webClient.getPage("http://localhost:8081/ch4");
  }
  
  @Test
  public void testCh4Amber() throws IOException{
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
    HtmlOption option = select.getOptionByValue("amber");
    select.setSelectedAttribute(option, true);
    
    Object o = startForm.getElementsByTagName("input").item(0);
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) o; 
    
    HtmlPage resultPage = submit.click();
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
    
    assertTrue("Unexpected text", p.asText().contains("try: Jack Amber")); 
    assertTrue("Unexpected text", p.asText().contains("try: Red Moose")); 
  }
  
  @Test
  public void testCh4Light() throws IOException{
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
    HtmlOption option = select.getOptionByValue("light");
    select.setSelectedAttribute(option, true);
    
    Object o = startForm.getElementsByTagName("input").item(0);
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) o; 
    
    HtmlPage resultPage = submit.click();
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
    
    assertTrue("Unexpected text", p.asText().contains("try: Jail Pale Ale")); 
    assertTrue("Unexpected text", p.asText().contains("try: Gout Stout")); 
  }

  @Test
  public void testCh4Brown() throws IOException{
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
    HtmlOption option = select.getOptionByValue("brown");
    select.setSelectedAttribute(option, true);
    
    Object o = startForm.getElementsByTagName("input").item(0);
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) o; 
    
    HtmlPage resultPage = submit.click();
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
    
    assertTrue("Unexpected text", p.asText().contains("try: Jail Pale Ale")); 
    assertTrue("Unexpected text", p.asText().contains("try: Gout Stout")); 
  }
  
  @Test
  public void testCh4Dark() throws IOException{
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
    HtmlOption option = select.getOptionByValue("dark");
    select.setSelectedAttribute(option, true);
    
    Object o = startForm.getElementsByTagName("input").item(0);
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) o; 
    
    HtmlPage resultPage = submit.click();
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
    
    assertTrue("Unexpected text", p.asText().contains("try: Jail Pale Ale")); 
    assertTrue("Unexpected text", p.asText().contains("try: Gout Stout")); 
  }
  
  @After
  public void tearDown(){
    startForm = null;
    webClient = null;
  }
  
}
