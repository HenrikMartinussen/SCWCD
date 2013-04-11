package info.martinussen.scwcd.hfsj.ch13;


import info.martinussen.scwcd.hfsj.ch13.replace.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener{

  List<Rule> rules = null;
  private static Logger log = Logger.getLogger(StartupListener.class);
  private ServletContext servletContext = null;

  static {
    log.trace("StartupListener loaded");
  }

  public StartupListener (){
    super();
    log.trace("StartupListener constructed");
  }
  
  
  public void contextInitialized(ServletContextEvent event) {
    log.debug("StartupListener.contextInitialized() is called");
    servletContext = event.getServletContext();
    Properties prop = new Properties();
    try {
      prop.load(StartupListener.class.getClassLoader().getResourceAsStream("/replace.properties"));
      rules = new ArrayList<Rule>();
      Enumeration<Object> keys = prop.keys();
      String key = null;
      
      while (keys.hasMoreElements() ){
        key = (String) keys.nextElement();
        rules.add(new Rule(key,prop.getProperty(key)));
      }
    } catch (IOException e) {
      String message = "Error reading replace.properties";
      log.fatal(message);
      throw new IllegalStateException(message);
    }

    if (log.isDebugEnabled()){ //no need to loop if nothing is to logged
      for (Rule rule : rules) {
        log.debug(rule.toString());
      }
    }
    servletContext.setAttribute("rules", rules);
    log.debug("StartupListener.contextInitialized() ends");
  }
  

  public void contextDestroyed(ServletContextEvent event) {
    log.debug("Context destroyed");
    servletContext.removeAttribute("rules");
    rules = null;
  }

  

}
