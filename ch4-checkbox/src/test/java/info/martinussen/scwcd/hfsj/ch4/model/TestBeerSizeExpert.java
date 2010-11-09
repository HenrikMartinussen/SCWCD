package info.martinussen.scwcd.hfsj.ch4.model;

import java.util.List;

import junit.framework.TestCase;

public class TestBeerSizeExpert extends TestCase {
  private BeerSizeExpert testExpert = null;

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    testExpert = null;
    super.tearDown();
  }

  public void testGetBrandsForAmber() {
    testExpert = new BeerSizeExpert();
    List<String> result = testExpert.getBrands(new String[]{"12oz", "16oz"});
    assertEquals(2, result.size());
    assertTrue(result.contains("Hoegaarden"));
    assertTrue(result.contains("Carlsberg Gold 25"));
  }

  public void testGetBrandsForDark() {
    testExpert = new BeerSizeExpert();
    List<String> result = testExpert.getBrands(new String[]{"16oz", "22oz"});
    assertEquals(2, result.size());
    assertTrue(result.contains("Carls Dark Stout Magnum"));
    assertTrue(result.contains("Hoegaarden"));
  }

}
