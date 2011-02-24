<html><body>
<%@ taglib prefix="formTags" uri="formTags" %>
<h1>Beer Selection Page</h1>
<form method="POST" action="SelectBeer.do">
  <p>Select beer characteristics</p>
  <p>Color:
   <formTags:select name='color' size='1' optionsList='${applicationScope.colorList}' />
  </p>
  <br/><br/>
  <center>
    <input type="SUBMIT"/>
  </center>
</form></body></html>