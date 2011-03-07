<html>
<body>
  <%-- hfsj p 367 --%>
  <%=  ((info.martinussen.scwcd.hfsj.ch8.model.Person) request.getAttribute("person")).getDog(0).getName() %>
  <br/>
  <jsp:useBean id="person" class="info.martinussen.scwcd.hfsj.ch8.model.Person" scope="request">
  </jsp:useBean>
  <jsp:getProperty property="dog" name="person"/>
  <br/>
  ${requestScope.person.dog.name }
</body>
</html>