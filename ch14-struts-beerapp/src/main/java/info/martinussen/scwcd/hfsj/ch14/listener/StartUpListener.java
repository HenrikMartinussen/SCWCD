package info.martinussen.scwcd.hfsj.ch14.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpListener implements ServletContextListener{

  public void contextInitialized(ServletContextEvent event) {
    System.out.println("in contextInitialized");
    ServletContext context = event.getServletContext();
    String breed = context.getInitParameter("Breed");
  }

  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("in contextDestroyed");
  }


}
