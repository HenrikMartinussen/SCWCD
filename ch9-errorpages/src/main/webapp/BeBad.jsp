<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="errorPage.jsp" %>
<!-- HFSJ p468, 472 -->
<html>
<body>

About to be bad...<br/>
<c:catch var="myException">
  Inside the catch...<br/>
  <% int x = 10/0; %> 
</c:catch>
<c:if test="${myException != null}">
  An exception was thrown; ${myException.message}<br/>
</c:if>
If you see this, the earth is still turning<br/>

</body>
</html>
