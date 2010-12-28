<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

  <b>Member Comments</b>
  <hr/>
  <table>
    <c:forEach var="comment" items="${commentList}">
     <tr>
       <%-- use of the <c:out> tag prevents html/script in comments from being rendered  --%>
       <td><c:out value="${comment}"></c:out></td>  
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
