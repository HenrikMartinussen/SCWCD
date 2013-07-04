package info.martinussen.keyfile.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestElement {

  private Element testElement = null;
  private static final String CR_LF = "\r\n";
  
  @After
  public void tearDown(){
    testElement = null;
  }
  
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
  
 @Test
 public void testElementWithChild(){
   testElement = new Element("Mother");
   Element child = new Element("Child");
   testElement.addChild(child);
   assertEquals("<Mother>" + CR_LF + "    <Child/>"+ CR_LF + "</Mother>", testElement.toString());
 }
 
 @Test
 public void testElementWithChildren(){
   testElement = new Element("Mother");
   Element child1 = new Element("Peter");
   Element child2 = new Element("Paul");
   Element child3 = new Element("Mary");
   testElement.addChild(child1);
   testElement.addChild(child2);
   testElement.addChild(child3);
   assertEquals("<Mother>" + CR_LF + "    <Peter/>" + CR_LF + "    <Paul/>" + CR_LF + "    <Mary/>" + CR_LF + "</Mother>", testElement.toString());
 }

 @Test
 public void testElementWithChildWithValue(){
   testElement = new Element("Mother");
   Element child = new Element("Child");
   child.setValue(42);
   testElement.addChild(child);
   assertEquals("<Mother>" + CR_LF + "    <Child>42</Child>" + CR_LF + "</Mother>", testElement.toString());
 }
 
 @Test
 public void testElementWithChildrenWithValues(){
   testElement = new Element("Mother");
   Element child1 = new Element("Peter");
   Element child2 = new Element("Paul");
   Element child3 = new Element("Mary");
   child1.setValue(13);
   child2.setValue(10);
   child3.setValue(8);
   testElement.addChild(child1);
   testElement.addChild(child2);
   testElement.addChild(child3);
   assertEquals("<Mother>" + CR_LF + 
                "    <Peter>13</Peter>" + CR_LF + 
                "    <Paul>10</Paul>" + CR_LF + 
                "    <Mary>8</Mary>" + CR_LF + 
                "</Mother>", testElement.toString());
 }
 
 @Test
 public void testElementWithGrandChild(){
   testElement = new Element("Mother");
   Element child = new Element("Child");
   Element grandChild =  new Element("GrandChild");
   child.addChild(grandChild);
   testElement.addChild(child);
   assertEquals("<Mother>" + CR_LF +
                "    <Child>" + CR_LF + 
                "        <GrandChild/>" + CR_LF + 
                "    </Child>" + CR_LF +
                "</Mother>", testElement.toString());
 }
 
 @Test
 public void testElementWithGrandChildWithValue(){
   testElement = new Element("Mother");
   Element child = new Element("Child");
   Element grandChild =  new Element("GrandChild");
   grandChild.setValue("Dirty diaper");
   child.addChild(grandChild);
   testElement.addChild(child);
   assertEquals("<Mother>" + CR_LF +
                "    <Child>" + CR_LF + 
                "        <GrandChild>Dirty diaper</GrandChild>" + CR_LF +
                "    </Child>" + CR_LF +
                "</Mother>", testElement.toString());
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testElementWithChildAndValue(){
   testElement = new Element("Mother");
   testElement.setValue(42);
   Element child = new Element("Child");
   testElement.addChild(child);
 }
 
 @Test(expected=NullPointerException.class)
 public void testElementWithNullChild(){
   testElement = new Element("Mother");
   testElement.addChild(null);
 }
}
