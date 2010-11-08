package info.martinussen.scwcd.hfsj.ch5.contexttest;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ListenerTester extends HttpServlet {
  
  static {
    System.out.println("ListenerTester is being loaded");
  }
  
  public ListenerTester(){
    super();
    System.out.println("ListenerTester is being constructed");
  }
  
  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("ListenerTester is being initialized");
  }
  
  
  
  @Override
  public void destroy() {
    super.destroy();
    System.out.println("ListenerTester is being destroyed");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("ListenerTester.service(req, resp) runs");
    super.service(req, resp);
  }


  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("ListenerTester.doGet(req, resp) runs");
    resp.setContentType("text/html");
        
    PrintWriter out = resp.getWriter();

        
    out.println("Test context attributes set by listener<br/>");
    out.println("<br/>");
    Dog dog = (Dog) getServletContext().getAttribute("dog");
    out.println("Dog's breed is: " + dog.getBreed());
       
    out.flush();
    out.close();
  }
}
