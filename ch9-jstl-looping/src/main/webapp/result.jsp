<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>

  <b>Hello <c:out value='${name}' default='Guest'/>.</b>
  
  
  <table>
    <c:forEach var="listElement" items="${movies}" varStatus="outerStatus" >
     <tr>
        <td>Row:${outerStatus.count}</td>
        <c:forEach var="movie" items="${listElement}" varStatus="innerStatus">
        
          <td>${innerStatus.count} ${movie} </td>  
        </c:forEach>
     </tr>
    </c:forEach>
  </table>
  

</body>
</html>
