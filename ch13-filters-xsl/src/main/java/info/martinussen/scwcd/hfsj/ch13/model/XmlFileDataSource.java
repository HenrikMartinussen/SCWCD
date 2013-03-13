package info.martinussen.scwcd.hfsj.ch13.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

public class XmlFileDataSource implements XmlDataSource{
  
  private static final String RESOURCE = "/bookstore.xml";
  private static Logger log = Logger.getLogger(XmlFileDataSource.class);
  
  
  
  static {
    log.trace("XmlFileDataSource loaded");
  }
  
  public XmlFileDataSource(){
    log.trace("XmlFileDataSource constructed");
  }
  
  public String getXmlData(){
    String returnValue = null;
    
    InputStream in  = this.getClass().getResourceAsStream(RESOURCE);
    if (in != null){
      log.debug("resource retrieved successfully");
    } else {
      log.error("error retrieving resource");
    }
    
    try {
      returnValue =  streamToString(in);
    } catch (IOException e) {
      log.warn("XmlDataSource.getXmlData(): An IOException was caught, null will be returned - " + e);
    }
    return returnValue;
  }

  private String streamToString(InputStream inputStream) throws IOException {
    StringBuilder builder = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    

    String line = br.readLine();
    while (line != null) {
      builder.append(line);
      line = br.readLine();
    }
    br.close();
    log.debug(builder.toString());
    return builder.toString();
  }

  public void setServletContext(ServletContext servletContext) {
    // TODO Auto-generated method stub
    
  }

  public boolean isInitialized() {
    // TODO Auto-generated method stub
    return false;
  }

  public void init() {
    // TODO Auto-generated method stub
    
  }

}
