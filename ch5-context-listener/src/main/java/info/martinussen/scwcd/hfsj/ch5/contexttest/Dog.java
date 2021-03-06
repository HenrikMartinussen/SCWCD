package info.martinussen.scwcd.hfsj.ch5.contexttest;

import org.apache.log4j.Logger;

public class Dog{

  private static Logger log = Logger.getLogger(Dog.class);
  private String breed;
  
  static {
    log.debug("Dog class is loaded");
  }

  public Dog(String breed) {
    log.debug("Dog object is constructed, Breed is: " + breed);
    this.breed = breed; 
  }

  public String getBreed() {
    return breed;
  }
}
