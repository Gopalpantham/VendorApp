<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Register Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<center>

		<h3>Welcome to Vendor Register Page!!</h3>

		<form action="insertven" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="Number" name="VenId" /></td>
				</tr>
				<tr>
					<td>CODE</td>
					<td><input type="text" name="VenCode" /></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="VenName" /></td>
				</tr>
				<tr>
					<td>TYPE</td>
					<td><input type="radio" name="VenType" value="CONTRACT">CONTRACT
						<input type="radio" name="VenType" value="FULLTIME">FULLTIME
						 <input type="radio" name="VenType" value="PARTTIME">PARTTIME</td>
				</tr>
				<tr>
					<td>ADDRESS</td>
					<td><textarea name="VenAddr"></textarea></td>
				</tr>
				<tr>
					<td>ID PROOF</td>
					<td><select name="VenIdType">
							<option>--SELECT--</option>
							<option value="PAN">PAN</option>
							<option value="VOTERID">VOTER ID</option>
							<option value="OTHER">OTHER</option>
					</select></td>
				</tr>
				<tr>
					<td>ID NUM</td>
					<td><input type="Number" name="VenIdNum" /></td>
				</tr>
				<tr>
					<td>NOTE</td>
					<td><input type="text" name="VenDsc" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register!!" /></td>
				</tr>
			</table>
		</form>
		${msg} <br />
	</center>
</body>
</html>