package info.martinussen.scwcd.hfsj.ch6.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class MyHttpSessionListener implements HttpSessionListener {
  private static Logger log = Logger.getLogger(MyHttpSessionListener.class);

  public void sessionCreated(HttpSessionEvent event) {
    log.debug("SessionCreated: " + event.getSession().getId());
  }

  public void sessionDestroyed(HttpSessionEvent event) {
    log.debug("SessionDestroyed: " + event.getSession().getId());
  }

}
