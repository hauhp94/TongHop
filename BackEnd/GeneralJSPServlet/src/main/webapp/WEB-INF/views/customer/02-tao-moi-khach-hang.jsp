
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Tạo mới
			khách hàng</h3>
		<form class="border p-3 bg-light" action="customer" method="post" >
			<input type="hidden" name="action" value="create">

			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maKhachHang">Mã khách hàng</label> <input type="text"
						class="form-control" name="maKhachHang" id="maKhachHang"
						value="${customer.getMaKH()}" aria-describedby="helpId"
						placeholder="">
					<c:if test="${messageMaKH != null}">
						<small class="form-text text-danger">${messageMaKH}</small>
					</c:if>
					<c:if test="${messageExist != null}">
						<small class="form-text text-danger">${messageExist}</small>
					</c:if>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="tenKhachHang">Tên khách hàng</label> <input type="text"
						class="form-control" name="tenKhachHang" id="tenKhachHang"
						value="${customer.getTenKH()}" aria-describedby="helpId"
						placeholder="">
					<c:if test="${messageTenKH != null}">
						<small class="form-text text-danger">${messageTenKH}</small>
					</c:if>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="diaChi">Địa chỉ</label> <input type="text"
						class="form-control" name="diaChi" id="diaChi"
						aria-describedby="helpId" value="${customer.getDiaChi()}"
						placeholder="">
					<c:if test="${messageDiaChi != null}">
						<small class="form-text text-danger">${messageDiaChi}</small>
					</c:if>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soDienThoai">Số điện thoại</label> <input type="text"
						class="form-control" name="soDienThoai" id="soDienThoai"
						value="${customer.getSoDienThoai()}" aria-describedby="helpId"
						placeholder=""> <c:if test="${messageSoDienThoai != null}">
						<small class="form-text text-danger">${messageSoDienThoai}</small>
					</c:if>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="helpId" value="${customer.getEmail()}"
						placeholder=""> <c:if test="${messageEmail != null}">
						<small class="form-text text-danger">${messageEmail}</small>
					</c:if>
				</div>
			</div>
			<div class="justify-content-center d-flex">
				<input name="" id="" class="btn btn-primary mx-1" type="submit"
					value="Tạo"> <input name="" id=""
					class="btn btn-secondary mx-1" type="reset" value="Nhập lại">
			</div>

		</form>

	</div>
</body>

</html>