package info.martinussen.scwcd.hfsj.ch8;



import info.martinussen.scwcd.hfsj.ch8.model.Dog;
import info.martinussen.scwcd.hfsj.ch8.model.Person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HFSJ p 366
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
    Person p = new Person();
    p.setName("Evan");
    Dog dog = new Dog() ;
    dog.setName("Spike");
    p. setDog(dog) ;
    req.setAttribute("person" , p) ;
    
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
