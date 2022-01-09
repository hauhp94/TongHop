
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
		<h3 class="justify-content-center d-flex text-primary">Tạo mới dịch vụ</h3>
		<form class="border p-3 bg-light" action="service" method="post">
			<input type="hidden" name="action" value="create">
			<div class="row">
			<div class="form-group col-6 col-sm-6">
					<label for="maDichVu">Mã dịch vụ</label> <input type="text"
						class="form-control" name="maDichVu" id="maDichVu"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="tenDichVu">Tên dịch vụ</label> <input type="text"
						class="form-control" name="tenDichVu" id="tenDichVu"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donViTinh">Đơn vị tính</label> <input type="text"
						class="form-control" name="donViTinh" id="donViTinh"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donGia">Đơn giá</label> <input type="text"
						class="form-control" name="donGia" id="donGia"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
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