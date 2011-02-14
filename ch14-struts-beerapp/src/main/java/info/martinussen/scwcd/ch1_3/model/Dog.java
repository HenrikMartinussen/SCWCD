package info.martinussen.scwcd.ch1_3.model;


public class Dog {
  private String breed;
  
  public Dog(){
    
  }
  
  public Dog(String breed){
    this();
    this.setBreed(breed);
  }
  
  public void setBreed(String breed){
    this.breed = breed;
  }
  
  public String getBreed(){
    return breed;
  }

}
