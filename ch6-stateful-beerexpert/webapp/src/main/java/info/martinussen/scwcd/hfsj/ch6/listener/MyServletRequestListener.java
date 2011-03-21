package info.martinussen.scwcd.hfsj.ch6.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.log4j.Logger;

public class MyServletRequestListener implements ServletRequestListener {
  private static Logger log = Logger.getLogger(MyServletRequestListener.class);
  
  public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    log.debug("requestInitialized: " + servletRequestEvent.getServletRequest().getLocalName());
  }

  public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    log.debug("requestDestroyed: " + servletRequestEvent.getServletRequest().getLocalName());
  }


}
