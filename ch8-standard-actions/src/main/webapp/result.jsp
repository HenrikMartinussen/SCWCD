<%@ page import="info.martinussen.scwcd.hfsj.ch8.model.Person" %>
<html>
<body>
<p>
Hello <%= ((Person) request.getAttribute("person")).getName() %> <%-- Use scripting and die :-£ --%>
<jsp:useBean id="porsen" class="info.martinussen.scwcd.hfsj.ch8.model.Person" scope="request">
  <jsp:setProperty name="porsen" property="name" value="John Doe" />
</jsp:useBean>

Hello <jsp:getProperty name="porsen" property="name" />
</p>
</body>
</html>
