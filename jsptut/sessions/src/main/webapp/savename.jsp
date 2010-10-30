<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
   String name = request.getParameter("username");
   String age = request.getParameter("userage");
   session.setAttribute("theName", name);
   session.setAttribute("theAge", age);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>savename</title>
</head>
<body>
<h2>Sessions</h2>
<a href="nextpage.jsp">Continue</a>
</body>
</html>
