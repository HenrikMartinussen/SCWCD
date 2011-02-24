package info.martinussen.scwcd.hfsj.ch7.model;

import java.util.List;

import junit.framework.TestCase;

/**
 * hfsj p 300
 * @author Henrik
 */
public class TestHobbyArchive extends TestCase {
  private HobbyArchive testHobbies = null;

  protected void setUp() throws Exception {
    testHobbies = new HobbyArchive();
    super.setUp();
  }

  protected void tearDown() throws Exception {
    testHobbies = null;
    super.tearDown();
  }

  public void testGetBrandsForAmber() {
    List<String> names = testHobbies.getNames("extreme knitting");
    assertEquals(3, names.size());
    assertTrue(names.contains("Fred"));
    assertTrue(names.contains("Pradeep"));
    assertTrue(names.contains("Philippe"));
  }

  public void testGetBrandsForDark() {
    List<String> names = testHobbies.getNames("horse skiing");
    assertEquals(2, names.size());
    assertTrue(names.contains("Jack"));
    assertTrue(names.contains("Anna"));
  }

  public void testGetBrandsForLight() {
    List<String> names = testHobbies.getNames("alpine scuba");
    assertEquals(2, names.size());
    assertTrue(names.contains("Jack"));
    assertTrue(names.contains("Anna"));
  }
  
  public void testGetBrandsForBrown() {
    List<String> names = testHobbies.getNames("speed dating");
    assertEquals(2, names.size());
    assertTrue(names.contains("Jack"));
    assertTrue(names.contains("Anna"));
  }
}
