package info.martinussen.degrees.service;

import static org.junit.Assert.assertEquals;

import info.martinussen.degrees.service.DegreesServiceClient;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Integration test running in the integration-test phase of the maven build
 * Tests that the service implementation returns correct results for the 
 * same input parameters as the unit test of Converter. 
 * The DegreesServiceClient is used in the test 
 *
 */
@RunWith(value = Parameterized.class)
public class ClientITCase {

  private DegreesServiceClient testClient = null;
  
  private Double fahrenheit;
  private Double celcius;
  
  @Parameters
  public static Collection<Double[]> getTestParameters(){
    return Arrays.asList(new Double[][]{
        {32.0, 0.0},     // fahrenheit, celcius
        {0.0, -17.7778}, // fahrenheit, celcius
        {212.0, 100.0},  // fahrenheit, celcius
    });
  }
  
  public ClientITCase(Double fahrenheit, Double celcius){
    this.fahrenheit = fahrenheit;
    this.celcius = celcius;
  }
  
  @Before
  public void setUp() throws Exception {
    testClient = new DegreesServiceClient();
  }

  @After
  public void tearDown() throws Exception {
    testClient = null;
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testToCelcius() {
    Double result = testClient.convertToCelsius(this.fahrenheit); 
    assertEquals(celcius, result, 0.0001);
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testToFahrenhei() {
    Double result = testClient.convertToFahrenheit(this.celcius); 
    assertEquals(fahrenheit, result, 0.0001);
  }

}
