package info.martinussen.scwcd.hfsj.ch4.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * "Junit in action" p 17 - "Running parameterized tests"
 * @author HMS
 */
@RunWith(value = Parameterized.class)
public class TestBeerExpert {
  private ProductKey testKey = null;
  
  private String testVersion;
  private String expected;
  
  @Parameters
  public static Collection<String[]> getTestParameters(){
    return Arrays.asList(new String[][]{
        {"Light",        "Light"}, // value, expected
        {"Basic",        "Basic"},
        {"Standard",     "Standard"},
        {"Enterprise",   "Enterprise"}
    });
  }
  
  public TestBeerExpert(String testVersion, String expected){
    this.testVersion = testVersion;
    this.expected = expected;
  }
  
  @Before
  public void setUp() throws Exception {
    testKey = new ProductKey();
  }

  @After
  public void tearDown() throws Exception {
    testKey = null;
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testGetBrandsForTestParameters() {
    String result = testKey.getKeyAsXmlString(testVersion);
    assertTrue(result.contains(expected));
  }
}
