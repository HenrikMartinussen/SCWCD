package info.martinussen.scwcd.hfsj.ch13;


import info.martinussen.scwcd.hfsj.ch13.model.XmlDataSource;
import info.martinussen.scwcd.hfsj.ch13.model.XmlFileDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(StartupListener.class);
	
	private XmlDataSource xmlDataSource;

	static {
		log.trace("StartupListener loaded");
	}

	public StartupListener (){
		super();
		log.trace("StartupListener constructed");
		 
	}
	
	public void contextInitialized(ServletContextEvent event) {
		log.debug("Context initialized");
		xmlDataSource = new XmlFileDataSource();
		event.getServletContext().setAttribute("xmlDataSource", xmlDataSource);
	}

	public void contextDestroyed(ServletContextEvent event) {
		log.debug("Context destroyed");
	}
}
