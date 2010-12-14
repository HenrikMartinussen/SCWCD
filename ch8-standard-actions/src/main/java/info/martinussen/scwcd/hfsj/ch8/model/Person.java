package info.martinussen.scwcd.hfsj.ch8.model;

public abstract class Person {
  private String name;

  public Person () {
    super();
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
