<%@ attribute name="hoverText" rtexprvalue="false"%> <%-- optional attributes defaults to required="false" rtexprvalue="true". furthermore an attribute "description" exists... --%>
<%@ tag body-content="tagdependent" %>
<img alt="${hoverText}" title="${hoverText}" src="images/angle.jpg"></img> <br/>
<em><strong><jsp:doBody/></strong></em><br/>