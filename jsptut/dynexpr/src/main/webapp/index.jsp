<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- http://www.jsptut.com/Dynexpr.jsp --%>
<HTML>
<BODY>
	<h1>Hello!</h1>
	<p>
		The time is now
		<%= new java.util.Date() %></p>
	<table>
		<tr>
		    <td>java.version</td><td><%= System.getProperty("java.version") %></td>
		</tr>
		<tr>
			<td>java.home</td><td><%= System.getProperty("java.home") %></td>
		</tr>
		<tr>
			<td>os.name</td><td><%= System.getProperty("os.name") %></td>
		</tr>
		<tr>
			<td>user.name</td><td><%= System.getProperty("user.name") %></td>
		</tr>
		<tr>
			<td>user.home</td><td><%= System.getProperty("user.home") %></td>
		</tr>
		<tr>
			<td>user.dir</td><td><%= System.getProperty("user.dir") %></td>
		</tr>
	</table>
</BODY>
</HTML>