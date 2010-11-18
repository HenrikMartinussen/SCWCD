package info.martinussen.scwcd.hfsj.ch6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CheckCookie extends HttpServlet {

  static {
    System.out.println("CheckCookie is loaded");
  }
	
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	System.out.println("CheckCookie.doGet() runs");
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Cookie[] cookies = request.getCookies();
	if (cookies != null){
	  for (int i = 0; i < cookies.length; i++){
	    Cookie cookie = cookies[i];
	    if (cookie.getName().equals("username")){
	      String username = cookie.getValue();
	      out.println("Hello " + username);
	      break;
	    }
      }
	}
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	super.service(req, resp);
	System.out.println("CheckCookie.service() runs");
  }

  @Override
  public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
	System.out.println("CheckCookie.destroy() runs");
  }

  @Override
  public void init() throws ServletException {
	// TODO Auto-generated method stub
    super.init();
    System.out.println("CheckCookie.init() runs");
  }
  
  
  
	
}
