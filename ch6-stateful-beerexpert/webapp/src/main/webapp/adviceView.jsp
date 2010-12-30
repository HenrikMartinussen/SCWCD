<%@ page import="info.martinussen.scwcd.hfsj.ch9.tag.*" %>
<html>
<body>
<h2>Beer Advice Web Application</h2>
<% 
NextResponse nextResponse = (NextResponse) request.getAttribute("nextresponse");
String[] strings = nextResponse.getMessages(); 
%>
<form method="POST" action="beer">
<%

for (String s : strings){
  if (nextResponse.isFinalAdvice()){
    %>
    <br/>try <%=s%>
    <%
  } else {
%>
  <br/><input type="radio" name="answer" value="<%=s%>"/> <%=s%>
<%
  }
}
%>
<br/>
<br/>
<input type="SUBMIT"/>
<%if (nextResponse.isFinalAdvice()) request.getSession().invalidate(); %>

</form>
</body>
</html>
