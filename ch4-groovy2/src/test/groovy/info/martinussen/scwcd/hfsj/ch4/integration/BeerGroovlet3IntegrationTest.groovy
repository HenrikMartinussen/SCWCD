package info.martinussen.scwcd.hfsj.ch4.integration


import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import geb.Browser

@RunWith(Parameterized)
class BeerGroovlet3IntegrationTest {
/* Integrationtest demonstrating Geb, navigating from index.html to the 
 * resulting page.
 * Geb's api is used to pick out the expected values on the result page
 * Furthermore this integrationtest demonstrates JUnit 4 parameterized test, 
 * implemented in groovy
 *
 * The test opens the index.html selects from the dropdown and clicks submit.
 * On the resulting page it is verified that the expected content is present.
 */
 
  def port        = '8081'
  def url         = "http://localhost:${port}"
  def contextPath = "/ch4-groovy2"
  def uri         = "$url$contextPath"
  
  
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

  BeerGroovlet3IntegrationTest (p , ex1, ex2){
    param = p
    expected1 = ex1
    expected2 = ex2
  }

  
  @Test
  public void testAllColors(){
    Browser.drive{
      go uri
      assert $("h1").text() == "Beer Selection Page"
     
      $("select", name:"color").value(param)
      
      $("input").click()
      
      assert title == 'Beer Recommendations'
      assert $("h1").text() == "Beer Recommendations"
      assert $("p").text() =~ expected1
      assert $("p").text() =~ expected2
    }
  }
}
