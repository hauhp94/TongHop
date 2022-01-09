
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register service</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Đăng ký sử
			dụng dịch vụ</h3>

		<form:form action="/registerService/create" method="post"
			class="border p-3 bg-light" modelAttribute="registerServiceDto">
			<div class="row">

				<div class="form-group col-6 col-sm-6">
					<label for="maKH">Mã khách hàng</label>
					<form:select path="maKH" items="${danhSachMaKhachHang}"  class="form-control" />
					<form:errors cssStyle="color:red" path="maKH" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="maDV">Mã dịch vụ</label>
					<form:select type="text" class="form-control" name="maDV"
						id="maDV" path="maDV" items="${danhSachMaDichVu}" />
					<form:errors cssStyle="color:red" path="maDV" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="datepicker">Ngày sử dụng</label>					
					<form:input  path="ngaySuDung" type="text"  class="form-control datepicker" 
					 name="ngaySuDung"  />	
					<form:errors path="ngaySuDung" cssStyle="color:red" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="gioSuDung">Giờ sử dụng</label>
					<form:input type="text" path="gioSuDung" class="form-control timepicker" 
						name="gioSuDung" id="gioSuDung" />
					<form:errors path="gioSuDung" cssStyle="color:red" />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soLuong">Số lượng</label>
					<form:input type="text" class="form-control" name="soLuong"
						id="soLuong" path="soLuong" />
					<form:errors cssStyle="color:red" path="soLuong" />
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