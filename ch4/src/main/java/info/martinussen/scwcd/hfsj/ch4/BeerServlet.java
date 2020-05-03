package info.martinussen.scwcd.hfsj.ch4;

import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * HFSJ p 89, 97 (Lifecycle)
 */
@SuppressWarnings("serial")
public class BeerServlet extends HttpServlet{
  
  private static Logger log = LogManager.getLogger(BeerServlet.class);

  static {
    log.trace("BeerServlet class is loaded");
  }

  public BeerServlet(){
    super();
    log.debug("BeerServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    log.debug("doPost is called");
    String c = req.getParameter("color");
    
    BeerExpert expert = (BeerExpert) getServletContext().getAttribute("beerExpert");
    
    List<String> advice = expert.getBrands(c);
    req.setAttribute("styles", advice);
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");
    view.forward(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("service is called");
    super.service(req, resp);
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    log.debug("init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    log.debug("destroy is called");
    super.destroy();
  }
}
