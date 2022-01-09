<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->

</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Sửa thông tin khách hàng</h3>
		<form class="border p-3 bg-light" action="customer" method="post">
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="maKH" value="${customer.getMaKH() }">

			<div class="row">

				<div class="form-group col-6 col-sm-6">
					<label for="tenKhachHang">Tên khách hàng</label> <input type="text" value="${customer.getTenKH() }"
						class="form-control" name="tenKhachHang" id="tenKhachHang"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="diaChi">Địa chỉ</label> <input type="text" value="${customer.getDiaChi() }"
						class="form-control" name="diaChi" id="diaChi"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soDienThoai">Số điện thoại</label> <input type="text" value="${customer.getSoDienThoai() }"
						class="form-control" name="soDienThoai" id="soDienThoai"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="email">Email</label> <input type="text" value="${customer.getEmail() }"
						class="form-control" name="email" id="email"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
			</div>
			<div class="justify-content-center d-flex">
				<input name="" id="" class="btn btn-primary mx-1" type="submit"
					value="Sửa"> <input name="" id=""
					class="btn btn-secondary mx-1" type="reset" value="Nhập lại">
			</div>
		</form>
	</div>
</body>
</html>