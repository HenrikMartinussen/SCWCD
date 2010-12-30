<%@ taglib prefix="mine" uri="randomThings" %>
<%-- HFSJ p478 --%>
<html>
<body>
<h2>Advice Web Application</h2>
Advisor Page<br/><br/>
<mine:advice user="Helge"/>
<br/>
<%-- whitespace is not allowed between the start and end tag, when such are used --%>
<mine:advice user="Børge"></mine:advice> 
<%-- advice is an empty tag - however, the jsp:attribute tag is a valid form of specifying the user attribute --%>
<br/>
<mine:advice>
<jsp:attribute name="user">Jørgen</jsp:attribute>
</mine:advice>



</body>
</html>
