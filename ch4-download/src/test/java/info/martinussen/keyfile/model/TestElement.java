package info.martinussen.keyfile.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElement {

  private Element testElement = null;
  
  @Test
  public void testConstructorWithArgument() {
    testElement = new Element("Version");
    assertEquals("<Version>", testElement.getStartTag());
    assertEquals("</Version>", testElement.getEndTag());
    assertEquals("<Version/>", testElement.toString());
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
