package info.martinussen.scwcd.hfsj.ch5.contexttest;

public class Dog {

  private String breed;
  
  static {
    System.out.println("Dog class is loaded");
  }

  public Dog(String Breed) {
    System.out.println("Dog object is constructed, Breed is: " + breed);
    this.breed = Breed; 
  }

  public String getBreed() {
    return breed;
  }

}
