
<%! 
   public void jspInit(){
     ServletConfig sConfig = getServletConfig();
     String emailAddr = sConfig.getInitParameter("email");
     ServletContext ctx = sConfig.getServletContext();
     ctx.setAttribute("mail", emailAddr);
   }
%>

<html><body>
<h2>Hello World!</h2>
Email address: <%= application.getAttribute("mail")%>
</body></html>
