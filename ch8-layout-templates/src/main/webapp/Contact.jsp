<html>
<%-- hfsj p 403 --%>
<body>
<%-- Header includes an image - hence dynamic include using an include standard action --%>
<jsp:include page="Header.jsp">
  <jsp:param name="subTitle" value="We know how to make you stand out"/>
</jsp:include>
  <%-- only the standard action enables parameters to be used --%>
<br/>
<em>We can help.</em>
<br/><br/>
Contact us at: ${initParam.mainEmail }
<%@ include file="Footer.jsp" %><%--Footer is merely a link - doesn't hurt to use an include directive --%>
</body>
</html>
