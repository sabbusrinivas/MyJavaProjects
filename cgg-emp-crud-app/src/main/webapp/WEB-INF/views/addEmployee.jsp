<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link href="/resources/css/main.css" rel="stylesheet" type="text/css" >
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Save Employee Details</title>


</head>

<body>
    <center>
	<h1>Employees Details</h1>
		
	<br><br>
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/viewEmployees'">Employees list</button>
	<h1>Add Employee</h1>
	<form:form action = "${pageContext.request.contextPath}/save" modelAttribute="employee">
		<table>
		<tr><td>Enter Name:</td><td>   <form:input path="name"/></td><td> <form:errors path="name" cssClass="error" /><td></tr>
		<tr><td>Enter Email:</td><td>   <form:input path="email"/> </td><td><form:errors path="email" cssClass="error" /><td></tr>
		<tr><td>Date of Birth: </td><td><form:input path="dob" type = "date"/></td><td> <form:errors path="dob" cssClass="error" /><td></tr>
		<tr><td>Enter Salary: </td><td><form:input path="salary"/> </td><td><form:errors path="salary" cssClass="error" /><td></tr>	
		<form:hidden path = "id"/>
		</table>
		<br></br>
		<button type = "submit">Save</button>
		
	</form:form>     
    </center>
</body>

</html>