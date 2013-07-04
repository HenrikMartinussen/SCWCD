package info.martinussen.keyfile.model;

import java.util.ArrayList;
import java.util.List;

public class Element {
  
  private String name = "";
  private String value = "";
  private List<Element> children = null;
  
  private Element(){
    super();
  }
  
  public Element(String name){
    this();
    setName(name);
  }
  
  public Element(String name, String value){
    this(name);
    setValue(value);
  }
  
  public void setValue(String value) {
    this.value = value;
  }

  public void setValue(int number) {
    this.value = Integer.toString(number);
  }

  public void setValue(boolean value) {
    this.value = Boolean.toString(value);
  }

  private void setName (String name){
    if (nullOrEmpty(name)) throw new IllegalArgumentException();
    this.name = name;
  }
  
  public void addChild(Element child){
    if (child == null) throw new NullPointerException();
    if (!value.equals("")) throw new IllegalArgumentException();
    if (children == null){
      children = new ArrayList<Element>();
    }
    children.add(child);
  }
  
  public String getStartTag(){
    if (nullOrEmpty(name)) throw new IllegalStateException();
    return "<" + name + ">";
  }
  
  public String getEndTag(){
    if (nullOrEmpty(name)) throw new IllegalStateException();
    return "</" + name + ">";
  }

  public String toString(){
    String returnValue = "";
    if (nullOrEmpty(value)){
      if (children != null){
        returnValue = getStartTag() + "\r\n";
        for (Element child : children){
          String childString = child.toString();
          String[] lines = childString.split("\r\n");
          for (String childStringLines : lines){
            returnValue += "    " +  childStringLines + "\r\n";
          }
        }
        returnValue += getEndTag();
      } else { //no children
        returnValue = "<" +  name + "/>";
      }
    } else { //has value
      returnValue = getStartTag() + value  + getEndTag();
    }
    return returnValue;
  }
  
  private boolean nullOrEmpty(String s) {
    return s==null || s.length() < 1;
  }

  

}
