package info.martinussen.scwcd.hfsj.ch6.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import org.apache.log4j.Logger;

public class MyServletRequestAttributeListener implements
    ServletRequestAttributeListener {
  private static Logger log = Logger.getLogger(MyServletRequestAttributeListener.class);

  public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    log.debug("requestAttributeAdded: ");
  }

  public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    log.debug("requestAttributeRemoved");
  }

  public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    log.debug("requestAttributeReplaced");
  }

}
