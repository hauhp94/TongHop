
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

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
		<h3 class="justify-content-center d-flex text-primary">Đăng ký sử
			dụng máy</h3>

		<form:form action="/registerComputer/create" method="post"
			class="border p-3 bg-light" modelAttribute="registerComputerDto">
			<div class="row">

				<div class="form-group col-6 col-sm-6">
					<label for="maKH">Mã khách hàng</label>
					<form:select path="maKH" items="${danhSachMaKhachHang}" class="form-control" />
					<form:errors cssStyle="color:red" path="maKH" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="maMay">Mã máy</label>
					<form:select type="text" class="form-control" name="maMay"
						id="maMay" path="maMay" items="${danhSachMaMay}" />
					<form:errors cssStyle="color:red" path="maMay" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="ngayBatDauSuDung">Ngày bắt đầu sử dụng</label>
					<form:input type="text" path="ngayBatDauSuDung"
						class="form-control" name="ngayBatDauSuDung" id="ngayBatDauSuDung" />
					<form:errors path="ngayBatDauSuDung" cssStyle="color:red" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="gioBatDauSuDung">Giờ bắt đầu sử dụng</label>
					<form:input type="text" path="gioBatDauSuDung" class="form-control"
						name="gioBatDauSuDung" id="gioBatDauSuDung" />
					<form:errors path="gioBatDauSuDung" cssStyle="color:red" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="thoiGianSuDung">Thời gian sử dụng</label>
					<form:input type="text" class="form-control" name="thoiGianSuDung"
						id="thoiGianSuDung" path="thoiGianSuDung" />
					<form:errors cssStyle="color:red" path="thoiGianSuDung" />
				</div>
			</div>
			<div class="justify-content-center d-flex">
				<button class="btn btn-primary mx-1" type="submit">Tao</button>
				<input name="" id="" class="btn btn-secondary mx-1" type="reset"
					value="Nhập lại">
			</div>

		</form:form>

	</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	
</body>

</html>