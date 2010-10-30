<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="info.martinussen.jsptut.user.UserData"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>outputting userdata as contained in bean "user"</title>
</head>
<body>
You entered<br/>
Name: <%= user.getUsername() %><br/>
E-mail: <%= user.getEmail() %><br/>
Age: <%= user.getAge() %><br/>
</body>
</html>