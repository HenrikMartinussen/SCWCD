package info.martinussen.scwcd.hfsj.ch4.integration

import static groovyx.net.http.ContentType.HTML
import static org.junit.Assert.fail

import groovy.util.slurpersupport.GPathResult
import groovyx.net.http.HTTPBuilder
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized)
class BeerGroovlet2IntegrationTest {
/* Integrationtest demonstrating HTTPBuilder executing POST requests  and
 * XML slurper making the html in the response available with GPath expressions.
 * Futhermore this integrationtest demonstrates JUnit 4 parameterized test, 
 * implemented in groovy.
 * 
 * The test simulates a push on the submit button on the index.html page, and
 * verifies that the resulting page has the expected contents, corresponding 
 * to the request parameters. 
 *
 * This test doesn't verify the contents of - or navigation from the index.html page
 */
 
  def port    = '8081'
  def url     = "http://localhost:${port}"
  def path    = "/ch4-groovy2/BeerGroovlet.groovy"
  def HTTP_OK = 200
  def http 

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
  
  BeerGroovlet2IntegrationTest (p , ex1, ex2){
    param = p
    expected1 = ex1
    expected2 = ex2
  }

  @Test
  public void testAllColors(){
    http = new HTTPBuilder(url)
    def (html, responseStatus) = http.post(
                                    body:[color: param], 
                                    path:path, 
                                    contentType:HTML){ resp, reader ->
      [reader, resp.status]
    }
    assert responseStatus == HTTP_OK
    assert html instanceof GPathResult
    assert html.BODY.P.text() =~ "Try: $expected1"   
    assert html.BODY.P.text() =~ "Try: $expected2"   
  }
}
