<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item View Page!!</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<center>
 <h3>Welcome to Item view page!!</h3> 
<a href="itemExcelExport">Export Excel</a>
<a href="itemPdfExport">Export PDF</a>
 <table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>COST</th>
<th>DISCOUNT</th>
<th>CUSTOMER ID</th>
<th>OPERATIONS</th>
</tr>
<c:forEach items="${it}" var="it">
<tr>
<td><c:out value="${it.itemId}"/></td>
<td><c:out value="${it.itemName}"/></td>
<td><c:out value="${it.itemCost}"/></td>
<td><c:out value="${it.discount}"/></td>
<td><c:out value="${it.custId}"/></td>
<td>
 <a href="deleteItem?itemId=${it.itemId}"><img  src="../images/delete.jpg" width="20" height="20"></a>
<a href="editItem?itemId=${it.itemId}"><img  src="../images/edit.png" width="20" height="20"></a></td>
 </tr>
</c:forEach>
</table>
</center>
</body>
</html>