<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Vendor Register Page!!</title> 
</head><center>
<body>
<%@include file="UserMenu.jsp" %>
<h3>Welcome to Vendor Register Page!!</h3> 
<form action="updateVen" method="post">
<table>
<tr>
	<td>ID</td>
	<td><input type="Number" name="venId" value="${ven.venId}" readonly="readonly"/></td>
</tr>
<tr>
	<td>CODE</td>
	<td> <input type="text" name="venCode" value="${ven.venCode}"/></td>
</tr>
<tr>
	<td>NAME</td>
	<td><input type="text" name="venName" value="${ven.venName}"/></td>
</tr>
<tr>
	<td>TYPE</td>
	<td>
	<c:forEach items="${venTypesList}" var="venTypeOb">
		 <c:choose>
		 	<c:when test="${ven.venType eq venTypeOb }">
		 		<input type="radio" name="venType" value="${venTypeOb}" checked="checked">${venTypeOb}
		 	</c:when>
		 	<c:otherwise>
		 	 	<input type="radio" name="venType" value="${venTypeOb}">${venTypeOb}
		 	</c:otherwise>
		 </c:choose>
  	   </c:forEach>
	
	</td>
</tr> 
<tr>
	<td>ADDRESS</td>
	<td><textarea name="venAddr">${ven.venAddr}</textarea></td>
</tr> 
<tr>
	<td>ID TYPE</td>
	<td>
		<select name="venIdType">
			<option value="">--select--</option>
			<c:forEach items="${venIdTypesList}" var="venIdTypeOb">
				<c:choose>
					<c:when test="${ven.venIdType eq venIdTypeOb}">
						<option value="${venIdTypeOb}" selected="selected">${venIdTypeOb}</option>
					</c:when>
					<c:otherwise>
						<option value="${venIdTypeOb}">${venIdTypeOb}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</td>
</tr> 
<tr>
	<td>ID NUM </td>
	<td><input type="Number" name="venIdNum"  value="${ven.venIdNum}"/></td>
</tr>
<tr>
	<td>NOTE </td>
	<td><textarea name="venDsc">${ven.venDsc}</textarea></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" value="Update!!"/>		</td>
</tr>
</table></center></form></body></html>