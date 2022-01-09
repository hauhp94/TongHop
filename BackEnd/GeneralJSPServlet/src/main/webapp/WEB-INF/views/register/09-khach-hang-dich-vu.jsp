
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<h3 class="justify-content-center d-flex text-primary">Danh sách khách hàng đang sử dụng dịch vụ</h3>
        <table class="table table-striped table-bordered table-responsive  " id="tableCustomer"  style="overflow-x: scroll">
			<thead class="thead-dark">
                <tr>
                    <th>Mã KH</th>
                    <th>Tên KH</th>
                    <th>Mã máy</th>
                    <th>Vị trí</th>
                    <th>Trạng Thái</th>
                    <th>Ngày bắt đầu sử dụng</th>
                    <th>Giờ bắt đầu sử dụng</th>
                    <th>Thời gian sử dụng máy</th>
                    <th>Mã dịch vụ</th>
                    <th>Ngày sử dụng dịch vụ</th>
                    <th>Giờ sử dụng dịch vụ</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                </tr>
            </thead>
            <tbody>
                	<c:forEach items="${customerUsings }" var="customerUsing">
			<tr>
				<td>${customerUsing.getCustomer().getMaKH()}</td>
				<td>${customerUsing.getCustomer().getTenKH()}</td>
				<td>${customerUsing.getComputer().getMaMay()}</td>
				<td>${customerUsing.getComputer().getViTri()}</td>
				<td>${customerUsing.getComputer().getTrangThai()}</td>
				<td>${customerUsing.getNgayBatDauSuDung()}</td>
				<td>${customerUsing.getGioBatDauSuDung()}</td>
				<td>${customerUsing.getThoiGianSuDung()}</td>
				<td>${customerUsing.getService().getMaDV()}</td>
				<td>${customerUsing.getNgaySuDung()}</td>
				<td>${customerUsing.getGioSuDung()}</td>
				<td>${customerUsing.getSoLuong()}</td>
				<td>${customerUsing.getTongTien()}</td>
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