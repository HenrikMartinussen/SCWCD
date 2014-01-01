package info.martinussen.degrees.model;

import static org.junit.Assert.assertEquals;
import info.martinussen.degrees.model.Converter;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestConverter {
  private Converter testConverter = null;
  
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
  
  public TestConverter(Double fahrenheit, Double celcius){
    this.fahrenheit = fahrenheit;
    this.celcius = celcius;
  }
  
  @Before
  public void setUp() throws Exception {
    testConverter = new Converter();
  }

  @After
  public void tearDown() throws Exception {
    testConverter = null;
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testToCelcius() {
    Double result = testConverter.toCelcius(this.fahrenheit); 
    assertEquals(celcius, result, 0.0001);
  }

  /**
   * Runs once for each item in the testParameters collection
   */
  @Test
  public void testToFahrenhei() {
    Double result = testConverter.toFahrenheit(this.celcius); 
    assertEquals(fahrenheit, result, 0.0001);
  }
}

