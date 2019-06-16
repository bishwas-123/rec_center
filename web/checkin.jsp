<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Check-In</title>
	<link href="resources/css/user_registration.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/pkscriptt.js"></script>
</head>
<body>

	<fieldset>
		<div>
			<label for="id">Id</label> <input type="number" id="id" placeholder="Member Id" />
			<input id="btn_add" type="submit" value="Check-In/Out" />
		</div>
	</fieldset>


	<table id="tbl_checkin">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Check-In Date</th>
				<th>In Time</th>
				<th>Out Time</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.fullName}" /></td>
					<td><c:out value="${user.memberSince}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>