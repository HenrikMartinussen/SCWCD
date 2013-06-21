package info.martinussen.scwcd.hfsj.ch4;

import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(StartupListener.class);
	
	private BeerExpert beerExpert; 

	static {
		log.debug("StartupListener loaded");
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
		log.debug("Context destroyed");
	}
}
