<%@ taglib prefix="myTags" uri="classicTags" %>
<%-- HFSJ p531, 532, 533 --%>
<html>
<body>
<h2>Classic Tag Handler Example Web Application</h2>
<hr align="left" width="40%"/>
Classic tag 1:<br/> 
<myTags:classic1/><br/>
<myTags:classic1></myTags:classic1><%-- whitespace is NOT allowed between the start and the end tag when tags bodycontent is supposed to be empty --%>
<hr align="left" width="40%"/>
Classic tag 2:<br/> 
<myTags:classic2/><br/><%-- must be empty - implemented with a doStartTag as well as a doEndTag --%>
<myTags:classic2></myTags:classic2>
<hr align="left" width="40%"/>
Classic tag 3:<br/>
<myTags:classic3>This is the body!</myTags:classic3><br/>
<br/>
<hr align="left" width="40%"/>
classic tag 4:<br/>
<table>
<myTags:classic4>
  <tr><td>&nbsp;</td><td>${movie}</td></tr>
</myTags:classic4>
</table>
<hr align="left" width="40%"/>

</body>
</html>
