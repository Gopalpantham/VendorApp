<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Edit Page</title>
</head>
<center>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Item Edit Page!!</h3>
<form action="updateItem" method="post">
<table>

<tr>
	<td>ID</td>
	<td><input type="Number" name="itemId" value="${it.itemId}" readonly="readonly"/></td>
</tr>

	<td>NAME</td>
	<td><input type="text" name="itemName" value="${it.itemName}"/></td>
</tr>
<tr>
	<td>COST</td>
	<td> <input type="Number" name="itemCost" value="${it.itemCost}"/></td>
</tr>
<tr>
<tr>
	<td>DISCOUNT</td>
	<td><input type="Number" name="discount" value="${it.discount}"/>
	
	</td>
</tr> 
<tr>
	<td>CUSTOMER ID</td>
	<td><input type="Number" name="custId" value="${it.custId}"/></td>
</tr> 
	<tr>
					<td></td>
					<td><input type="submit" value="Update!!" /></td>
				</tr>
</table></form></body></center></html>