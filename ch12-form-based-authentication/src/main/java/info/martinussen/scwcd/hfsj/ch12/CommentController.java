package info.martinussen.scwcd.hfsj.ch12;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class CommentController extends HttpServlet {

  static {
    System.out.println("CommentController class is loaded");
  }

  public CommentController(){
    super();
    System.out.println("CommentController is constructed");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("In CommentController.init()");
    super.init();
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
  throws ServletException, IOException {
    
    System.out.println("In CommentController.service()");
    super.service(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("In CommentController.doPost()");
    boolean acceptsNewSession = false; //pre-existing or null
    HttpSession session = req.getSession(acceptsNewSession);
    if (session == null) { //session timed out
      System.out.println("session was null");
      String contextPath = req.getContextPath();
      System.out.println("sendRedirect");
      resp.sendRedirect(contextPath + "/");//log in anew on default page
    } else { //sessions lives
      ServletContext context = getServletContext();
      List<String> comments = (List<String>) context.getAttribute("commentList");
      comments.add(req.getParameter("newComment"));
      RequestDispatcher dispatcher = req.getRequestDispatcher("/ProcessUserInfo.do");
      dispatcher.forward(req, resp);
    }
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }
  

  @Override
  public void destroy(){
    System.out.println("In CommentController.destroy()");
    super.destroy();
  }
}
