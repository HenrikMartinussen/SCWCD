package info.martinussen.scwcd.hfsj.ch4.model

import org.junit.Test
import org.junit.Before
import org.junit.After
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.log4j.Logger;

class TestBeerExpert{
  
  Logger log = Logger.getLogger(TestBeerExpert.class)
  
  BeerExpert testExpert = null;
  
  @Before
  void setup(){
    testExpert = new BeerExpert();
  }
  
  @After
  void tearDown(){
	  testExpert = null;
	  log.debug 'testExpert was nulled'
  }
  
  @Test
  void testBeerExpertAmber(){
    assert testExpert.getBrands('amber') ==  ['Jack Amber', 'Red Moose'] 
  }
  
  @Test
  void testBeerExpertLight(){
    assert testExpert.getBrands('light') == ['Jail Pale Ale', 'Gout Stout'] 
  }
  
  @Test
  void testBeerExpertBrown(){
    assert testExpert.getBrands('brown') == ['Jail Pale Ale', 'Gout Stout'] 
  }

  @Test
  void testBeerExpertDark(){
    assert testExpert.getBrands('dark') == ['Jail Pale Ale', 'Gout Stout'] 
  }
}