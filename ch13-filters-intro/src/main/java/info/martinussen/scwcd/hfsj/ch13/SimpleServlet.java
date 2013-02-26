package info.martinussen.scwcd.hfsj.ch13;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

public class SimpleServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(SimpleServlet.class);
	
	static {
    log.debug("SimpleServlet is loaded");
  }
  
  public SimpleServlet(){
    super();
    log.debug("LoggingFilter is constructed");
  }
	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    log.debug("Simple Servlet doGet() runs");
      
    PrintWriter out = response.getWriter();
    out.println( "SimpleServlet Executed" );
    out.flush();
    out.close();
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("service is called");
    super.service(req, resp);
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    log.debug("init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    log.debug("destroy is called");
    super.destroy();
  }
  
}
