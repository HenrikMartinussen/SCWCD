<%-- 
<%@page import="java.util.*, java.lang.*" %>
tilsyneladende ikke nødvendigt at importere java.lang
 --%>
<html>
<body>
<%
int n = 1;
String nparameter = request.getParameter("rows");
if (nparameter != null){
  n = Integer.parseInt(nparameter);
}
String message = "";
boolean hello = true;
String greetingParameter = request.getParameter("greeting");
if (greetingParameter != null && greetingParameter.equals("hello")){
  message = "Hej JSP Verden";
} else {
  message = "Farvel JSP Verden"; 
}

%>
<h2><%=message%></h2>
<table border=2>
<% for (int i = 0; i < n; i++) {
     String color = "";
     if ((i % 2) == 0) {
       color = "#CCCCCC";
     } 
%>
<tr>
<td bgcolor="<%=color%>"><%= i+1 %></td>
</tr>
<%}%>
</table>
</body>
</html>
