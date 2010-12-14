<html>
<body>
<p>
<jsp:useBean id="porsen"
           type="info.martinussen.scwcd.hfsj.ch8.model.Person" 
          class="info.martinussen.scwcd.hfsj.ch8.model.Employee" 
          scope="request">
  <jsp:setProperty name="porsen" property="name" value="John Doe" />
</jsp:useBean>

Hello <jsp:getProperty name="porsen" property="name" />
</p>
</body>
</html>
