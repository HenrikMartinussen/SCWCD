package info.martinussen.keyfile.model;

public class RootElement extends Element {

  public RootElement(String name) {
    super(name);
  }
  
  public String toString(){
    String returnValue = "";
    returnValue = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    returnValue += super.toString();
    return returnValue;
  }

}
