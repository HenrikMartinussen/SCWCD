package info.martinussen.scwcd.hfsj.ch4.model;

import java.util.ArrayList;
import java.util.List;

public class BeerSizeExpert {
  public List<String> getBrands(String[] canSizes){
    List<String> brands = new ArrayList<String>();
    
    for (int i = 0; i < canSizes.length; i++){
      if (canSizes[i]. equals("22oz")){
        brands.add("Carls Dark Stout Magnum");
      }
      if (canSizes[i].equals("16oz")){
        brands.add("Hoegaarden");
      }
      if (canSizes[i].equals("12oz")){
        brands.add("Carlsberg Gold 25");
      }
    }
    return brands;
  }

}
