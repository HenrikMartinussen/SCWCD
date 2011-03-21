package info.martinussen.scwcd.hfsj.ch6.web;

import info.martinussen.scwcd.hfsj.ch6.model.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class BeerAppServlet extends HttpServlet {
  
  private static Logger log = Logger.getLogger(BeerAppServlet.class);
  
  
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }

  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html");
    log.debug("BeerAppServlet.doPost() runs");
    BeerExpert beerExpert;
    NextResponse nextResponse;
    
    HttpSession session = request.getSession();
    if (session.isNew()){
      log.debug("Session was new");
      beerExpert = new BeerExpert();
      session.setAttribute("beerexpert", beerExpert);
      nextResponse = beerExpert.getAdvice("");
    } else {
      log.debug("existing session is used");
      beerExpert = (BeerExpert)session.getAttribute("beerexpert");
      String lastAnswer = request.getParameter("answer");
      nextResponse = beerExpert.getAdvice(lastAnswer);
    }
    log.debug(nextResponse);
    request.setAttribute("nextresponse", nextResponse);
    RequestDispatcher view = request.getRequestDispatcher("adviceView.jsp");
    view.forward(request, response);
  }
}