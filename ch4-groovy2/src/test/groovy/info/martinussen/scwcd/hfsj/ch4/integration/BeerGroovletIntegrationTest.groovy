package info.martinussen.scwcd.hfsj.ch4.integration


import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlOption
import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.html.HtmlParagraph
import com.gargoylesoftware.htmlunit.html.HtmlSelect
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput

@RunWith(Parameterized)
class BeerGroovletIntegrationTest {
/* Integrationtest demonstrating htmlunit used from groovy, navigating from 
 * index.html to the resulting page.
 * htmlunit's api is used to pick out the expected values on the result page
 * Futhermore this integrationtest demonstrates JUnit 4 parameterized test, 
 * implemented in groovy
 *
 * The test opens the index.html selects from the dropdown and clicks submit.
 * On the resulting page it is verified that the expected content is present.
 */
 //TODO introduce more groovyness - it still looks like what it is - a rework of a java test.
 
  def port        = '8081'
  def url         = "http://localhost:${port}"
  def contextPath = "/ch4-groovy2"
  def uri         = "$url$contextPath"
  
  WebClient webClient
  HtmlPage startForm
  
  def param
  def expected1
  def expected2
  
  @Parameters
  static data () {
    return [["amber", "Jack Amber",    "Red Moose"]  as String[],
            ["light", "Jail Pale Ale", "Gout Stout"] as String[],
            ["brown", "Jail Pale Ale", "Gout Stout"] as String[],
            ["dark",  "Jail Pale Ale", "Gout Stout"] as String[]]
  }

  BeerGroovletIntegrationTest (p , ex1, ex2){
    param = p
    expected1 = ex1
    expected2 = ex2
  }

  @After
  void tearDown(){
    startForm = null
    webClient.closeAllWindows()
    webClient = null
  }
  
  @Test
  public void testAllColors(){
    webClient = new WebClient()
    startForm = (HtmlPage) webClient.getPage (uri)
    HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName('select').item(0)
    HtmlOption option = select.getOptionByValue(param)
    select.setSelectedAttribute(option, true)
    
    HtmlSubmitInput submit =  (HtmlSubmitInput) startForm.getElementsByTagName('input').item(0)
    
    HtmlPage resultPage = submit.click()
    HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0)
    
    assert p.asText() =~ "Try: $expected1"
    assert p.asText() =~ "Try: $expected2"
  }
}
