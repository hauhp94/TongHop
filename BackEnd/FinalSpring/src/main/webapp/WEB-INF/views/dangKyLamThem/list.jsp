
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
<title>Danh sach dang ky</title>

</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<h3 class="justify-content-center d-flex text-primary">Danh sách
			đăng ký</h3>
		<c:if test="${message != null}">
			<h3>${message}</h3>
		</c:if>
		<form action="/viecLam/list" method="get"
			class="form-inline justify-content-center">
			<span class="m-1">Search </span> <input type="search"
				name="keyWord" class="form-control m-1" placeholder="name "
				value="${keyWord}">
			<button type="submit" class="btn btn-primary m-1">Search</button>
		</form>
		<table class="table table-striped table-bordered " id="tableCustomer">
			<thead class="thead-dark">
				<tr>
					<th>Mã đăng ký</th>
					<th>Mã nhân viên</th>
					<th>Họ tên</th>
					<th>Giới tính</th>
					<th>Cấp bậc</th>
					<th>Mã việc làm</th>
					<th>Số ngày công</th>
					<th>Tổng tiền</th>
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${dangKyLamThems.isEmpty() }">
					<tr>
						<td colspan="10">Không tìm thấy </td>
					</tr>
				</c:if>
				<c:forEach items="${dangKyLamThems }" var="dangKyLamThem">
					<tr>
						<td>${dangKyLamThem.getMaDK()}</td>
						<td>${dangKyLamThem.getMaNV()}</td>
						<td>${dangKyLamThem.getHoTen()}</td>
						<td>${dangKyLamThem.getGioiTinh()}</td>
						<c:if test="${dangKyLamThem.getCapBac() == 500000}">
						<td>1</td>
						</c:if>
						<c:if test="${dangKyLamThem.getCapBac() == 600000}">
						<td>2</td>
						</c:if>
						<c:if test="${dangKyLamThem.getCapBac() == 700000}">
						<td>3</td>
						</c:if>
						
						
						
						<td>${dangKyLamThem.getMaVL()}</td>
						<td>${dangKyLamThem.getSoNgayCong()}</td>
						<td>${dangKyLamThem.getTongTien()}</td>
						<td><a class="btn btn-secondary"
							href="edit/${dangKyLamThem.getMaDK()}"><i class="fas fa-edit"></i>
						</a></td>
						<td><button class="btn btn-danger deleteCustomer"
								value="${dangKyLamThem.getMaDK()}" data-toggle="modal"
								data-target="#exampleModal">
								<i class="fas fa-trash-alt"></i>
							</button></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
			<c:if test="${!dangKyLamThems.isEmpty() }">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center ">
				<c:if test="${page > 0 }">
					<li><a class="btn btn-info mx-1"
						href="/dangKyLamThem/list?page=${page -1}"><</a></li>
				</c:if>
				<c:forEach var="i" begin="0" end="${totalPage -1}">
					<li><a href="/dangKyLamThem/list?page=${i}"
						class="${page== i ? 'btn btn-primary' : 'btn btn-secondary' } mx-1">
							${i+1 }</a></li>
				</c:forEach>
				<c:if test="${page < totalPage -1}">
					<li><a class="btn btn-info mx-1"
						href="/dangKyLamThem/list?page=${page +1}">></a></li>
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
				<form action="/dangKyLamThem/delete" method="post">
					<div class="modal-body">
						<input type="hidden" name="maVL" id="idEmployeeDelete"> <span>xóa mã đăng ký = <span id="idDel"></span>
						</span>
						<p>Bạn có muốn xóa mã đăng ký này?</p>
						<p class="text-warning">
							<small>This action cannot be undone.</small>
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-primary">Xóa</button>
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