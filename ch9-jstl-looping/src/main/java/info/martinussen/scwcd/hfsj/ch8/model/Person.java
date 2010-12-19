package info.martinussen.scwcd.hfsj.ch8.model;

public class Person {
  private String name;

  public Person () {
    super();
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("Person.setName was called - name parameter was: " + name);
    this.name = name;
  }
}
