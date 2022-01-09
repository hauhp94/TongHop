
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
<title>Create new service</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Tạo mới
		dịch vụ</h3>

		<form:form action="/service/create" method="post" class="border p-3 bg-light"
			modelAttribute="serviceDto">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maDichVu">Mã dịch vụ</label>
					<form:input path="maDV" class="form-control" />
					<form:errors cssStyle="color:red" path="maDV"  />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="tenDichVu">Tên dich vu</label>
					<form:input type="text" class="form-control" name="tenDichVu"
						id="tenDichVu" path="tenDV" />
					<form:errors cssStyle="color:red" path="tenDV" />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donViTinh">Đơn vị tính</label>
					<form:input type="text" path="donViTinh" class="form-control"
						name="donViTinh" id="donViTinh" />
					<form:errors path="donViTinh" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donGia">Đơn giá</label>
					<form:input type="text" path="donGia" class="form-control"
						name="donGia" id="donGia" />
					<form:errors path="donGia" cssStyle="color:red"/>
				</div>
			</div>
			<div class="justify-content-center d-flex">
				<button class="btn btn-primary mx-1" type="submit">Tao</button>
				<input name="" id="" class="btn btn-secondary mx-1" type="reset"
					value="Nhập lại">
			</div>

		</form:form>

	</div>
</body>

</html>