<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="info.martinussen.jsptut.user.UserData" scope="session"/>
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

<%-- Exercise:  
     1)  Write a JSP/HTML set that allows a user to enter the name of a system property, and then displays the value returned by System.getProperty for that property name (handle errors appripriately.)   
     2)  Go back to the exercises where you manually modified boolean variables.  Instead of a boolean variable, make these come from a HIDDEN form field that can be set to true or false.  
--%>

</body>
</html>
