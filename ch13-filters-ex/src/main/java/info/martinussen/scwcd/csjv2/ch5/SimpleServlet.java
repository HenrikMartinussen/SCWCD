package info.martinussen.scwcd.csjv2.ch5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;


@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet {
  
  private static Logger log = Logger.getLogger(SimpleServlet.class);

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    log.debug("Simple Servlet doGet() runs");
      
    PrintWriter out = response.getWriter();
    out.println( "SimpleServlet Executed" );
    out.flush();
    out.close();
  }
}
