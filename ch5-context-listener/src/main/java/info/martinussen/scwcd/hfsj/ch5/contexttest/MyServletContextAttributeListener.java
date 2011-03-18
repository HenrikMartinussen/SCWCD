package info.martinussen.scwcd.hfsj.ch5.contexttest;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import org.apache.log4j.Logger;


public class MyServletContextAttributeListener implements ServletContextAttributeListener {

  private static Logger log = Logger.getLogger(MyServletContextAttributeListener.class);  
  
  public void attributeAdded(ServletContextAttributeEvent event) {
    log.debug("contextAttribute added; " + event.getName());
  }

  public void attributeRemoved(ServletContextAttributeEvent event) {
    log.debug("contextAttribute removed");
  }

  public void attributeReplaced(ServletContextAttributeEvent event) {
    log.debug("contextAttribute replaced");
  }
}
