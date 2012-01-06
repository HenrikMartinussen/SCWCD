package info.martinussen.scwcd.hfsj.ch4.model

import static org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.junit.After
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.log4j.Logger;

public class TestBeerExpert{
  
  Logger log = Logger.getLogger(TestBeerExpert.class)
  
  BeerExpert testExpert = null;
  
  @Before
  void setup(){
    testExpert = new BeerExpert();
  }
  
  @After
  void tearDown(){
	  testExpert = null;
	  log.debug "testExpert was nulled"
  }
  
  @Test
  void testBeerExpertAmber(){
    def expected = ["Jack Amber", "Red Moose"] 
    assertEquals expected, testExpert.getBrands("amber")
  }
  
  @Test
  void testBeerExpertLight(){
    def expected = ["Jail Pale Ale", "Gout Stout"] 
    assertEquals expected, testExpert.getBrands("light")
  }
  
  @Test
  void testBeerExpertBrown(){
    def expected = ["Jail Pale Ale", "Gout Stout"] 
    assertEquals expected, testExpert.getBrands("brown")
  }

  @Test
  void testBeerExpertDark(){
    def expected = ["Jail Pale Ale", "Gout Stout"] 
    assertEquals expected, testExpert.getBrands("dark")
  }
  
}