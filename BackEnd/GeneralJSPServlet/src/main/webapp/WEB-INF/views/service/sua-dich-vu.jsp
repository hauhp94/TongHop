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
		<h3 class="justify-content-center d-flex text-primary">Sửa thông tin dịch vụ</h3>
		<form class="border p-3 bg-light" action="service" method="post">
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="maDV" value="${service.getMaDV() }">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="tenDichVu">Tên dịch vụ</label> <input type="text" value="${service.getTenDV() }"
						class="form-control" name="tenDichVu" id="tenDichVu"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donViTinh">Đơn vị tính</label> <input type="text" value="${service.getDonViTinh() }"
						class="form-control" name="donViTinh" id="donViTinh"
						aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="donGia">Đơn giá</label> <input type="text" value="${service.getDonGia() }"
						class="form-control" name="donGia" id="donGia"
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