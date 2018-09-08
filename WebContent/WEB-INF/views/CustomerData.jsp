<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="UserMenu.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer View page!!</title> 
</head>
<body>
<center>
<h3>Welcome to Customer View page!!</h3> 
<a href="custExcelExport">Export Excel</a>
<a href="custPdfExport">Export PDF</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>TYPE</th>
			<th>ADDRESS</th>
			<th>PASSWORD</th>
			<th>TOKEN</th>
			<th>OPERATIONS</th>
		</tr>
		<c:forEach items="${customer}" var="ct">
			<tr>
				<td><c:out value="${ct.custId}"></c:out></td>
				<td><c:out value="${ct.custName}"></c:out></td>
				<td><c:out value="${ct.custEmail}"></c:out></td>
				<td><c:out value="${ct.custType}"></c:out></td>
				<td><c:out value="${ct.custAddr}"></c:out></td>
				<td><c:out value="${ct.password}"></c:out></td>
				<td><c:out value="${ct.accTock}"></c:out></td>
				<td>
          <a href="deleteCus?custId=${ct.custId}"> 
          <img src="../images/delete.jpg" width="20" height="20"></a>
<a href="editCus?custId=${ct.custId}">
 <img src="../images/edit.png" width="20" height="20"></a></td>
				
			</tr>
		</c:forEach>
		
	</table>
	</center>
</body>
</html>