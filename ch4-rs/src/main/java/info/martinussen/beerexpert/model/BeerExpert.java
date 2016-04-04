package info.martinussen.beerexpert.model;

import org.apache.log4j.Logger;

import java.util.*;

public class BeerExpert {
    static Logger log = Logger.getLogger(BeerExpert.class);

    Map<String, List<String>> brands = new HashMap<String, List<String>>();

    static {
        log.debug("BeerExpert is loaded");
    }

    public BeerExpert(){
        log.debug("BeerExpert is constructed");
        brands.put("dark", Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("light", Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("brown", Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("amber", Arrays.asList(new String[]{"Jack Amber", "Red Moose"}));
    }

    public List<String> getBrands(String color){
        log.debug("BeerExpert.getBrands() is called, parameter color was: " + color);
        List<String> brands = new ArrayList<String>();
        if (color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        log.debug("BeerExpert.getBrands() returns: " + brands);
        return brands;
    }

    public String getBrandsAsXml(String color){

        return "amber".equals(color) ? "<advice><brand>Jack Amber</brand><brand>Red Moose</brand></advice>" : "<advice><brand>Jail Pale Ale</brand><brand>Gout Stout</brand></advice>";
    }

}