package info.martinussen.scwcd.hfsj.ch6.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

public class MyHttpSessionAttributeListener implements
    HttpSessionAttributeListener {
  
  private static Logger log = Logger.getLogger(MyHttpSessionAttributeListener.class);
  
  public void attributeAdded(HttpSessionBindingEvent arg0) {
    log.debug("HttpSessionAttribute added");
  }

  public void attributeRemoved(HttpSessionBindingEvent arg0) {
    log.debug("HttpSessionAttribute removed");
  }

  public void attributeReplaced(HttpSessionBindingEvent arg0) {
    log.debug("HttpSessionAttribute replaced");
  }

}
