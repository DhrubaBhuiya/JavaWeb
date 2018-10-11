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
<!-- <input type="radio" name="menu" checked>Add New Item -->
<!-- <input type="radio" name="menu">View Items-->
<!--<input type="radio" name="menu">Update Items-->
<!--<input type="radio" name="menu">Remove Items-->
<a href="/UserValidation/jsp/AddItem.jsp">Add</a>
<a href="/UserValidation/ViewProductServlet">View</a>
<a href="/UserValidation/UpdateProduct">Update</a>
<a href="/UserValidation/DeleteProduct">Delete</a>
</div>
<br><hr><br>
</body>
</html>