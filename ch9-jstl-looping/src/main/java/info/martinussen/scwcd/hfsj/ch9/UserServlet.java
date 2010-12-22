package info.martinussen.scwcd.hfsj.ch9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 446
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
    
    System.out.println("doPost is called");
    String name = req.getParameter("name");
    req.setAttribute("name", name);
    
    String[] movies1 = {"Amelie", "Top Secret", "Lord Of The Rings"};
    String[] movies2 = {"Mig og Charlie", "Midt om natten", "Olsenbanden i Jylland"};
    List<String[]> movieList = new ArrayList<String[]>();
    movieList.add(movies1);
    movieList.add(movies2);
    req.setAttribute("movies", movieList);
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");//removed a forward slash...
    view.forward(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("service is called");
    super.service(req, resp);
  }

  @Override
  public void init() throws ServletException {
    System.out.println("init is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    System.out.println("destroy is called");
    super.destroy();
  }
}
