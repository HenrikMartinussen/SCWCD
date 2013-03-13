package info.martinussen.scwcd.hfsj.ch13.model;

import javax.servlet.ServletContext;

public interface XmlDataSource {

  String getXmlData();

  void setServletContext(ServletContext servletContext);
  
  boolean isInitialized();

  void init();

}
