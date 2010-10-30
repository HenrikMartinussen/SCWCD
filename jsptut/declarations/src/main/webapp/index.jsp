<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%! private Date date = new Date(); %>
<%! private Date getDate(){
	  return date;
    } 
    private void  resetDate(){
      System.out.println("Date was reset...");
      date = new Date();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello with declarations</title>
</head>
<body>
<h2>Declarations</h2>
<%resetDate(); %>
<p>Time is: <%= getDate() %></p>
</body>
</html>