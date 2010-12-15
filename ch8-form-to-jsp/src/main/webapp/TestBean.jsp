<html>
<body>
<p>
<jsp:useBean id="person"
           type="info.martinussen.scwcd.hfsj.ch8.model.Person" 
          class="info.martinussen.scwcd.hfsj.ch8.model.Employee" 
          scope="request" >
  <%-- no need for a value attribute because property name matches form input field name. 
  and with an asterisk we're saying take all requestParameters with names that match the javaBean and set their values on the bean--%>      
  <jsp:setProperty name="person" property="*"/>     
</jsp:useBean>
          
          <%--<% person.setName(request.getParameter("userName")); --%>

Hello <jsp:getProperty name="person" property="name" />, number <jsp:getProperty property="empID" name="person"/>
</p>
</body>
</html>
