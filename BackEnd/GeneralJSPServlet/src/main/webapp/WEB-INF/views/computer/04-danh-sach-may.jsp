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
		<h3 class="justify-content-center d-flex text-primary">Danh sách
			máy</h3>
		<c:if test="${message != null }">
			<h3 style="color: red">${message}</h3>
		</c:if>
		<table class="table table-striped table-bordered " id="tableCustomer">
			<thead class="thead-dark">
				<tr>
					<th>Mã máy</th>
					<th>Vị trí</th>
					<th>Trạng thái</th>
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${computers }" var="computer">
					<tr>
						<td>${computer.getMaMay()}</td>
						<td>${computer.getViTri()}</td>
						<td>${computer.getTrangThai()}</td>
						<td><a
							href="computer?action=update&maMay=${computer.getMaMay()}"
							class="btn btn-secondary"><i class="fas fa-edit"></i> </a></td>
						<td><a
							href="computer?action=delete&maMay=${computer.getMaMay()}"
							class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</body>
	<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
</html>