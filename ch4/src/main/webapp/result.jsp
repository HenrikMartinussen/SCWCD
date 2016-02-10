<%@ page import="java.util.*" %>
<html>
<header><title>Beer recommendations</title></header>
<body>
<h1 align="center">Beer recommendations JSP</h1>
<p>
<%
  List<String> styles = (List<String>)request.getAttribute("styles");
  for (String s : styles){
    out.print("<br/>try: " + s);
  }
%>
</p>
</body>
</html>
