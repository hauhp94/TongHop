/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.bean.RegisterService;
import modal.service.DBConnection;

public class RegisterServiceRepositoryImpl implements RegisterServiceRepository {

	@Override
	public void save(RegisterService registerService) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO suDungDichVu(maKH,maDV,ngaySuDung,gioSuDung,soLuong)VALUES(?,?,?,?,?)");
				statement.setString(1, registerService.getMaKH());
				statement.setString(2, registerService.getMaDV());
				statement.setString(3, registerService.getNgaySuDung());
				statement.setString(4, registerService.getGioSuDung());
				statement.setInt(5, registerService.getSoLuong());
				statement.executeUpdate();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}

	}

	@Override
	public List<RegisterService> getList() {
		List<RegisterService> registerServices = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM suDungDichVu");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maKH = resultSet.getString("maKH");
					String maDV = resultSet.getString("maDV");
					String ngaySuDung = resultSet.getString("ngaySuDung");
					String gioSuDung = resultSet.getString("gioSuDung");
					int soLuong = Integer.parseInt(resultSet.getString("soLuong"));
					registerServices.add(new RegisterService(maKH, maDV, ngaySuDung, gioSuDung, soLuong));
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
		return registerServices;
	}

}
