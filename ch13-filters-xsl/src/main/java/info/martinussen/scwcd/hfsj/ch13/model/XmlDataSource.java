package info.martinussen.scwcd.hfsj.ch13.model;

import java.io.InputStream;

import org.apache.log4j.Logger;

public class XmlDataSource {
  
  private static Logger log = Logger.getLogger(XmlDataSource.class);
  
  static {
    log.trace("XmlDataSource loaded");
  }
  
  public XmlDataSource(){
    InputStream in  = this.getClass().getResourceAsStream("/bookstore.xml");
    if (in != null){
      log.debug("resource retrieved successfully");
    } else {
      log.error("error retrieving resource");
    }
  }

}
