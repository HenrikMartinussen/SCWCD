package info.martinussen.scwcd.hfsj.ch8.model;

/*
 * hfsj p. 354
 */
public abstract class Person {
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
