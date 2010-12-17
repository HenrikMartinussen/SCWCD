package info.martinussen.scwcd.hfsj.ch8.model;

public class Person {
  private String name;
  private Dog dog;

  public Person () {
    super();
  }
  
  public Dog getDog() {
    return dog;
  }
  
  public void setDog(Dog dog) {
    this.dog = dog;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("Person.setName was called - name parameter was: " + name);
    this.name = name;
  }
}
