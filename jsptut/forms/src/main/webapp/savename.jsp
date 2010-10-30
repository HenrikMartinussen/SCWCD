<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="info.martinussen.jsptut.user.UserData" scope="session"/>
<jsp:setProperty property="*" name="user"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beans and Form processing</title>
</head>
<body>
<h2>Making a bean of the submitted data</h2>
<a href="nextpage.jsp">Continue</a>
</body>
</html>