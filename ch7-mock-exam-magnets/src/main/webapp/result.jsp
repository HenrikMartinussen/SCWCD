<%@ page import="java.util.*" %>
<html><body>
<%-- hfsj p 300 --%>
The friends who share your hobby of 
<%=request.getParameter("hobby") %>
are: <br> 

<% ArrayList al = (ArrayList) request.getAttribute("names"); %>

<% Iterator it = al.iterator();
   while (it.hasNext()){ %>
     <%= it.next() %>
<br/> 
<% } %>
</body></html>