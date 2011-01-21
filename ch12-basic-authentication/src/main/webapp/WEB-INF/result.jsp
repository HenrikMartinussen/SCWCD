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
  <jsp:include page="inputComments.jsp" />

</body>
</html>
