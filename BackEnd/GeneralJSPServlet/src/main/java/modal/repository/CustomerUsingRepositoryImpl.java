/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.bean.Computer;
import modal.bean.Customer;
import modal.bean.CustomerUsing;
import modal.bean.Service;
import modal.service.DBConnection;

public class CustomerUsingRepositoryImpl implements CustomerUsingRepository {

	@Override
	public List<CustomerUsing> getList() {
		List<CustomerUsing> customerUsings = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		PreparedStatement statementTotalMoney = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotalMoney = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM dbo.khachHang"
						+ " LEFT JOIN dbo.suDungDichVu ON suDungDichVu.maKH = khachHang.maKH"
						+ " LEFT JOIN dbo.dichVu ON dichVu.maDV = suDungDichVu.maDV"
						+ " LEFT JOIN dbo.suDungMay ON suDungMay.maKH = khachHang.maKH"
						+ " LEFT  JOIN dbo.may ON may.maMay = suDungMay.maMay");
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String maMay = resultSet.getString("maMay");
					String viTri = resultSet.getString("viTri");
					String trangThai = resultSet.getString("trangThai");
					Computer computer = new Computer(maMay, viTri, trangThai);
					String maKH = resultSet.getString("maKH");
					String tenKH = resultSet.getString("tenKH");
					String diaChi = resultSet.getString("diaChi");
					String soDienThoai = resultSet.getString("soDienThoai");
					String email = resultSet.getString("diaChiEmail");
					Customer customer = new Customer(maKH, tenKH, diaChi, soDienThoai, email);
					String maDV = resultSet.getString("maDV");
					String tenDV = resultSet.getString("tenDV");
					String donViTinh = resultSet.getString("donViTinh");
					double donGia = 0.0;
					if(resultSet.getString("donGia")!=null) {
						donGia = Double.parseDouble(resultSet.getString("donGia"));
					}
					Service service = new Service(maDV, tenDV, donViTinh, donGia);
					String ngaySuDung = resultSet.getString("ngaySuDung");
					String gioSuDung = resultSet.getString("gioSuDung");
					int soLuong = 0;
					if(resultSet.getString("soLuong")!=null) {
						soLuong = Integer.parseInt(resultSet.getString("soLuong"));
					}
					String ngayBatDauSuDung = resultSet.getString("ngayBatDauSuDung");
					String gioBatDauSuDung = resultSet.getString("gioBatDauSuDung");
					int thoiGianSuDung = 0;

					if (resultSet.getString("thoiGianSuDung") != null) {
						thoiGianSuDung = Integer.parseInt(resultSet.getString("thoiGianSuDung"));
					}
					Double tongTien = 0.0;

					statementTotalMoney = connection.prepareStatement(
							"SELECT dbo.khachHang.maKH,SUM(donGia * soLuong) AS tongTien FROM dbo.khachHang\r\n"
									+ "JOIN dbo.suDungDichVu ON suDungDichVu.maKH = khachHang.maKH\r\n"
									+ "JOIN dbo.dichVu ON dichVu.maDV = suDungDichVu.maDV\r\n"
									+ "WHERE khachHang.maKH = ?\r\n" + "GROUP BY khachHang.maKH");
					statementTotalMoney.setString(1, maKH);
					resultSetTotalMoney = statementTotalMoney.executeQuery();
					while (resultSetTotalMoney.next()) {
						tongTien = resultSetTotalMoney.getDouble("tongTien");
					}
					 

					customerUsings.add(new CustomerUsing(customer, computer, service, ngaySuDung, gioSuDung, soLuong,
							ngayBatDauSuDung, gioBatDauSuDung, thoiGianSuDung, tongTien));
				}

			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					resultSet.close();
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}
		return customerUsings;
	}
}
