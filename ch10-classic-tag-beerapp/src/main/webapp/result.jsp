<%@ page import="java.util.*" %>
<html>
<body>
<h1 align="center">Beer recommendations JSP</h2>
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
