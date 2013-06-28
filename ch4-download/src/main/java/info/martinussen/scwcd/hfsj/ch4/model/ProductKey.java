package info.martinussen.scwcd.hfsj.ch4.model;

import org.apache.log4j.Logger;

public class ProductKey {
  static Logger log = Logger.getLogger(ProductKey.class);
  
  static {
    log.debug("ProductKey is loaded");
  }
  
  public ProductKey(){
    log.debug("ProductKey is constructed");
  }
  
  public String getKeyAsXmlString(String version) {
    log.debug("BeerExpert.getKeyAsXml() is called, parameter color was: " + version);
    log.debug("BeerExpert.getKeyAsXml() returns: " + version);
    return version;
  }

}
