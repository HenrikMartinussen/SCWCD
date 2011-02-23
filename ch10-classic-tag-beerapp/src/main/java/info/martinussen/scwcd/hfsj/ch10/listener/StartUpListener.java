package info.martinussen.scwcd.hfsj.ch10.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpListener implements ServletContextListener{

  ServletContext context = null;
  
  public void contextInitialized(ServletContextEvent event) {
    System.out.println("in contextInitialized");
    context = event.getServletContext();
    
    
  }

  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("in contextDestroyed");
  }


}
