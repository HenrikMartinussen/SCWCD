<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%-- http://www.jsptut.com/Declarations.jsp --%>
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
<p>Revisited...</p>
<%resetDate(); %>
<p>Time is: <%= getDate() %></p>
</body>
</html>