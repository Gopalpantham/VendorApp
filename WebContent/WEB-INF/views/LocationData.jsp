<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table tr th{color:red; 
abckground-color:black;}</style>
<title>Location View Page</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<center>
 <h3>Welcome to Location view page!!</h3> 
<a href="locExcelExport">Export Excel</a>
<a href="locPdfExport">Export PDF</a>
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>CODE</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
<th>OPERATIONS</th>
</tr>
<c:forEach items="${location}" var="loc">
<tr>
<td><c:out value="${loc.locId}"/></td>
<td><c:out value="${loc.locName}"/></td>
<td><c:out value="${loc.locCode}"/></td>
<td><c:out value="${loc.locType}"/></td>
<td><c:out value="${loc.locDesc}"/></td>
<td>
<a href="deleteLoc?locId=${loc.locId}"><img  src="../images/delete.jpg" width="20" height="20"></a>
<a href="editLoc?locId=${loc.locId}"><img  src="../images/edit.png" width="20" height="20"></a></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>