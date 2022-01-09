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

import modal.bean.RegisterComputer;
import modal.service.DBConnection;

public class RegisterComputerRepositoryImpl implements RegisterComputerRepository {

	@Override
	public void save(RegisterComputer registerComputer) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO suDungMay(maKH,maMay,ngayBatDauSuDung,gioBatDauSuDung,thoiGianSuDung)VALUES(?,?,?,?,?)");
				statement.setString(1, registerComputer.getMaKH());
				statement.setString(2, registerComputer.getMaMay());
				statement.setString(3, registerComputer.getNgayBatDauSuDung());
				statement.setString(4, registerComputer.getGioBatDauSuDung());
				statement.setInt(5, registerComputer.getThoiGianSuDung());
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
	public List<RegisterComputer> getList() {
		List<RegisterComputer> registerComputers = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM suDungMay");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maKH = resultSet.getString("maKH");
					String maMay = resultSet.getString("maMay");
					String ngayBatDauSuDung = resultSet.getString("ngayBatDauSuDung");
					String gioBatDauSuDung = resultSet.getString("gioBatDauSuDung");
					int thoiGianSuDung = Integer.parseInt(resultSet.getString("thoiGianSuDung"));
					registerComputers
							.add(new RegisterComputer(maKH, maMay, ngayBatDauSuDung, gioBatDauSuDung, thoiGianSuDung));
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
		return registerComputers;
	}

}
