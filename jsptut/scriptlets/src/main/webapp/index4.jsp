<%-- 
Exercise:  Write a JSP to output the entire line, 
"Hello!  The time is now ..." but use a scriptlet for 
the complete string, including the HTML tags. 
--%> 
<%@ page import="java.util.*, java.text.*" %> 
<%
System.out.println("Evaluating date now...");
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

out.println("<html><body>");
out.println("Hello! The time is now...");
out.println(sdf.format(date));
out.println("</body></html>");
%> 