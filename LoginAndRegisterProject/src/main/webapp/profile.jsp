<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored= "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("user") == null)
		response.sendRedirect("login.jsp");
	%>
<!-- 	td- table data -->
<!-- 	th - header cell -->
<!-- 	tr- table row -->
	<table>
		<tr>
			<th>Info</th>
			<th>Data</th>
		</tr>
		<tr>
			<td>Full Name</td>
			<td>${user.fullName}</td>
		</tr>
		<tr>
			<td>Date of birth</td>
			<td>${user.birthday}</td>
		</tr>
		<tr>
		<tr>
			<td>Email</td>
			<td>${user.email}</td>
		</tr>
		<tr>
		<tr>
			<td>Password</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Account created at</td>
			<td>${user.createdAt}</td>
		</tr>
		<tr>
			<td>Last updated at</td>
			<td>${user.updatedAt}</td>
		</tr>
		
	</table>
</body>
</html>