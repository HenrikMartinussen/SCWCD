<html>
<%-- hfsj p 353, 354 --%>
<body>
<p>
<jsp:useBean id="person"
           type="info.martinussen.scwcd.hfsj.ch8.model.Person" 
          class="info.martinussen.scwcd.hfsj.ch8.model.Employee" 
          scope="request">
  <jsp:setProperty name="person" property="name" value="John Doe" />
</jsp:useBean>

Hello <jsp:getProperty name="person" property="name" />
</p>
</body>
</html>
