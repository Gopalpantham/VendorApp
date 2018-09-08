<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Documents Page!!</title>
</head>
<body>
	<center>
		<%@include file="UserMenu.jsp"%><h3>Welcome to Document Upload Page!!</h3>
		<form action="uploadDoc" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="fileId" /></td>
				</tr>
				<tr>
					<td>DOC</td>
					<td><input type="file" name="fileName" /></td>
				</tr>
				<tr></tr>
				<td></td>
				<td><input type="submit" value="Upload" /></td>
			</table>
		</form>
		<hr />
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>DOWNLOAD</th>
			</tr>
			<c:forEach items="${docs}" var="obj">
				<tr>
					<td><c:out value="${obj[0]}" /></td>
					<td><c:out value="${obj[1]}" /></td>
					<td><a href="downloadDoc?docId=${obj[0]}">Download</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>