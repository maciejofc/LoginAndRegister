<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<%@ page isELIgnored ="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
REGISTER PAGE
<br>
${errorEmail}
<br>


   
<form action = "register" method ="post">
		USER FULL NAME: <input type = "text" name =userfullname><br>
		USER DATE OF BIRTH: <input type = "date" name =userbirthday><br>
		USER EMAIL(IT IS LOGIN): <input type = "text" name =userlogin><br> 
		USER PASSWORD: <input type = "text" name =userpassword><br>
	<input type="submit" value = "sign in">

</form>

</body>
</html>