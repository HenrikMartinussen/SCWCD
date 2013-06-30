package info.martinussen.keyfile;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(StartupListener.class);
	

	static {
		log.debug("StartupListener loaded");
	}

	public StartupListener (){
		super();
		log.debug("StartupListener constructed");
	}
	
	public void contextInitialized(ServletContextEvent event) {
		log.debug("Context initialized");
		
	}

	public void contextDestroyed(ServletContextEvent event) {
		log.debug("Context destroyed");
	}
}
