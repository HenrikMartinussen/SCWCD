package info.martinussen.scwcd.hfsj.ch4.integration

import org.ccil.cowan.tagsoup.Parser
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger


class BeerGroovlet2IntegrationTest {
  
  def  log = Logger.getLogger(BeerGroovlet2IntegrationTest.class)
  

  @After
  void tearDown(){
    
  }
  
  
  @Test
  public void testAmber(){
    def gHtml = new URL("http://localhost:8081/ch4-groovy2").withReader { r ->
      new XmlSlurper( new Parser() ).parse( r )
    }
    
    log.debug( gHtml.body.text())
    
  }
  

}
