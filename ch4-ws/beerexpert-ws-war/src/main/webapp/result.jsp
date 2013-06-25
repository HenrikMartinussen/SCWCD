<%@ page import="java.util.*" %>
<html>
<body>
<h1 align="center">Beer recommendations JSP</h1>
<p>
<%
  List<String> styles = (List<String>)request.getAttribute("styles");
  for (String style : styles){
	out.print("<br/>try: " + style);
  }
%>
</p>
</body>
</html>
