package info.martinussen.scwcd.hfsj.ch6.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class MyServletContextListener implements ServletContextListener {
  private static Logger log = Logger.getLogger(MyServletContextListener.class);

  public void contextDestroyed(ServletContextEvent event) {
    log.debug("contextDestroyed: " + event.getServletContext().getServletContextName());
  }

  public void contextInitialized(ServletContextEvent event) {
    log.debug("contextInitialized: " + event.getServletContext().getServletContextName());
  }

}
