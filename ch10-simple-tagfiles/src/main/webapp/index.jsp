<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%-- HFSJ p502 --%>
<html>
<body>
<jsp:include page="Header.jsp">
	<jsp:param value="Html with an ANGLE" name="subTitle"/>
</jsp:include> 
<%-- 
<myTags:Header/>
--%>
<h2>Welcome to our site</h2>
Contact us at: ${initParam.mainEmail }
</body>
</html>
