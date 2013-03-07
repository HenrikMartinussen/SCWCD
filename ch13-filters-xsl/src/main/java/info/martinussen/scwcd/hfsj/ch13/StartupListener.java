package info.martinussen.scwcd.hfsj.ch13;


import info.martinussen.scwcd.hfsj.ch13.model.XmlDataSource;
import info.martinussen.scwcd.hfsj.ch13.model.XmlFileDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(StartupListener.class);
	private static final String ATTRIBUTE_NAME = "xmlDataSource";
	
	private ServletContext servletContext = null;
	private XmlDataSource xmlDataSource = null;

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
		String dataSourceClassName = (String) servletContext.getInitParameter("xmlDataSource");
		try {
      xmlDataSource = (XmlDataSource) Class.forName(dataSourceClassName).newInstance();
    } catch (Exception e) {
      String message = "Error instantiating Class " + dataSourceClassName + " by reflection";
      log.fatal(message + " " + e);
      throw new IllegalStateException(e);
    } 
		
		event.getServletContext().setAttribute(ATTRIBUTE_NAME, xmlDataSource);
		log.debug("xmlDataSource was added to ServletContext under the name " + ATTRIBUTE_NAME);
	}

	public void contextDestroyed(ServletContextEvent event) {
	  servletContext.removeAttribute(ATTRIBUTE_NAME);
		log.debug("Context destroyed");
	}
}
