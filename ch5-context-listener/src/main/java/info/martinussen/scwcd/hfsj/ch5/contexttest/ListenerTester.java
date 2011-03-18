package info.martinussen.scwcd.hfsj.ch5.contexttest;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

/**
 * HFSJ p. 168 ff., Ch 5 - ServletContextListener tutorial
 * @author hma
 *
 */
@SuppressWarnings("serial")
public class ListenerTester extends HttpServlet implements ServletContextListener {
  /* Besides being a servlet ListenerTester is also a ServletContextListener, 
   * receiving notices about ServletContext being initialized and destroyed
   */

  private static Logger log = Logger.getLogger(ListenerTester.class);
  
  static {
    log.debug("ListenerTester is being loaded");
  }
  
  public ListenerTester(){
    super();
    log.debug("ListenerTester is being constructed");
  }
  
  @Override
  public void init() throws ServletException {
    super.init();
    log.debug("ListenerTester.init() has run");
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    log.debug("ListenerTester.init(ServletConfig) has run");
  }


  @Override
  public void destroy() {
    super.destroy();
    log.debug("ListenerTester is being destroyed");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.debug("ListenerTester.service(req, resp) runs");
    super.service(req, resp);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.debug("ListenerTester.doGet(req, resp) runs");
    resp.setContentType("text/html");
        
    PrintWriter out = resp.getWriter();

    out.println("<h3>Test context attributes set by listener</h3>");
    out.println("<br/>");
    Dog dog = (Dog) getServletContext().getAttribute("dog");
    out.println("Dog's breed is: " + dog.getBreed());
       
    out.flush();
    out.close();
  }


  public void contextInitialized(ServletContextEvent event) {
    log.debug("ListenerTester.contextInitialized(ServletContextEvent) runs");
    ServletContext servletContext = event.getServletContext();
    Dog dog = new Dog(servletContext.getInitParameter("breed"));
    servletContext.setAttribute("dog", dog);
    
  }

  public void contextDestroyed(ServletContextEvent event) {
    log.debug("ListenerTester.contextDestroyed(ServletContextEvent) runs");
    // Nothing to do here - Dogs die with the context :-/
  }
}
