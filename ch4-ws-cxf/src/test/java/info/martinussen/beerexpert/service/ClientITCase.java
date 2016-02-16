package info.martinussen.beerexpert.service;

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
 * Integration test running in the integration-test phase of the maven build
 * Tests that the service implementation returns correct results for the 
 * same input parameters as the unit test of BeerExpert. 
 * The BeerExpertServiceClient is used in the test 
 *
 */
@RunWith(value = Parameterized.class)
public class ClientITCase {

 private BeerExpertServiceClient testClient = null;
  
  private String testColor;
  private String expected1;
  private String expected2;
  
  @Parameters
  public static Collection<String[]> getTestParameters(){
    return Arrays.asList(new String[][]{
        {"amber", "Jack Amber", "Red Moose"}, // value, expected1, expected2
        {"light", "Jail Pale Ale", "Gout Stout"},
        {"brown", "Jail Pale Ale", "Gout Stout"},
        {"dark",  "Jail Pale Ale", "Gout Stout"}
    });
  }
  
  public ClientITCase(String testColor, String expected1, String expected2){
    this.testColor = testColor;
    this.expected1 = expected1;
    this.expected2 = expected2;
  }
  
  @Before
  public void setUp() throws Exception {
    testClient = new BeerExpertServiceClient();
  }

  @After
  public void tearDown() throws Exception {
    testClient = null;
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testGetBrandsForTestParameters() {
    List<String> result = testClient.getBrands(testColor);
    assertEquals(2, result.size());
    assertTrue(result.contains(expected1));
    assertTrue(result.contains(expected2));
  }

}
