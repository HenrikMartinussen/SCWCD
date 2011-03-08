package info.martinussen.scwcd.hfsj.ch8.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDog2 {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEqualsObject() {
    Dog testDog1 = new Dog();
    Dog testDog2 = testDog1; //testDog1 and testDog2 refers to the same object
    assertTrue(testDog1.equals(testDog2));
    assertTrue(testDog2.equals(testDog1));
  }

}
