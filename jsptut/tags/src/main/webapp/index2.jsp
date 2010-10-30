<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String methodParameter = request.getParameter("method");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>uses include tag</title>
</head>
<body>
Going to include index.jsp...<br/>
<% 
if (methodParameter != null && methodParameter.equals("forward")){
%>
  <jsp:forward page="index.jsp"></jsp:forward>
<% 
} else {
%>
  <jsp:include page="index.jsp"></jsp:include>
<%
} 
%>
</body>
</html>