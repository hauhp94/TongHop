
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
		<h3 class="justify-content-center d-flex text-primary">Đăng ký sử dụng dịch vụ</h3>
		<form class="border p-3 bg-light" action="registerService"
			method="post">
			<input type="hidden" name="action" value="create">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maKH">Mã khách hàng</label> <select
						class="form-control" name="maKH" id="maKH">
						<c:forEach items="${customers }" var="customer">
							<option value="${customer.getMaKH()}">${customer.getMaKH()} - ${customer.getTenKH()}
								</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="maDV">Mã dịch vụ</label> <select class="form-control"
						name="maDV" id="maDV">
						<c:forEach items="${services }" var="service">
							<option value="${service.getMaDV()}">${service.getMaDV()} - ${service.getTenDV()} </option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="ngaySuDung">Ngày sử dụng</label> <input
						type="date" class="form-control" name="ngaySuDung"
						id="ngaySuDung" aria-describedby="helpId" placeholder="">
					<small id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="gioSuDung">Giờ  sử dụng</label> <input
						type="time" class="form-control" name="gioSuDung"
						id="gioSuDung" aria-describedby="helpId" placeholder="">
					<small id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soLuong">Số lượng</label> <input
						type="number" class="form-control" name="soLuong"
						id="soLuong" aria-describedby="helpId" placeholder="">
					<small id="helpId" class="form-text text-muted">Help text</small>
				</div>
			</div>
			<div class="justify-content-center d-flex"> 
                <input name="" id="" class="btn btn-primary mx-1" type="submit" value="Đăng ký">
                <input name="" id="" class="btn btn-secondary mx-1" type="reset" value="Nhập lại">
            </div>
		</form>

	</div>
</body>

</html>