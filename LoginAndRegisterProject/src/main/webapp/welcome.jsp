<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored= "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var ="userName" value ="${user.fullName}"/>
<c:set var ="userRole" value ="${user.role}"/>
<c:choose>
  <c:when test="${userRole == 'ADMIN'}">
    ADMIN PAGE
  </c:when>
  <c:when test="${userRole == 'MEMBER'}">
    MEMBER PAGE!!
  </c:when>
  
</c:choose>

<br>
Link to Your Profile
<a href ="profile.jsp">Go to show credentials page</a>


<br>
<form action = "logout">
	<input type = "submit" value ="logout">
</form>
</body>
</html>