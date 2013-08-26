package info.martinussen.keyfile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{

  static {
    System.out.println("UserServlet class is loaded");
  }

  public UserServlet(){
    super();
    System.out.println("UserServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    System.out.println("In UserServlet.doPost()");
    if (req.isUserInRole("employees")){
      System.out.println(req.getUserPrincipal().getName());
      System.out.println("user is in logical role employees...");
      req.setAttribute("viewName", "Super User View");
    } else {
      System.out.println("user is NOT in logical role employees");
      req.setAttribute("viewName", "Regular User View");
    }
    RequestDispatcher view = req.getRequestDispatcher("WEB-INF/keyFileInputForm.jsp");//removed a forward slash...
    view.forward(req, resp);
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("In UserServlet.doGet()");
    doPost(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("In UserServlet.service()");
    super.service(req, resp);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("In UserServlet.init()");
    super.init();
  }
  
  @Override
  public void destroy(){
    System.out.println("In UserServlet.destroy()");
    super.destroy();
  }
}
