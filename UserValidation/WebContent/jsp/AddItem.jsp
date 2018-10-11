<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello admin <%=session.getAttribute("userName")%></h1>
<div id="navigation">
<a href="./AdminHome.jsp">Home</a>
</div>
<br><hr><br>
<div id="AddProduct">
<form action="/UserValidation/AddProduct">
Product ID:<br>
<input type="text" name="prodID" id="prodID"><br><br>
Product Name:<br>
<input type="text" name="prodName" id="prodName"><br><br>
Product Price:<br>
<input type="text" name="prodPrice" id="prodPrice"><br><br>
<input type="submit" name="submit" value="Add">
</form>
</div>
</body>
</html>