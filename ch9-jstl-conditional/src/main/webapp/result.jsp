<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

  <b>Member Comments</b>
  <hr/>
  <table>
    <c:forEach var="comment" items="${commentList}">
     <tr>
       <td>${comment} </td>  
     </tr>
    </c:forEach>
  </table>  
  <hr/>
  
  <!-- <c:if test="${userType eq 'member'}">
    <jsp:include page="inputComments.jsp" />
  </c:if> -->
  
  <c:choose>
  	<c:when test="${userType eq 'member'}">
  	  <jsp:include page="inputComments.jsp" />
  	</c:when>
  	<c:otherwise>
  	  Sign up to be able to add comments...
  	</c:otherwise>
  	
  </c:choose>

</body>
</html>
