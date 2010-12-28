package info.martinussen.scwcd.hfsj.ch9;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

  public void sessionCreated(HttpSessionEvent arg0) {
    System.out.println("Session was created");
  }

  public void sessionDestroyed(HttpSessionEvent arg0) {
    System.out.println("Session was destroyed");
  }

}
