package info.martinussen.scwcd.hfsj.ch4;

import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

	private static Logger log = LogManager.getLogger(StartupListener.class);
	
	private BeerExpert beerExpert; 

	static {
		log.trace("StartupListener loaded");
	}

	public StartupListener (){
		super();
		log.debug("StartupListener constructed");
		beerExpert = new BeerExpert();
	}
	
	public void contextInitialized(ServletContextEvent event) {
		log.debug("Context initialized");
		
		event.getServletContext().setAttribute("beerExpert", beerExpert);
	}

	public void contextDestroyed(ServletContextEvent event) {
	  	event.getServletContext().removeAttribute("beerExpert");
		log.debug("Context destroyed");
	}
}
