package info.martinussen.scwcd.hfsj.ch5.contexttest;

import javax.servlet.*;

import org.apache.log4j.Logger;

/**
 * HFSJ Ch5 ServletContextListener demo
 * Page 171 
 * @author Henrik
 *
 */
public class MyServletContextListener implements ServletContextListener{
  
  private static Logger log = Logger.getLogger(MyServletContextListener.class);
  
  static {
    log.debug("MyServletContextListener is being loaded");
  }
  
  public MyServletContextListener(){
    super();
    log.debug("MyServletContextListener is being constructed");
  }

  public void contextInitialized(ServletContextEvent event) {
    log.debug("MyServletContextListener.contextInitialized has been called");
    ServletContext ctx = event.getServletContext(); //Ask the event for the ServletContext
    String dogBreed = ctx.getInitParameter("breed"); //Use the context to get the initParameter
    Dog d = new Dog(dogBreed); //Make a new dog
    ctx.setAttribute("dog", d);
  }

  public void contextDestroyed(ServletContextEvent event) {
    // Nothing to do here
    log.debug("MyServletContextListener.contextDestroyed has been called");
  }

}
