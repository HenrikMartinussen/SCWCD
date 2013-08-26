<?xml version="1.0" encoding="UTF-8"?>
<html><body>
<h1>License Key Generation Page</h1>
<form method="POST" action="GenerateKey.do">
  <p>Select license version
  <select name="version" size="1">
    <option>Light</option>
    <option>Basic</option>
    <option>Standard</option>
    <option>Enterprise</option>
  </select> 
  </p>
  <p>Customer name
  <input type="text" name="customerName" />
  </p>
  <p>Order Number
  <input type="text" name="orderNumber" />
  </p>
  <p>Number of clients
  <select name="clientCount" size="1">
  	<option>1</option>
  	<option>2</option>
  	<option>3</option>
  	<option>4</option>
  	<option>5</option>
  	<option>6</option>
  	<option>7</option>
  	<option>8</option>
  </select>
  </p>
  <p>Number of automats
  <select name="automatCount" size="1">
  	<option>1</option>
  	<option>2</option>
  	<option>3</option>
  	<option>4</option>
  	<option>5</option>
  	<option>6</option>
  	<option>7</option>
  	<option>8</option>
  </select>
  </p>
  <p>
  <input type="checkbox" name="liftEnabled">Enable lift</input>
  </p>
  <p>
	<input type="checkbox" name="trayAccessControlEnabled">Enable trayAccessControl</input> 
  </p>
<!--   
  <p>
<input type="checkbox" name=""></input> 
  </p>
-->
  <p>
	<input type="checkbox" name="lotSerialEnabled">Enable LotSerialnumbers</input> 
  </p>
  <p>
	<input type="checkbox" name="webStatusPageEnabled">Enable webStatusPage</input> 
  </p>
  <p>
  <input type="checkbox" name="tiltEnabled">Enable tilt</input>
  </p>
  <br/><br/>
  <input type="SUBMIT" title="Generate Key"/>
</form>
</body></html>