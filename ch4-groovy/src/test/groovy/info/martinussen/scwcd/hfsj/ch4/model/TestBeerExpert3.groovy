package info.martinussen.scwcd.hfsj.ch4.model
import spock.lang.Specification
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;

class TestBeerExpert3 extends Specification{
  
  BeerExpert testExpert = null;
  
  def setup() { testExpert = new BeerExpert() }
  
  def cleanup() { testExpert = null}

  def "BeerExpert returns Jack Amber and Red Moose for color amber"(){
    expect: testExpert.getBrands('amber') == ['Jack Amber', 'Red Moose'] 
  }  
 
  def "BeerExpert returns Jail Pale Ale and Gout Stout for color light"(){
    expect: testExpert.getBrands('light') == ['Jail Pale Ale', 'Gout Stout']
  }  
  
  def "BeerExpert returns Jail Pale Ale and Gout Stout for color brown"(){
    expect: testExpert.getBrands('brown') == ['Jail Pale Ale', 'Gout Stout']
  }  
  
  def "BeerExpert returns Jail Pale Ale and Gout Stout for color dark"(){
    expect: testExpert.getBrands('dark') == ['Jail Pale Ale', 'Gout Stout']
  }  
  
}