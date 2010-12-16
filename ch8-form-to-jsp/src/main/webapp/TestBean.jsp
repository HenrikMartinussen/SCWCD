<html>
<body>
<p>
<jsp:useBean id="person"
           type="info.martinussen.scwcd.hfsj.ch8.model.Person" 
          class="info.martinussen.scwcd.hfsj.ch8.model.Employee" 
          scope="request" >
  <%-- no need for a value attribute because property name matches form input field name. 
  ...and with an asterisk we're saying: "take all requestParameters with names that match the 
  javaBean, and set their values on the bean" - The type is of no particular consequence; 
  properties not associated with the actual type, are set on the bean with no quirks at 
  all - even tried java.lang.Object!--%>      
  <jsp:setProperty name="person" property="*"/>     
</jsp:useBean>
Person is: <jsp:getProperty name="person" property="name" />, ID is <jsp:getProperty property="empID" name="person"/>
</p>
</body>
</html>
