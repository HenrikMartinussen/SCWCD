<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%-- jsptut.com/Directives.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Title here</title>
</head>
<body>
<% 
    System.out.println("Evaluating date now");
    Date date = new Date(); 
%>

<h2>Hello World!</h2>
<p>Time is <%= date%></p>
</body>
</html>
