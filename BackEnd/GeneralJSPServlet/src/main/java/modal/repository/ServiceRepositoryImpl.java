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

import modal.bean.Service;
import modal.service.DBConnection;

public class ServiceRepositoryImpl implements ServiceRepository {

	@Override
	public Service getServiceByCode(String maDV) {
		Service service = new Service();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM dichVu where maDV = ?");
				statement.setString(1, maDV);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String tenDV = resultSet.getString("tenDV");
					String donViTinh = resultSet.getString("donViTinh");
					Double donGia = Double.parseDouble(resultSet.getString("donGia"));
					service = new Service(maDV, tenDV, donViTinh, donGia);
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
		return service;
	}

	@Override
	public void save(Service service) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection
						.prepareStatement("INSERT INTO dichVu(maDV,tenDV,donViTinh,donGia)VALUES(?,?,?,?)");
				statement.setString(1, service.getMaDV());
				statement.setString(2, service.getTenDV());
				statement.setString(3, service.getDonViTinh());
				statement.setDouble(4, service.getDonGia());
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
	public void update(Service service) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection
						.prepareStatement("update dichVu set tenDV = ?, donViTinh = ?,donGia=? where maDV=?");
				statement.setString(1, service.getTenDV());
				statement.setString(2, service.getDonViTinh());
				statement.setDouble(3, service.getDonGia());
				statement.setString(4, service.getMaDV());
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
	public List<Service> getList() {
		List<Service> services = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM dichVu");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maDV = resultSet.getString("maDV");
					String tenDV = resultSet.getString("tenDV");
					String donViTinh = resultSet.getString("donViTinh");
					double donGia = Double.parseDouble(resultSet.getString("donGia"));
					services.add(new Service(maDV, tenDV, donViTinh, donGia));
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
		return services;
	}

	@Override
	public void delete(String maDV) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("DELETE FROM dichVu WHERE maDV = ?");
				statement.setString(1, maDV);
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
