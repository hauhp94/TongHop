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

import modal.bean.Computer;
import modal.service.DBConnection;

public class ComputerReposirotyImpl implements ComputerRepository {

	@Override
	public Computer getComputerByCode(String maMay) {
		Computer computer = new Computer();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM may where maMay = ?");
				statement.setString(1, maMay);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String viTri = resultSet.getString("viTri");
					String trangThai = resultSet.getString("trangThai");
					computer = new Computer(maMay, viTri, trangThai);
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
		return computer;
	}

	@Override
	public void save(Computer computer) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement("INSERT INTO may(maMay,viTri,trangThai)VALUES(?,?,?)");
				statement.setString(1, computer.getMaMay());
				statement.setString(2, computer.getViTri());
				statement.setString(3, computer.getTrangThai());
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
	public void update(Computer computer) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("update may set viTri = ?, trangThai = ? where maMay=?;");
				statement.setString(1, computer.getViTri());
				statement.setString(2, computer.getTrangThai());
				statement.setString(3, computer.getMaMay());
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
	public List<Computer> getList() {
		List<Computer> computers = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM may");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maMay = resultSet.getString("maMay");
					String viTri = resultSet.getString("viTri");
					String trangThai = resultSet.getString("trangThai");
					computers.add(new Computer(maMay, viTri, trangThai));
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
		return computers;
	}

	@Override
	public void delete(String maMay) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("DELETE FROM may WHERE maMay = ?");
				statement.setString(1, maMay);
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

}
