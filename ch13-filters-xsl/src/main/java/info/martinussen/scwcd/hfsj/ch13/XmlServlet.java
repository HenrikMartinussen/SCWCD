package info.martinussen.scwcd.hfsj.ch13;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

public class XmlServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(XmlServlet.class);
	
	static {
    log.debug("XmlServlet is loaded");
  }
  
  public XmlServlet(){
    super();
    log.debug("XmlServlet is constructed");
  }
	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    log.debug("XmlServlet doGet() runs");
      
    PrintWriter out = response.getWriter();
    out.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
    out.println("<bookstore>");
    out.println("  <book category=\"COOKING\">");
    out.println("    <title lang=\"en\">Everyday Italian</title>");
    out.println("    <author>Giada De Laurentiis</author>");
    out.println("    <year>2005</year>");
    out.println("    <price>30.00</price>");
    out.println("  </book>");
    out.println("  <book category=\"CHILDREN\">");
    out.println("    <title lang=\"en\">Harry Potter</title>");
    out.println("    <author>J K. Rowling</author>");
    out.println("    <year>2005</year>");
    out.println("    <price>29.99</price>");
    out.println("  </book>");
    out.println("  <book category=\"WEB\">");
    out.println("    <title lang=\"en\">Learning XML</title>");
    out.println("    <author>Erik T. Ray</author>");
    out.println("    <year>2003</year>");
    out.println("    <price>39.95</price>");
    out.println("  </book>");
    out.println("</bookstore>");
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
