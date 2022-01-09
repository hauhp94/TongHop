
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
			đăng ký máy</h3>
			<c:if test="${message != null }">
			<h2 style="color: blue">${message}</h2>
			</c:if>


		<table class="table table-striped table-bordered " id="tableCustomer">
			<thead class="thead-dark">
				<tr>
					<th>Mã khách hàng</th>
					<th>Mã máy</th>
					<th>Ngày bắt đầu sử dụng</th>
					<th>Giờ bắt đầu sử dụng</th>
					<th>Thời gian sử dụng</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${registerComputers.isEmpty() }">
					<tr>
						<td colspan="7">Không tìm thấy </td>
					</tr>
				</c:if>
				<c:forEach items="${registerComputers }" var="registerComputer">
					<tr>
						<td>${registerComputer.getMaKH()}</td>
						<td>${registerComputer.getMaMay()}</td>
						<td>${registerComputer.getNgayBatDauSuDung()}</td>
						<td>${registerComputer.getGioBatDauSuDung()}</td>
						<td>${registerComputer.getThoiGianSuDung()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>


	<jsp:include page="../layout/footer.jsp"></jsp:include>


	<script>
		function onDelete(id, name) {
			document.getElementById("maKH").value = id;
			document.getElementById("tenKH").value = name;
		}
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