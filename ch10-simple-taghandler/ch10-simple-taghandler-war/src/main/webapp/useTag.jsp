<!--<%@ page import="java.util.*" %>-->
<!--<%@ page import="info.martinussen.scwcd.hfsj.ch10.tag.Movie" %>-->
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<%@ taglib prefix="myTags" uri="simpleTags" %>
<%-- HFSJ p513, 514, 519, 520 521--%>
<html>
<body>
<h2>Simple Tag Handler Example Web Application</h2>
<hr align="left" width="40%"/>
Simple tag 1:<br/> 
<myTags:simple1 user="${initParam.defaultUser}"/>
<myTags:simple1 user="Rene'"></myTags:simple1><%-- whitespace is NOT allowed between the start and the end tag when tags bodycontent is supposed to be empty --%>
<%-- <jsp:attribute> tags don't count as "body content": --%>
<myTags:simple1>
  <jsp:attribute name="user">Renè</jsp:attribute>
</myTags:simple1> <%-- neither JSP comments nor html comments are allowed between the start and the end tag of the simple1 custom tag --%>
<hr align="left" width="40%"/>
Simple tag 2:<br/> 
<myTags:simple2>And this go in the body ${initParam.defaultUser} ;-)</myTags:simple2><%-- EL is quite allright, scripting is disallowed though when tld says bodycontent is scriptless --%>
<br/>
<myTags:simple2>Another body content...</myTags:simple2> <%-- Doesn't work without body content... --%>

<br/>
<hr align="left" width="40%"/>
Simple tag 3:<br/>
<myTags:simple3>Message is: ${message}</myTags:simple3><%-- message attribute is set in the taghandler --%>
<br/>
<hr align="left" width="40%"/>
Simple tag 4:<br/>
<table>
<myTags:simple4>
  <tr><td>&nbsp;</td><td>${movie}</td></tr>
</myTags:simple4>
</table>
<hr align="left" width="40%"/>
Simple tag 5:<br/>
<table>
  <myTags:simple5 movieList="${myTags:movielist()}">
    <tr>
      <td>${movie.name}</td>
      <td>${movie.genre}</td>
    </tr>
  </myTags:simple5>
</table>
<hr align="left" width="40%"/>

</body>
</html>
