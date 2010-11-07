package info.martinussen.scwcd.hfsj.ch5.contexttest;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ListenerTester extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();

        
        out.println("Test context attributes set by listener<br/>");
        out.println("<br/>");
        Dog dog = (Dog) getServletContext().getAttribute("dog");
        out.println("Dog's breed is: " + dog.getBreed());
        
        out.flush();
        out.close();
    }
}
