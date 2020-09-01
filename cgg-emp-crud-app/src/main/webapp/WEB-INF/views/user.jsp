<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/resources/css/main.css" rel="stylesheet" type="text/css" >
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>User Details Form</h1>
	<form:form action = "${pageContext.request.contextPath}/saveUser" modelAttribute="user">
		<table >
		<tr><td>Enter Name: </td> <td> <form:input path="name"/> </td><td><form:errors path="name" cssClass="error" /></td> <td></tr>
		<tr><td>Enter Email: </td> <td>  <form:password path="email"/></td><td> <form:errors path="email" cssClass="error" /></td> </tr>
		<tr><td>Enter Password:</td> <td>   <form:input path="password"/> </td><td><form:errors path="password" cssClass="error" /></td> </tr>
		<tr><td>Date of Birth:</td> <td> <form:input path="dob" type = "date"/> </td><td><form:errors path="dob" cssClass="error" /></td> <td></tr>
		<tr><td>Select Gender: </td> <td><form:radiobutton path="gender" value = "Male"/>Male&nbsp;
					<form:radiobutton path="gender" value = "Female"/>Female&nbsp;</td><td><form:errors path="gender" cssClass="error" /></td> </tr>
		<tr><td>Departement: </td> <td>
		<form:select path="department">
			<form:option value="">Select</form:option>
			<form:option value="Support">Support</form:option>
			<form:option value="Testing">Testing</form:option>
			<form:option value="Development">Development</form:option>
			<form:option value="Business Analyst">Business Analyst</form:option>
		</td> <td></form:select> <form:errors path="department" cssClass="error" /></td></tr>
		<form:hidden path = "id"/>
		</table>
		<br></br>
		<button type = "submit">Save</button>
	</form:form>
	
	</center>
</body>
</html>