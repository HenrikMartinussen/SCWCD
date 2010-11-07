package com.wickedlysmart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BeerTester extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
	out.println("HFSJ chapter 5 codemagnets<br/>");
        out.println("Value of foo Context Parameter: " + getServletContext().getInitParameter("foo"));


        out.flush();
        out.close();
    }
}
