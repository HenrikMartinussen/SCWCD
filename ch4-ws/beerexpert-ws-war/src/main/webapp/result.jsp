<%@ page import="java.util.*" %>
<html>
<body>
<h1 align="center">Beer recommendations JSP</h1>
<p>
<%
  String styles = (String)request.getAttribute("styles");
  out.print("<br/>try: " + styles);
%>
</p>
</body>
</html>
