package info.martinussen.scwcd.hfsj.ch4.model

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.apache.log4j.Logger
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert

@RunWith(Parameterized)
public class TestBeerExpert{

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

  TestBeerExpert (p , ex1, ex2){
    param = p
    expected1 = ex1
    expected2 = ex2
  }

  @Test
  void testGetBrands(){
    testExpert = new BeerExpert()
    def result = testExpert.getBrands(param)
    assertTrue result.size() == 2
    assertTrue result.contains(expected1)
    assertTrue result.contains(expected2)
    testExpert = null;
  }
}