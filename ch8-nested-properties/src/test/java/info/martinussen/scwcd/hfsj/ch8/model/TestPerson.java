package info.martinussen.scwcd.hfsj.ch8.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerson {
  Person testPerson = null;
  private Dog testDog1;
  private Dog testDog2;

  @Before
  public void setUp() throws Exception {
    testPerson = new Person();
    testDog1 = new Dog();
    testDog1.setName("Fido");
    testPerson.addDog(testDog1);
    
    testDog2 = new Dog();
    testDog2.setName("King");
    testPerson.addDog(testDog2);
  }

  @After
  public void tearDown() throws Exception {
    testPerson = null;
  }

  @Test
  public void testGetDog() {

    assertEquals(2, testPerson.getDogCount());
    assertEquals(testDog1, testPerson.getDog(0));
    assertEquals(testDog1.getName(), testPerson.getDog(0).getName());
    assertEquals(testDog2, testPerson.getDog(1));
    assertEquals(testDog2.getName(), testPerson.getDog(1).getName());
  }

  @Test
  public void testAddDog() {
    Dog testDog3 = new Dog();
    testDog3.setName("Odie");
    testPerson.addDog(testDog3);
    assertEquals(3, testPerson.getDogCount());
    assertEquals(testDog3, testPerson.getDog(2));
    assertEquals(testDog3.getName(), testPerson.getDog(2).getName());
  }
  
  @Test
  public void testGetNonExistingDog (){
    assertNull(testPerson.getDog(800));
  }
  

}
