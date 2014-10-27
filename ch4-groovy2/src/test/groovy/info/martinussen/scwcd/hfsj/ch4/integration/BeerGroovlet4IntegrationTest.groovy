package info.martinussen.scwcd.hfsj.ch4.integration

import spock.lang.Unroll;
import geb.Browser
import geb.spock.GebSpec

class BeerGroovlet4IntegrationTest extends GebSpec{
/* Spock Integrationtest demonstrating Geb, navigating from index.html to the 
 * resulting page.
 * Geb's api is used to pick out the expected values on the result page
 * Furthermore this integrationtest demonstrates Spock parameterized test. 
 *
 * The test opens the index.html selects from the dropdown and clicks submit.
 * On the resulting page it is verified that the expected content is present.
 */
 
  def port        = '8081'
  def url         = "http://localhost:${port}"
  def contextPath = "/ch4-groovy2"
  def uri         = "$url$contextPath"
  def startPage   = uri
  Browser browser 
  
  
  def setup() { browser = new Browser() }
  
  def cleanup() { browser = null}

  
  @Unroll
  def "#color should result in #advice"() {

    given:
      go startPage
      
    expect:
      $("h1").text() == "Beer Selection Page"
      
    when:
      $("select", name:"color").value(color)
      $("input").click()
      
    then:
      title == 'Beer Recommendations'
      $("h1").text() == "Beer Recommendations"
      
    expect:
      $("p").text().contains advice[0]
      $("p").text().contains advice[1]
      
    where:
      color   | advice
      'amber' | ['Jack Amber', 'Red Moose']
      'light' | ['Jail Pale Ale', 'Gout Stout']
      'brown' | ['Jail Pale Ale', 'Gout Stout']
      'dark'  | ['Jail Pale Ale', 'Gout Stout']
  }
}
