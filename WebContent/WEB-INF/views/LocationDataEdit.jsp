<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@include file="UserMenu.jsp"%>
	<center>
		<h3>Welcome to Location Edit Page!!</h3>
		<form action="updateLoc" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="Number" name="locId" value="${loc.locId}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="locName" value="${loc.locName}" /></td>
				</tr>
				<tr>
					<td>CODE</td>
					<td><input type="text" name="locCode" value="${loc.locCode}" /></td>
				</tr>
				<tr>
					<td>TYPE</td>
					<td><c:choose>
							<c:when test="${'Urban' eq loc.locType}">
								<input type="radio" name="locType" value="Urban"
									Checked="checked">Urban
       <input type="radio" name="locType" value="Rural">Rural
       </c:when>
							<c:otherwise>
								<input type="radio" name="locType" value="Urban">Urban
       <input type="radio" name="locType" value="Rural"
									Checked="checked">Rural
       </c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>DESCRIPTION</td>
					<td><textarea name="locDesc">${loc.locDesc}</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update!!" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>