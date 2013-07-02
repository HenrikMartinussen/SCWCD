package info.martinussen.keyfile.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class TestRootElement {

  private Element testElement = null;
  
  @After
  public void tearDown(){
    testElement = null;
  }
  
  @Test
  public void testConstructorWithArgument() {
    testElement = new RootElement("KeyFile");
    assertEquals("<KeyFile>", testElement.getStartTag());
    assertEquals("</KeyFile>", testElement.getEndTag());
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><KeyFile/>", testElement.toString());
  }

  @Test (expected=IllegalArgumentException.class)
  public void testConstructorWithEmptyArgument(){
    testElement = new Element("");
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void testConstructorWithNullArgument(){
    testElement = new Element(null);
  }
  
  
  

}
