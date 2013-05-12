package info.martinussen.scwcd.hfsj.ch4.model

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.log4j.Logger;

@RunWith(Parameterized)
public class TestBeerExpert2{ //TODO verify that this class is really executed
  
  Logger log = Logger.getLogger(TestBeerExpert.class)
  
  BeerExpert testExpert = null;
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
  
  TestBeerExpert2 (p , ex1, ex2){ //constructor utilizing the parameters
	param = p
	expected1 = ex1
	expected2 = ex2
  }
  
  @Test
  void testBeerExpertAmber(){ //runs once for each String array returned by data()
	testExpert = new BeerExpert()
	def result = testExpert.getBrands(param)
	assertTrue result.size() == 2 
	assertTrue result.contains(expected1)
	assertTrue result.contains(expected2)
	testExpert = null;
  }
  
}