package info.martinussen.scwcd.hfsj.ch6.web;

import info.martinussen.scwcd.hfsj.ch6.model.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BeerAppServlet extends HttpServlet {
  
  
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }

  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html");
    
    BeerExpert beerExpert;
    NextResponse nextResponse;
    
    HttpSession session = request.getSession();
    if (session.isNew()){
      beerExpert = new BeerExpert();
      session.setAttribute("beerexpert", beerExpert);
      nextResponse = beerExpert.getAdvice("");
    } else {
      beerExpert = (BeerExpert)session.getAttribute("beerexpert");
      String lastAnswer = request.getParameter("answer");
      nextResponse = beerExpert.getAdvice(lastAnswer);
    }
    request.setAttribute("nextresponse", nextResponse);
    RequestDispatcher view = request.getRequestDispatcher("adviceView.jsp");
    view.forward(request, response);
  }
}