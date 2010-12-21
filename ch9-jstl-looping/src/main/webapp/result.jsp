<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

  <b>Hello ${name}.</b><br/>
  <b>Hello <c:out value='${name}'>guest</c:out></b>
  
  <table>
  <% String[] items = (String[] ) request. getAttribute("movieList") ;
    String var = null;
    for (int i = 0; i < items.length; i++) {
      var = items[i] ;
    %>
      <tr><td><%= var %></td></tr>
    <% } %>
  </table>
  
  <table>
  <c:forEach var="movie" items="${movieList}" >
     <tr>
        <td>${movie} </td>  
     </tr>
  </c:forEach>
</table>
  

</body>
</html>
