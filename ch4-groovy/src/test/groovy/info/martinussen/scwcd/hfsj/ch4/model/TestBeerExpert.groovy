package info.martinussen.scwcd.hfsj.ch4.model

import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.log4j.Logger;


public class TestBeerExpert extends GroovyTestCase{
  
  Logger log = Logger.getLogger(TestBeerExpert.class)
  
  private BeerExpert testExpert = null;
  
  void tearDown(){
    testExpert = null;
    log.debug("testExpert was nulled")
  }
  
  void testBeerExpertAmber(){
    testExpert = new BeerExpert()
    def expected = ["Jack Amber", "Red Moose"] 
    assertEquals expected, testExpert.getBrands("amber")
  }
  
  void testBeerExpertLight(){
    testExpert = new BeerExpert()
    def expected = ["Jail Pale Ale", "Gout Stout"] 
    assertEquals expected, testExpert.getBrands("light")
  }
  
  void testBeerExpertBrown(){
    testExpert = new BeerExpert()
    def expected = ["Jail Pale Ale", "Gout Stout"] 
        assertEquals expected, testExpert.getBrands("brown")
  }

    void testBeerExpertDark(){
    testExpert = new BeerExpert()
    def expected = ["Jail Pale Ale", "Gout Stout"] 
        assertEquals expected, testExpert.getBrands("dark")
  }
  
  
}