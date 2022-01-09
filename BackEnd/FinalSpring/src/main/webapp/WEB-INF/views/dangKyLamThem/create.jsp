
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
<title>Dang Ky</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Đăng ký làm thêm</h3>

		<form:form action="/dangKyLamThem/create" method="post" class="border p-3 bg-light"
			modelAttribute="dangKyLamThemDto">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maDK">Mã đăng ký</label>
					<form:input path="maDK" class="form-control" />
					<form:errors cssStyle="color:red" path="maDK"  />
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="maNV">Mã nhân viên</label>
					<form:input type="text" class="form-control" name="maNV"
						id="maNV" path="maNV" />
					<form:errors cssStyle="color:red" path="maNV" />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="hoTen">Họ tên</label>
					<form:input type="text" path="hoTen" class="form-control"
						name="hoTen" id="hoTen" />
					<form:errors path="hoTen" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="gioiTinh">Giới tính</label>
					<form:input type="text" path="gioiTinh" class="form-control"
						name="gioiTinh" id="gioiTinh" />
					<form:errors path="gioiTinh" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="capBac">Cấp bậc</label>		
					<form:select path="capBac"  class="form-control" name="capBac" id="capBac" >
					    <form:option value="500000"> Cap 1 - 500.000/ngay</form:option>
					    <form:option value="600000"> Cap 2 - 600.000/ngay</form:option>
					    <form:option value="700000"> Cap 3 - 700.000/ngay</form:option>
					</form:select>
					<form:errors path="capBac" cssStyle="color:red"/>		
				</div>
				
				<div class="form-group col-6 col-sm-6">
					<label for="maVL">Mã việc làm</label>
					<form:input type="text" path="maVL" class="form-control"
						name="maVL" id="maVL" />
					<form:errors path="maVL" cssStyle="color:red"/>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="soNgayCong">Số ngày công</label>
					<form:input type="number" path="soNgayCong" class="form-control" 
						name="soNgayCong" id="soNgayCong" />
					<form:errors path="soNgayCong" cssStyle="color:red"/>
				</div>
			
			</div>
			<div class="justify-content-center d-flex">
				<button class="btn btn-primary mx-1" type="submit">Tạo</button>
				<input name="" id="" class="btn btn-secondary mx-1" type="reset"
					value="Nhập lại">
			</div>

		</form:form>

	</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	
</body>


</html>