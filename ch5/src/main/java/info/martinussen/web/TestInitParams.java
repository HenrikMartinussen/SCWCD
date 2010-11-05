package info.martinussen.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TestInitParams extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println( "Test init parameters<br/>" );
        out.println(getServletConfig().getInitParameter("adminEmail"));
        out.println(getServletConfig().getInitParameter("mainEmail"));
        out.flush();
        out.close();
    }
}
