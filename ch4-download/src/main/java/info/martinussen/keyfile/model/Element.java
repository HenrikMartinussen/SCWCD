package info.martinussen.keyfile.model;

public class Element {
  
  String name = "";
  String value = "";
  
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
      returnValue = "<" +  name + "/>";
    } else {
      returnValue = getStartTag() + value  + getEndTag();
    }
    return returnValue;
  }
  
  private boolean nullOrEmpty(String s) {
    return s==null || s.length() < 1;
  }


}
