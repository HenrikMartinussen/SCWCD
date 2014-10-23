package info.martinussen.scwcd.hfsj.ch4.integration

import static groovyx.net.http.ContentType.URLENC
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger


class BeerGroovlet2IntegrationTest {
  
  def  log = Logger.getLogger(BeerGroovlet2IntegrationTest.class)
  def port = '8081'
  def url = "http://localhost:${port}/ch4-groovy2/BeerGroovlet.groovy"
  def httpBuilder 
  

  @After
  void tearDown(){
    
  }
  
  
  @Test
  public void testAmber(){
    httpBuilder = new HTTPBuilder(url)
    def postBody = [color: 'light']
    http.post(path: url, body:postBody, requestContenttype: URLENC){ resp ->
      assert resp.statusLine.statusCode == 200
    }
    
    log.debug(resp)
    
  }
  

}
