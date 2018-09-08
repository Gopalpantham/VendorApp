<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Register Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<center>
		<h3>Welcome to Item Register Page!!</h3>
		<form action="insertIt" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="Number"  name="itemId" /></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="itemName" /></td>
				</tr>
				<tr>
					<td>COST</td>
					<td><input type="Number" name="itemCost" /></td>
				</tr>
				<tr>
					<td>DISCOUNT</td>
					<td><input type="Number" name="discount"></td>
				</tr>
				<tr>
					<td>CUSTOMER ID</td>
					<td><input type="Number" name="custId"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create!!" /></td>
				</tr>
			</table>
		</form>${msg}
	</center>
</body>
</html>