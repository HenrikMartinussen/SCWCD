package info.martinussen.scwcd.hfsj.ch4.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
  
  static {
    System.out.println("BeerExpert is loaded");
  }
  
  public BeerExpert(){
    System.out.println("BeerExpert is constructed");
  }
  
  public List<String> getBrands(String color){
    System.out.println("BeerExpert.getBrands() is called, parameter color was: " + color);
    List<String> brands = new ArrayList<String>();
    if (color.equals("amber")){
      brands.add("Jack Amber");
      brands.add("Red Moose");
    } else {
      brands.add("Jail Pale Ale");
      brands.add("Gout Stout");
    }
    System.out.println("BeerExpert.getBrands() returns: " + brands);
    return brands;
  }

}
