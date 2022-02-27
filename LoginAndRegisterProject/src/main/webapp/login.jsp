<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
LOGIN PAGE
<br>

${registerSuccess}

<form action = "login" method ="post">
	USER LOGIN: <input type = "text" name =userlogin> 
	USER PASSWORD: <input type = "text" name =userpassword> 
	<input type="submit" value = "Log in">
</form>

<br>

${loginFailure}
<br>
GO TO REGISTER PAGE
<a href ="register.jsp">Go to register page</a>


</body>
</html>