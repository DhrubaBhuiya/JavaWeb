<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>Z Bank - Your Perfect Bank</h1>
	</center>
	<%
	java.util.Calendar calendar = new java.util.GregorianCalendar();
	java.util.Date date = calendar.getTime();
	java.text.DateFormat format=new java.text.SimpleDateFormat("dd-MM-yyyy");
	String dateval=format.format(date);
	int hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
	if(hour<12)out.print("<h3>Good Morning</h3>");
	else out.print("<h3>Good Evening</h3>");
	%>
	<span style="float:right;"><%out.print(dateval);%></span>
	<h3>Thanks for your great support</h3>
	<%
	Integer hit = (Integer)application.getAttribute("hit");
	if(hit==null||hit==0)hit=1;
	out.print("<h3>You are our valuable visitor number: "+hit+"</h3>");
	application.setAttribute("hit", ++hit);
	%>
</body>
</html>