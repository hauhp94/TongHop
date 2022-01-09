<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h1>Product List</h1>
	<table border="1">
		<tr style="background-color: orange;">
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Create At</th>
			<th>Update</th>
		</tr>
		<c:choose>
			<c:when test="${productList != null && productList.size() > 0 }">
				<c:forEach items="${productList }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.price }</td>
						<td>${item.description }</td>
						<td>${item.createAt }</td>
						<c:url value="/update_product" var="update_product">
							<c:param name="productId" value="${item.id}"></c:param>
						</c:url>
						<td><a href="${update_product}" target="blank">Detail</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">No data found</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>