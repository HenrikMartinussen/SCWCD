<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%-- HFSJ p502 --%>
<html>
<body>
<%-- This part doesn't depend on the taglib directive  --%>
<%--
<jsp:include page="Header.jsp">
	<jsp:param value="Html with an ANGLE" name="subTitle"/>
</jsp:include> 
 --%>
<%-- This part does depend on the taglib directive  --%>
<myTags:Header hoverText="image depicting an angle, made from wooden bricks with painted letters on top">We add an angle to html</myTags:Header>
<h2>Welcome to our site</h2>
Contact us at: ${initParam.mainEmail }
</body>
</html>
