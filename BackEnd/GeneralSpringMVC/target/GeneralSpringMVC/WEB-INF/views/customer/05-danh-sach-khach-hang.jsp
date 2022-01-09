
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
			khách hàng</h3>
		<c:if test="${message != null}">
			<h3>${message}</h3>
		</c:if>
		<form action="/customer/list" method="get"
			class="form-inline justify-content-center">
			<span class="m-1">Search Customer </span> <input type="search"
				name="keyWord" class="form-control m-1" placeholder="name "
				value="${keyWord}">
			<button type="submit" class="btn btn-primary m-1">Search</button>
		</form>
		<table class="table table-striped table-bordered " id="tableCustomer">
			<thead class="thead-dark">
				<tr>
					<th>Mã khách hàng</th>
					<th>Tên khách hàng</th>
					<th>Địa chỉ</th>
					<th>Số điện thoại</th>
					<th>Email</th>
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${customers.isEmpty() }">
					<tr>
						<td colspan="7">Không tìm thấy khách hàng</td>
					</tr>
				</c:if>
				<c:forEach items="${customers }" var="customer">
					<tr>
						<td>${customer.getMaKH()}</td>
						<td>${customer.getTenKH()}</td>
						<td>${customer.getDiaChi()}</td>
						<td>${customer.getSoDienThoai()}</td>
						<td>${customer.getEmail()}</td>
						<td><a class="btn btn-secondary"
							href="edit/${customer.getMaKH()}"><i class="fas fa-edit"></i>
						</a></td>
						<td><button class="btn btn-danger deleteCustomer"
								value="${customer.getMaKH()}" data-toggle="modal"
								data-target="#exampleModal">
								<i class="fas fa-trash-alt"></i>
							</button></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
			<c:if test="${!customers.isEmpty() }">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center ">
				<c:if test="${page > 0 }">
					<li><a class="btn btn-info mx-1"
						href="/customer/list?page=${page -1}"><</a></li>
				</c:if>
				<c:forEach var="i" begin="0" end="${totalPage -1}">
					<li><a href="/customer/list?page=${i}"
						class="${page== i ? 'btn btn-primary' : 'btn btn-secondary' } mx-1">
							${i+1 }</a></li>
				</c:forEach>
				<c:if test="${page < totalPage -1}">
					<li><a class="btn btn-info mx-1"
						href="/customer/list?page=${page +1}">></a></li>
				</c:if>
			</ul>
		</nav>
		</c:if>


	</div>



	<!-- Modal delete -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Delete customer</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/customer/delete" method="post">
					<div class="modal-body">
						<input type="hidden" name="maKH" id="idEmployeeDelete"> <span>Delete
							customer code = <span id="idDel"></span>
						</span>
						<p>Are you sure you want to delete this customer?</p>
						<p class="text-warning">
							<small>This action cannot be undone.</small>
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-primary">Delete</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--        kết thúc modal delete-->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			// delete customer confirm
			$(".deleteCustomer").click(function() {
				let idEmployeeDelete = $(this).val();
				$("#idDel").html(idEmployeeDelete);
				$("#idEmployeeDelete").val(idEmployeeDelete);
			})
		})
	</script>

	<script>
		function onDelete(id, name) {
			document.getElementById("maKH").value = id;
			document.getElementById("tenKH").value = name;
		}
	</script>
</body>
</html>