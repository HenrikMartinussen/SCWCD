package info.martinussen.scwcd.hfsj.ch4.web


import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert

class StartupListener implements ServletContextListener{
  
  BeerExpert beerExpert
  
  StartupListener(){
    super()
    beerExpert = new  BeerExpert()
  }
  
  void contextInitialized(ServletContextEvent event){
    event.servletContext.setAttribute('beerExpert', beerExpert)  
  }
  
  void contextDestroyed(ServletContextEvent event){
  }

}
