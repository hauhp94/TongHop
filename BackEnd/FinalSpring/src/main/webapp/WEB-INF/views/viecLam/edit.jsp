
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
<title>Sua viec lam</title>


</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Sửa
			việc làm</h3>

		<form:form action="/viecLam/edit" method="post" class="border p-3 bg-light"
			modelAttribute="viecLamDto">
			<div class="row">
				<div class="form-group col-6 col-sm-6">
					<label for="maVL">Mã việc làm</label>
					<form:input path="maVL" class="form-control" readonly="true"/>
					<form:errors cssStyle="color:red" path="maVL"  />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="moTa">Mô tả</label>
					<form:input type="text" class="form-control" name="moTa"
						id="moTa" path="moTa" />
					<form:errors cssStyle="color:red" path="moTa" />


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="duAn">Dự án</label>
					<form:input type="text" path="duAn" class="form-control"
						name="duAn" id="duAn" />
					<form:errors path="duAn" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="ngonNgu">Ngôn ngữ</label>
					<form:input type="text" path="ngonNgu" class="form-control"
						name="ngonNgu" id="ngonNgu" />
					<form:errors path="ngonNgu" cssStyle="color:red"/>


				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="ngayBD">Ngày bắt đầu</label>
					<form:input type="text" path="ngayBD" class="form-control"
						name="ngayBD" id="ngayBD" />
					<form:errors path="ngayBD" cssStyle="color:red"/>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="ngayKT">Ngày kết thúc</label>
					<form:input type="text" path="ngayKT" class="form-control"
						name="ngayKT" id="ngayKT" />
					<form:errors path="ngayKT" cssStyle="color:red"/>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="tongNgayCong">Tổng ngày công</label>
					<form:input type="text" path="tongNgayCong" class="form-control"
						name="tongNgayCong" id="tongNgayCong" />
					<form:errors path="tongNgayCong" cssStyle="color:red"/>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="trangThai">Trạng thái</label>
					<form:input type="text" path="trangThai" class="form-control"
						name="trangThai" id="trangThai" />
					<form:errors path="trangThai" cssStyle="color:red"/>
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