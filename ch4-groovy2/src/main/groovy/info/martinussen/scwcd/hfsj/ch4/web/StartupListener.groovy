package info.martinussen.scwcd.hfsj.ch4.web


import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert
import org.apache.log4j.Logger

class StartupListener implements ServletContextListener{
  
  def  log = Logger.getLogger(BeerExpert.class)
  
  BeerExpert beerExpert
  
  StartupListener(){
    super()
    log.debug 'StartupListener is constructed'
    beerExpert = new BeerExpert()
  }
  
  void contextInitialized(ServletContextEvent event){
    event.servletContext.setAttribute('beerExpert', beerExpert)  
    log.debug "Context initialized"
  }
  
  void contextDestroyed(ServletContextEvent event){
    event.servletContext.removeAttribute('beerexpert')
    log.debug "Context destroyed"
  }

}
