<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Edit Page!!</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<center>
<h3>Welcome Customer Edit Page!!</h3>
			<form action="updateCus" method="post">
				<table><tr><td> ID</td><td><input type="Number" name="custId" value="${cust.custId}"
						readonly="readonly" /></td></tr>
				<tr><td>NAME</td><td><input type="text" name="custName" value="${cust.custName}" /></td></tr>
				<tr><td>EMAIL</td><td><input type="Email" name="custEmail" value="${cust.custEmail}" placeholder="mailId@gmail.com"/></td></tr>
				<tr><td>TYPE</td><td><c:choose>
 <c:when test="${'CONSUMER' eq ct.custType}">
  <input type="radio" name="custType" value="CONSUMER" Checked="checked">CONSUMER
       <input type="radio" name="custType" value="SELLER">SELLER
       </c:when>
       <c:otherwise>
       <input type="radio" name="custType" value="CONSUMER">CONSUMER
       <input type="radio" name="custType" value="SELLER"
								Checked="checked">SELLER
       </c:otherwise>
   </c:choose></td></tr>
				 <tr><td> ADDRESS</td><td> <textarea name="custAddr">${cust.custAddr}</textarea></td></tr>
	<%-- 			<tr><td>PASSWORD</td><td><input type="text" name="password" value="${cust.password}" /></td></tr>
				 <tr><td>TOKEN</td><td><input type="text" name="accTock" value="${cust.accTock}" /></td></tr>
	 --%>			<tr><td></td><td><input type="submit" value="Update!!" /></td></tr>
				</table>
		</form></center>
</body>
</html>