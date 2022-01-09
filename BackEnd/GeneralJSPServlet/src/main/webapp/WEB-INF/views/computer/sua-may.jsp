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
		<h3 class="justify-content-center d-flex text-primary">Sửa thông tin máy</h3>
		<form class="border p-3 bg-light" action="computer" method="post">
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="maMay" value="${computer.getMaMay() }">

			<div class="row ">
				<div class="form-group col-6 col-sm-6">
					<label for="viTri">Vị trí</label> <input type="text"
						value="${computer.getViTri()}" class="form-control" name="viTri"
						id="viTri" aria-describedby="helpId" placeholder=""> <small
						id="helpId" class="form-text text-muted">Help text</small>
				</div>
				<div class="form-group col-6 col-sm-6">
					<label for="trangThai">Trạng thái</label> <input type="text"
						value="${computer.getTrangThai()}" class="form-control"
						name="trangThai" id="trangThai" aria-describedby="helpId"
						placeholder=""> <small id="helpId"
						class="form-text text-muted">Help text</small>
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