package info.martinussen.scwcd.hfsj.ch8.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestDog {

  private String testName1;
  private String testRace1;
  private String testName2;
  private String testRace2;
  private boolean expected;
  
  private Dog testDog1;
  private Dog testDog2;

  @Parameters
  public static Collection<Object[]> getTestParameters(){
    return Arrays.asList(new Object[][]{
        {"Wolfie", "German Shepherd", "Wolfie", "German Shepherd", true }, // name1, race1, name2, race2, expected
        {"Wolfie", "German Shepherd", "wolfie", "German Shepherd", true }, //equals ignores case
        {"Wolfie", "German Shepherd", "Wolfie", "German shepherd", true }, //equals ignores case
        {"King",   "Great Dane",      "King",   "Poodle",          false},
        {"Wolfie", "German Shepherd", "King",   "Great Dane",      false},
        {"King",   "German Shepherd", "Wolfie", "German Shepherd", false},
        {null,     "German Shepherd", "Wolfie", "German Shepherd", false},
        {"Wolfie", null,              "Wolfie", "German Shepherd", false},
        {"Wolfie", "German Shepherd", null,     "German Shepherd", false},
        {"Wolfie", "German Shepherd", "Wolfie", null,              false},
        {null,     "German Shepherd", null,     "German Shepherd", false},
        {"Wolfie", null,              "Wolfie", null,              false},
        {null,     null,              null,     null,              false}
    });
  }
  
  public TestDog(String testName1, String testRace1, String testName2, String testRace2, boolean expected){
    this.testName1 = testName1;
    this.testRace1 = testRace1;
    this.testName2 = testName2;
    this.testRace2 = testRace2;
    this.expected  = expected;
  }
  
  @Before
  public void setUp() throws Exception {
    testDog1 = new Dog();
    testDog1.setName(testName1);
    testDog1.setRace(testRace1);
    testDog2 = new Dog();
    testDog2.setName(testName2);
    testDog2.setRace(testRace2);
  }

  @After
  public void tearDown() throws Exception {
    testDog1 = null;
    testDog2 = null;
  }

  @Test
  public void testEqualsObject() {
    assertEquals(expected, testDog1.equals(testDog2));    
    assertEquals(expected, testDog2.equals(testDog1));    
  }
}
