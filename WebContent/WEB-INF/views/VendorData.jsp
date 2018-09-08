<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to View Page!!</title>
</head>
<body><%@include file="UserMenu.jsp" %><center>
 <h3>Welcome to Vendor view page!!</h3> 
<a href="venExcelExport">Export Excel</a>
<a href="venPdfExport">Export Pdf</a>
 <table border="1">
<tr>
<th>ID</th>
<th>CODE</th>
<th>NAME</th>
<th>TYPE</th>
<th>ADDRESS</th>
<th>ID PROOF</th>
<th>ID NUM</th>
<th>NOTE</th>
<th>OPERATIONS</th>
</tr>
<c:forEach items="${vendor}" var="ven">
<tr>
<td><c:out value="${ven.venId}"/></td>
<td><c:out value="${ven.venCode}"/></td>
<td><c:out value="${ven.venName}"/></td>
<td><c:out value="${ven.venType}"/></td>
<td><c:out value="${ven.venAddr}"/></td>
<td><c:out value="${ven.venIdType}"/></td>
<td><c:out value="${ven.venIdNum}"/></td>
<td><c:out value="${ven.venDsc}"/></td>
<td>
<a href="deleteVen?venId=${ven.venId}"><img  src="../images/delete.jpg" width="20" height="20"></a>
<a href="editVen?venId=${ven.venId}"><img  src="../images/edit.png" width="20" height="20"></a></td>
</tr>
</c:forEach>
 
</table>
 </center>
</body> </html>