<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

  <b>Hello <c:out value='${name}' default='Guest'/>.</b>
  
  
  <table>
  <c:forEach var="movie" items="${movieList}" >
     <tr>
        <td>${movie} </td>  
     </tr>
  </c:forEach>
</table>
  

</body>
</html>
