package info.martinussen.web;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TestInitParams extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("Test init parameters<br/>" );
        
        Enumeration e = getServletConfig().getInitParameterNames();
        while (e.hasMoreElements()){
        	out.println("<br/>" + "param name = " + e.nextElement() + "<br/>");
        }
        out.println("Main Email is: " + getServletConfig().getInitParameter("adminEmail"));
        out.println("<br/>");
        out.println("admin Email is: " + getServletConfig().getInitParameter("mainEmail"));
        out.flush();
        out.close();
    }
}
