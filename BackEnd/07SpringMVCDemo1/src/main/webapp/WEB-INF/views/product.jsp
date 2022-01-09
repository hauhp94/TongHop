<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Thong tin Product</h2>
		<form:form method="POST" action="add_product" modelAttribute="product">
			<form:hidden path="id"/>
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input path="name" cssClass="form-control" id="name"/>
			</div>
			<div class="form-group">
				<label for="age">Price:</label>
				<form:input path="price" cssClass="form-control" id="price"/>
			</div>
			<div class="form-group">
				<label for="age">Description:</label>
				<form:input path="description" cssClass="form-control" id="description"/>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>