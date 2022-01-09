
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
			khách hàng</h3>
		<form action="customer" method="get" class="my-2">
			<input type="hidden" name="action" value="search">


			<div class="input-group">
				<input class="form-control" type="text" name="tenKH"
					placeholder="Ten khach hang" aria-label="Recipient's "
					aria-describedby="my-addon">
				<div class="input-group-append">
					<button type="submit" class="input-group-text" id="my-addon">
						Search by name</button>
				</div>
			</div>
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
							href="customer?action=update&maKH=${customer.getMaKH()}"><i
								class="fas fa-edit"></i> </a></td>
						<td><a class="btn btn-danger" onclick="onDelete('${customer.getMaKH()}','${customer.getTenKH()}')" 
						data-toggle="modal" data-target="#modelId"
							href="customer?action=delete&maKH=${customer.getMaKH()}"><i
								class="fas fa-trash-alt"></i> </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>



  <%--            modal delete--%>
    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="customer" method="get">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="maKH"  id="maKH">
                    <div class="modal-body">
                        Ban co muon xoa <input disable id="tenKH" >
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Ok</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	<jsp:include page="../layout/footer.jsp"></jsp:include>

	<script>
	function onDelete(id, name) {
        document.getElementById("maKH").value = id;
        document.getElementById("tenKH").value = name;
    }
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
</body>
</html>