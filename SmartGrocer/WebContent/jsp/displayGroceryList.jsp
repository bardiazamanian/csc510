<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SmartGrocer</title>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/MyFunctions.js"></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flatly.css">
</head>
<body>
	<table class="table table-striped table-hover " id="SLTable">
		<tbody>
			<c:forEach var="item" items="${sll}">
				<tr>
					<td><c:out value="${item.getItem()}"/></td>
					<td><c:out value="${item.getItemCount()}"/></td>
					<td><c:out value="${item.getItemPrice()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button class="button" onclick="saveShoppingList()">Save Shopping List</button>
</body>
</html>