package info.martinussen.scwcd.ch1_3;

import info.martinussen.scwcd.ch1_3.model.BeerExpert;
import info.martinussen.scwcd.ch1_3.model.Dog;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 89, 97 (Lifecycle)
 * @author Henrik
 *
 */
@SuppressWarnings("serial")
public class BeerServlet extends HttpServlet{

  static {
    System.out.println("SimpleServlet class is loaded");
  }

  private Dog dog;
  
  public BeerServlet(){
    super();
    System.out.println("Servlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    System.out.println("doPost is called");
//    ServletContext context = getServletContext();
//    Enumeration<String> attributeNames = context.getAttributeNames();
//    while (attributeNames.hasMoreElements()){
//      System.out.println(attributeNames.nextElement());
//    }
//    
    String c = req.getParameter("color");

    BeerExpert expert = new BeerExpert();
    List<String> advice = expert.getBrands(c);
    req.setAttribute("styles", advice);
    
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
  public void init() throws ServletException {
    System.out.println("init is called");
    
    System.out.println(getServletConfig().getInitParameter("version"));
    System.out.println(getInitParameter("version"));

    
    ServletContext context = getServletContext();
    
    dog = (Dog) context.getAttribute("Dog");
    
    System.out.println("Dogs breed = " + dog.getBreed());
    super.init();
  }
  
  
  
  

}
