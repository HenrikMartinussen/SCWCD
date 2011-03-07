<html>
<body>
  <%-- hfsj p 367 --%>
  <%=  ((info.martinussen.scwcd.hfsj.ch8.model.Person) request.getAttribute("person")).getDog(0).getName() %>
  <br/>
  ${requestScope.person.dogs["0"].name}
</body>
</html>