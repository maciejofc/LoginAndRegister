<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
USER PAGE !!!
<%
String email = (String) session.getAttribute("userlogin");
out.println("helloo user with email: "+email);
%>>
</body>
</html>