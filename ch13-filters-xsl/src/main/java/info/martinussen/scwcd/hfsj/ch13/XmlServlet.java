package info.martinussen.scwcd.hfsj.ch13;

import info.martinussen.scwcd.hfsj.ch13.model.XmlDataSource;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

public class XmlServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(XmlServlet.class);
	
	static {
    log.trace("XmlServlet is loaded");
  }
  
  public XmlServlet(){
    super();
    log.trace("XmlServlet is constructed");
  }
	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    log.debug("XmlServlet doGet() runs");
    
    //obtain a resource called "xmlDataSource" from the servletContext - as in ch4
    XmlDataSource xmlDataSource = (XmlDataSource) getServletContext().getAttribute("xmlDataSource");
    
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();
    out.println(xmlDataSource.getXmlData());

    out.flush();
    out.close();
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("XmlServlet.service is called");
    super.service(req, resp);
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("XmlServlet.init(ServletConfig) is called");
    
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    log.debug("XmlServlet.init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    log.debug("XmlServlet.destroy() is called");
    super.destroy();
  }
  
}
