package info.martinussen.scwcd.hfsj.ch13;


import info.martinussen.scwcd.hfsj.ch13.replace.Rule;

import java.io.IOException;
import java.util.ArrayList;
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
      String key = null;
      int counter = 0;
      while (prop.keys().hasMoreElements() && counter < 99){
        key = (String) prop.keys().nextElement();
        log.debug("key [" + counter++ + "]---------------> " + key);
        rules.add(new Rule(key,prop.getProperty(key)));
      }
    } catch (IOException e) {
      String message = "Error reading replace.properties";
      log.fatal(message);
      throw new IllegalStateException(message);
    }
    servletContext.setAttribute("rules", rules);
    log.debug("StartupListener.contextInitialized() ends");
//    log.debug("dbUserId = " + dbUserId);
//    log.debug("dbPassword = " + dbPassword);
//    log.debug("dbConnectString = " + dbConnectString);
  }
  

  public void contextDestroyed(ServletContextEvent event) {
    log.debug("Context destroyed");
  }

  

}
