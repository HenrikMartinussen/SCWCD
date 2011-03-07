package info.martinussen.scwcd.hfsj.ch8.model;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Person {
  private static Logger log = Logger.getLogger(Person.class);
  private String name;
  private List<Dog> dogs;

  static {
    log.debug("Person was loaded");
  }
  
  public Person () {
    super();
    dogs = new ArrayList<Dog>();
    log.debug("Person was constructed");
  }
  
  public Dog getDog(int index) {
    Dog returnValue = null;
    if (index < dogs.size()){
      returnValue = dogs.get(index);
    }
    return returnValue; 
  }
  
  public void addDog(Dog dog) {
    log.debug("Person.setDog was called - Dog parameter's name property was: " + dog.getName());
    dogs.add(dog);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    log.debug("Person.setName was called - name parameter was: " + name);
    this.name = name;
  }

  public int getDogCount() {
    // TODO Auto-generated method stub
    return dogs.size();
  }
}
