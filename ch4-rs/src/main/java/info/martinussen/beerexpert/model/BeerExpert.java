package info.martinussen.beerexpert.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    static Logger log = Logger.getLogger(BeerExpert.class);

    static {
        log.debug("BeerExpert is loaded");
    }

    public BeerExpert(){
        log.debug("BeerExpert is constructed");
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

}