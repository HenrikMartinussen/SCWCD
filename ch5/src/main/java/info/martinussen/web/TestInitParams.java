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

        Enumeration e = getServletConfig().getInitParameterNames();
        
        out.println("Test init parameters<br/>");
        
        while (e.hasMoreElements()){
            out.println("Parameter name: " + e.nextElement() + "<br/>");
        }

        out.println("Main Email is: " + getServletConfig().getInitParameter("mainEmail"));
        out.println("<br/>");
        out.println("Admin Email is " + getServletConfig().getInitParameter("adminEmail"));
        out.flush();
        out.close();
    }
}
