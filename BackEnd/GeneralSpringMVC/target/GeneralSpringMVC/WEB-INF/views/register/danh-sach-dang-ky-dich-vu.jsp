
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
<title>Document</title>

</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Danh sách
			đăng ký dịch vụ</h3>
			<c:if test="${message != null }">
			<h2 style="color: blue">${message}</h2>
			</c:if>


		<table class="table table-striped table-bordered " id="tableCustomer">
			<thead class="thead-dark">
				<tr>
					<th>Mã khách hàng</th>
					<th>Mã dịch vụ</th>
					<th>Ngày sử dụng</th>
					<th>Giờ sử dụng</th>
					<th>Số lượng</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${registerServices.isEmpty() }">
					<tr>
						<td colspan="7">Không tìm thấy </td>
					</tr>
				</c:if>
				<c:forEach items="${registerServices }" var="registerService">
					<tr>
						<td>${registerService.getMaKH()}</td>
						<td>${registerService.getMaDV()}</td>
						<td>${registerService.getNgaySuDung()}</td>
						<td>${registerService.getGioSuDung()}</td>
						<td>${registerService.getSoLuong()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>


	<jsp:include page="../layout/footer.jsp"></jsp:include>


	<script>

		$(document).ready(function() {
			$('#tableCustomer').dataTable({
				"dom" : 'lrtip',
				"lengthChange" : false,
				"pageLength" : 5
			})
		})
	</script>
</body>
</html>