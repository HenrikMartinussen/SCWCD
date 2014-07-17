package info.martinussen.scwcd.hfsj.ch4.model
import spock.lang.Specification
import spock.lang.Unroll
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;

class TestBeerExpert4 extends Specification{
  
  BeerExpert testExpert = null;
  
  def setup() { testExpert = new BeerExpert() }
  
  def cleanup() { testExpert = null}

  
  @Unroll
  def "#color should result in #advice"() {
  
  expect: testExpert.getBrands(color) == advice
  
  where:
  color   | advice
  'amber' | ['Jack Amber', 'Red Moose'] 
  'light' | ['Jail Pale Ale', 'Gout Stout']
  'brown' | ['Jail Pale Ale', 'Gout Stout']
  'dark'  | ['Jail Pale Ale', 'Gout Stout']
  }
  
}