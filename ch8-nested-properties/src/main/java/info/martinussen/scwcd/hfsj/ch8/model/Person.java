package info.martinussen.scwcd.hfsj.ch8.model;

import org.apache.log4j.Logger;

public class Person {
  private static Logger log = Logger.getLogger(Person.class);
  private String name;
  private Dog dog;

  public Person () {
    super();
    log.debug("Person was constructed");
  }
  
  public Dog getDog() {
    return dog;
  }
  
  public void setDog(Dog dog) {
    log.debug("Person.setDog was called - Dog parameter's name property was: " + dog.getName());
    this.dog = dog;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    log.debug("Person.setName was called - name parameter was: " + name);
    this.name = name;
  }
}
