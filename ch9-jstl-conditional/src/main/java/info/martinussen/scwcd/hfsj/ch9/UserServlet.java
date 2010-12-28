package info.martinussen.scwcd.hfsj.ch9;

import info.martinussen.scwcd.hfsj.ch9.model.UserTypeModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HFSJ p 451
 * @author henmar
 *
 */
@SuppressWarnings("serial")
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
    HttpSession session = req.getSession();
    if (session.isNew()){
      String name = req.getParameter("name");
      UserTypeModel model = new UserTypeModel();
      String userType = model.findUserTypeFromName(name);
      session.setAttribute("userType", userType);
    }
    
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");//removed a forward slash...
    view.forward(req, resp);
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
