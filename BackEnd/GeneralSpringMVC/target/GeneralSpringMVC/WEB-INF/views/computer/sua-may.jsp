
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create new computer</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Sửa máy</h3>

		<form:form action="/computer/edit" method="post" class="border p-3 bg-light"
			modelAttribute="computerDto">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maMay">Mã máy</label>
					<form:input path="maMay" class="form-control" readonly="true"/>
					<form:errors cssStyle="color:red" path="maMay"  />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="viTri">Vị trí</label>
					<form:input type="text" class="form-control" name="viTri"
						id="viTri" path="viTri" />
					<form:errors cssStyle="color:red" path="viTri" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="trangThai">Trạng thái</label>
					<form:input type="text" path="trangThai" class="form-control"
						name="trangThai" id="trangThai" />
					<form:errors path="trangThai" cssStyle="color:red"/>
				</div>
			</div>
			<div class="justify-content-center d-flex">
				<button class="btn btn-primary mx-1" type="submit">Sửa</button>
				<input name="" id="" class="btn btn-secondary mx-1" type="reset"
					value="Nhập lại">
			</div>

		</form:form>

	</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	
</body>

</html>