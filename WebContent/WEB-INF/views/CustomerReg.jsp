<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Register Page!!</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<center><h3>Welcome to Customer Register Page!!</h3>

<form action="custReg"  method="post">
<table><tr><td>ID</td><td><input type="Number" name="custId"/></td></tr>
<tr><td>NAME</td><td><input type="text"  name="custName"/></td></tr>
<tr><td>EMAIL</td><td><input type="Email"  name="custEmail" placeholder="mailId@gmail.com"/></td></tr>
<tr><td>TYPE</td><td><select name="custType"><option  value="">---Select---</option>
<option value="CONSUMER">CONSUMER</option>
<option  value="SELLER">SELLER</option>
</select></td></tr>
<tr><td>ADDRESS</td><td><textarea  name="custAddr"></textarea></td></tr> 
<!-- <tr><td>PASSWORD</td><td><input type="password"  name="password"/></td></tr>
<tr><td>TOKEN</td><td><input type="password"  name="accTock"/></td></tr>  -->
<tr><td></td><td><input type="submit" value="Register"></td></tr>
</table>
</form>
${msg}
</center>
</body>
</html>