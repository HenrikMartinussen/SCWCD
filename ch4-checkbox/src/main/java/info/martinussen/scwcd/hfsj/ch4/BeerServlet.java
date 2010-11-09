package info.martinussen.scwcd.hfsj.ch4;



import info.martinussen.scwcd.hfsj.ch4.model.BeerSizeExpert;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 121 multiple values, 97 (Lifecycle)
 * @author Henrik
 *
 */
@SuppressWarnings("serial")
public class BeerServlet extends HttpServlet{

  static {
    System.out.println("BeerServlet class is loaded");
  }

  public BeerServlet(){
    super();
    System.out.println("BeerServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    System.out.println("doPost is called");
    String[] sizes = req.getParameterValues("sizes");

    BeerSizeExpert expert = new BeerSizeExpert();
    
    List<String> advice = expert.getBrands(sizes);
    
    req.setAttribute("styles", advice);
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");
    view.forward(req, resp);
  }
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doGet is called - Calling through to DoPost, wait a short while..." );
    doPost(req, resp);
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
