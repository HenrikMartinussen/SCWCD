package info.martinussen.scwcd.hfsj.ch8.model;

import org.apache.log4j.Logger;

public class Dog {
  private static Logger log = Logger.getLogger(Dog.class);
  private String name;
  
  public Dog(){
    super();
    log.debug("Dog was constructed");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    log.debug("Dog.setName was called, name parameter was " + name);
  }

}
