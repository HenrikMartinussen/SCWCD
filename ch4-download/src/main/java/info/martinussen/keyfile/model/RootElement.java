package info.martinussen.keyfile.model;

public class RootElement extends Element {
  
  private static final String CR_LF = "\r\n";

  public RootElement(String name) {
    super(name);
  }
  
  public String toString(){
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + CR_LF +  super.toString();
  }
}
