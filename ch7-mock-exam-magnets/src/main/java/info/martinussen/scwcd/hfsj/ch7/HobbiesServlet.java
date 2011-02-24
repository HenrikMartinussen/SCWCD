package info.martinussen.scwcd.hfsj.ch7;

import info.martinussen.scwcd.hfsj.ch7.model.HobbyArchive;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 97 (Lifecycle), 300 Mock Exam Magnets
 * @author Henrik
 *
 */
public class HobbiesServlet extends HttpServlet{

  static {
    System.out.println("HobbiesServlet class is loaded");
  }

  public HobbiesServlet(){
    super();
    System.out.println("HobbiesServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    System.out.println("doPost is called");
    String h = req.getParameter("hobby");

    HobbyArchive expert = new HobbyArchive();
    List<String> names = expert.getNames(h);
    req.setAttribute("names", names);
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");
    view.forward(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("service is called");
    super.service(req, resp);
  }

  
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    System.out.println("destroy is called");
    super.destroy();
  }
}
