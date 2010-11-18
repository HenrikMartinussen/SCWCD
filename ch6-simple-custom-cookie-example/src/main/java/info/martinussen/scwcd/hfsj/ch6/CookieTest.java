package info.martinussen.scwcd.hfsj.ch6;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 252
 * @author Henrik
 *
 */
@SuppressWarnings("serial")
public class CookieTest extends HttpServlet{

  static {
    System.out.println("CookieTest class is loaded");
  }

  public CookieTest(){
    super();
    System.out.println("CookieTest is constructed");
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
    System.out.println("doPost is called");
    
    response.setContentType("text/html");
    
    String name = request.getParameter("username");
    
    Cookie cookie = new Cookie("username", name);
    cookie.setMaxAge(30*60); // keep it alive on the client for 30 minutes

    response.addCookie(cookie);

    RequestDispatcher view = request.getRequestDispatcher("cookieresult.jsp");
    view.forward(request, response);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("CookieTest.service() is called");
    super.service(req, resp);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("CookieTest.init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    System.out.println("CookieTest.destroy() is called");
    super.destroy();
  }
}
