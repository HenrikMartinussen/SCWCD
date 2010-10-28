<%@page import="java.util.*" %>
<html>
<body>
<%
String message = "System Properties";
Properties props = System.getProperties();
Enumeration propKeys = props.keys();
%>
<h2><%=message%></h2>
<table border=1>
<% while (propKeys.hasMoreElements()) {
     String key = (String) propKeys.nextElement();
%>
<tr>
<td><%= key %></td>
<td><%= props.getProperty(key) %></td>
</tr>
<%}%>
</table>
</body>
</html>
