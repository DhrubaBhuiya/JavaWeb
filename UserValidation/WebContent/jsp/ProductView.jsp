<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello admin <%=session.getAttribute("userName")%></h1>
<div id="navigation">
<a href="jsp/AdminHome.jsp">Home</a>
</div>
<br><hr><br>
<center>
<table border="1">
<caption>Product List</caption>
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Product Price</th>
</tr>
<c:forEach var="product" items="${productList}">
<tr>
    <td><c:out value="${product.prodID}" /></td>
    <td><c:out value="${product.prodName}" /></td>
    <td><c:out value="${product.prodPrice}" /></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>