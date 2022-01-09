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

import modal.bean.Customer;
import modal.service.DBConnection;

public class CustomerRepositoryImpl implements CustomerRepository {

	@Override
	public Customer getCustomerByCode(String maKH) {
		Customer customer = new Customer();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM khachHang where maKH = ?");
				statement.setString(1, maKH);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String tenKH = resultSet.getString("tenKH");
					String diaChi = resultSet.getString("diaChi");
					String soDienThoai = resultSet.getString("soDienThoai");
					String email = resultSet.getString("diaChiEmail");
					customer = new Customer(maKH, tenKH, diaChi, soDienThoai, email);
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
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO khachHang(maKH,tenKH,diaChi,soDienThoai,diaChiEmail)VALUES(?,?,?,?,?)");
				statement.setString(1, customer.getMaKH());
				statement.setString(2, customer.getTenKH());
				statement.setString(3, customer.getDiaChi());
				statement.setString(4, customer.getSoDienThoai());
				statement.setString(5, customer.getEmail());
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
	public void update(Customer customer) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(
						"update khachHang set tenKH = ?, diaChi = ?,soDienThoai=?,diaChiEmail=? where maKH=?;");
				statement.setString(1, customer.getTenKH());
				statement.setString(2, customer.getDiaChi());
				statement.setString(3, customer.getSoDienThoai());
				statement.setString(4, customer.getEmail());
				statement.setString(5, customer.getMaKH());
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
	public List<Customer> getList() {
		List<Customer> customers = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM khachHang");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maKH = resultSet.getString("maKH");
					String tenKH = resultSet.getString("tenKH");
					String diaChi = resultSet.getString("diaChi");
					String soDienThoai = resultSet.getString("soDienThoai");
					String email = resultSet.getString("diaChiEmail");
					customers.add(new Customer(maKH, tenKH, diaChi, soDienThoai, email));
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
		return customers;
	}

	@Override
	public void delete(String maKH) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("DELETE FROM khachHang WHERE maKH = ?");
				statement.setString(1, maKH);
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
	public List<Customer> findByName(String name) {
		List<Customer> customerList = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection
						.prepareStatement(" SELECT * FROM dbo.khachHang\r\n" + " WHERE tenKH LIKE CONCAT('%',?,'%')");
				statement.setString(1, name);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String maKH = resultSet.getString("maKH");
					String tenKH = resultSet.getString("tenKH");
					String diaChi = resultSet.getString("diaChi");
					String soDienThoai = resultSet.getString("soDienThoai");
					String email = resultSet.getString("diaChiEmail");
					customerList.add(new Customer(maKH, tenKH, diaChi, soDienThoai, email));
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
		return customerList;
	}

	@Override
	public boolean isCustomerCodeExist(String maKH) {
		int count = 0;
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection
						.prepareStatement(" SELECT count(*) AS dem from khachHang where maKH = ? ");
				statement.setString(1, maKH);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					count = Integer.parseInt(resultSet.getString(1));
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
		if (count == 0) {
			return false;
		}else {
			return true;
		}
	}

}
