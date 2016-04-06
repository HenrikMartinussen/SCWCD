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
        brands.put("dark",  Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("light", Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("brown", Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"}));
        brands.put("amber", Arrays.asList(new String[]{"Jack Amber", "Red Moose"}));
    }

    public List<String> getBrands(String color){
        log.debug("BeerExpert.getBrands() is called, parameter color was: " + color);

        List<String> advice = brands.get(color);

        log.trace("BeerExpert.getBrands() returns: " + advice);
        return advice;
    }

    public String getBrandsAsXml(String color){
        log.debug("BeerExpert.getBrandsAsXml() is called, parameter color was: " + color);

        List<String> advice = brands.get(color);

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<advice>");
        for (String brand : advice){
            xmlBuilder.append("<brand>");
            xmlBuilder.append(brand);
            xmlBuilder.append("</brand>");
        }
        xmlBuilder.append("</advice>");

        log.trace("BeerExpert.getBrandsAsXml() returns: " + xmlBuilder.toString());
        return xmlBuilder.toString();
    }
}