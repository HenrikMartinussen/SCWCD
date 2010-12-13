package info.martinussen.scwcd.hfsj.ch4.model;

import java.util.List;

import junit.framework.TestCase;

public class TestBeerExpert extends TestCase {
  private BeerExpert testExpert = null;

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    testExpert = null;
    super.tearDown();
  }

  public void testGetBrandsForAmber() {
    testExpert = new BeerExpert();
    List<String> result = testExpert.getBrands("amber");
    assertEquals(2, result.size());
    assertTrue(result.contains("Jack Amber"));
    assertTrue(result.contains("Red Moose"));
  }

  public void testGetBrandsForDark() {
    testExpert = new BeerExpert();
    List<String> result = testExpert.getBrands("dark");
    assertEquals(2, result.size());
    assertTrue(result.contains("Jail Pale Ale"));
    assertTrue(result.contains("Gout Stout"));
  }

  public void testGetBrandsForLight() {
    testExpert = new BeerExpert();
    List<String> result = testExpert.getBrands("light");
    assertEquals(2, result.size());
    assertTrue(result.contains("Jail Pale Ale"));
    assertTrue(result.contains("Gout Stout"));
  }
  
  public void testGetBrandsForBrown() {
    testExpert = new BeerExpert();
    List<String> result = testExpert.getBrands("brown");
    assertEquals(2, result.size());
    assertTrue(result.contains("Jail Pale Ale"));
    assertTrue(result.contains("Gout Stout"));
  }
}
