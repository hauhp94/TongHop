
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
<title>Create new customer</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Sửa thông tin khách hàng</h3>

		<form:form action="/customer/edit" method="post"
			modelAttribute="customerDto">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maKhachHang">Mã khách hàng</label>
					<form:input path="maKH" class="form-control" readonly="true" />
					<form:errors cssStyle="color:red" path="maKH" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="tenKhachHang">Tên khách hàng</label>
					<form:input type="text" class="form-control" name="tenKhachHang"
						id="tenKhachHang" path="tenKH" />
					<form:errors cssStyle="color:red" path="tenKH" />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="diaChi">Địa chỉ</label>
					<form:input type="text" path="diaChi" class="form-control"
						name="diaChi" id="diaChi" />
					<form:errors path="diaChi" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soDienThoai">Số điện thoại</label>
					<form:input type="text" path="soDienThoai" class="form-control"
						name="soDienThoai" id="soDienThoai" />
					<form:errors path="soDienThoai" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="email">Email</label>
					<form:input type="text" path="email" class="form-control"
						name="email" id="email" />
					<form:errors path="email" cssStyle="color:red"/>


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