package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ForeignPhone;
import entity.HomePhone;
import entity.OldPhone;
import entity.Phone;
import validate.ValidateData;

public class PhoneRepositoryImpl implements PhoneRepository {

	@Override
	public List<Phone> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *phuong thuc luu dien thoai vao database
	 */
	@Override
	public void savePhone(Phone phone) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement("INSERT INTO dbo.Phone\r\n"
						+ "(Id,Name,ScreenSize,Chipset,Ram,Storage,Price,Manufacturer,Warranty,Range,Country,PriceWarranty,Status,BodyStatus)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				statement.setString(1, phone.getId());
				statement.setString(2, phone.getName());
				statement.setDouble(3, phone.getScreenSize());
				statement.setString(4, phone.getChipset());
				statement.setInt(5, phone.getRam());
				statement.setInt(6, phone.getStorage());
				statement.setDouble(7, phone.getPrice());
				statement.setString(8, phone.getManufacturer());

				if (phone instanceof HomePhone) {
					HomePhone homePhone = (HomePhone) phone;
					statement.setInt(9, homePhone.getWarranty());
					statement.setInt(10, homePhone.getRange());
					statement.setString(11, null);
					statement.setDouble(12, 0);
					statement.setInt(13, 0);
					statement.setInt(14, 0);

				} else if (phone instanceof ForeignPhone) {
					ForeignPhone foreignPhone = (ForeignPhone) phone;
					foreignPhone.setPriceWarranty(foreignPhone.getPrice() * 0.06);
					statement.setInt(9, 0);
					statement.setInt(10, 0);

					statement.setString(11, foreignPhone.getCountry());
					statement.setDouble(12, foreignPhone.getPriceWarranty());

					statement.setInt(13, 0);
					statement.setInt(14, 0);

				} else if (phone instanceof OldPhone) {
					OldPhone oldPhone = (OldPhone) phone;
					oldPhone.setPriceWarranty(oldPhone.getPrice() * 0.07);
					statement.setInt(9, 0);
					statement.setInt(10, 0);

					statement.setString(11, null);
					statement.setDouble(12, oldPhone.getPriceWarranty());

					statement.setInt(13, oldPhone.getStatus());
					statement.setInt(14, oldPhone.getBodyStatus());

				}
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
	public void updatePhone(Phone phone) {
		// TODO Auto-generated method stub

	}

	/**
	 *phuong thuc tim kiem va mua dien thoai
	 */
	@Override
	public List<Phone> searchByPrice(double minPrice, double maxPrice) {
		List<Phone> phones = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM dbo.Phone WHERE Price >= ? AND Price <= ?");
				statement.setDouble(1, minPrice);
				statement.setDouble(2, maxPrice);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String id = resultSet.getString("Id");
					String name = resultSet.getString("Name");
					double screenSize = resultSet.getDouble("ScreenSize");
					String chipset = resultSet.getString("Chipset");
					int ram = resultSet.getInt("Ram");
					int storage = resultSet.getInt("Storage");
					double price = resultSet.getDouble("Price");
					String manufacturer = resultSet.getString("Manufacturer");
					int warranty = resultSet.getInt("Warranty");
					int range = resultSet.getInt("Range");
					String country = resultSet.getString("Country");
					double PriceWarranty = resultSet.getDouble("PriceWarranty");
					int status = resultSet.getInt("Status");
					int bodyStatus = resultSet.getInt("BodyStatus");

					if (ValidateData.validateHomePhoneId(id)) {
						phones.add(new HomePhone(id, name, screenSize, chipset, ram, storage, PriceWarranty,
								manufacturer, warranty, range));
					} else if (ValidateData.validateForeignPhoneId(id)) {
						phones.add(new ForeignPhone(id, name, screenSize, chipset, ram, storage, price, manufacturer,
								country, PriceWarranty));
					} else if (ValidateData.validateOldPhoneId(id)) {
						phones.add(new OldPhone(id, name, screenSize, chipset, ram, storage, price, manufacturer,
								status, bodyStatus, PriceWarranty));
					} else {
						System.out.println("id co loi");

					}

				}
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
		return phones;
	}

	/**
	 *phuong thuc xoa phone trong database
	 */
	@Override
	public void deletePhone(String id) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("DELETE FROM dbo.Phone WHERE Id = ?");
				statement.setString(1, id);
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
