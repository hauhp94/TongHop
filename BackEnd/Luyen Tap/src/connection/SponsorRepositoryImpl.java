package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Company;
import entity.Group;
import entity.Personal;
import entity.Sponsor;

public class SponsorRepositoryImpl implements SponsorRepository {

	@Override
	public void saveSponsor(Sponsor sponsor) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement("INSERT INTO dbo.sponsor\r\n"
						+ "(Type,SponsorId,Name,Address,Phone,Email,BankingAccount,BankName,Job,Company,GroupSize,Domain,TaxCode,SponsorMoney,SponsorDate)\r\n"
						+ "VALUES\r\n" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )");
				statement.setInt(1, sponsor.getType());
				statement.setString(2, sponsor.getSponsorId());
				statement.setString(3, sponsor.getName());
				statement.setString(4, sponsor.getAddress());
				statement.setString(5, sponsor.getPhone());
				statement.setString(6, sponsor.getEmail());
				statement.setString(7, sponsor.getBankingAccount());
				statement.setString(8, sponsor.getBankName());
				if (sponsor instanceof Personal) {
					Personal personal = (Personal) sponsor;
					statement.setString(9, personal.getJob());
					statement.setString(10, personal.getCompany());
					statement.setString(11, null);
					statement.setString(12, null);
					statement.setString(13, null);

				} else if (sponsor instanceof Group) {
					Group group = (Group) sponsor;
					statement.setInt(11, group.getGroupeSize());
					statement.setString(12, group.getDomain());

					statement.setString(9, null);
					statement.setString(10, null);
					statement.setString(13, null);

				} else if (sponsor instanceof Company) {
					Company company = (Company) sponsor;
					statement.setString(10, company.getCompany());
					statement.setString(13, company.getTaxCode());

					statement.setString(9, null);
					statement.setString(11, null);
					statement.setString(12, null);
				}
				statement.setString(14, null);
				statement.setString(15, null);

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
	public List<Sponsor> findAll() {
		List<Sponsor> sponsors = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT * FROM dbo.sponsor");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int type = resultSet.getInt(1);
					String sponsorId = resultSet.getString("sponsorId");
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					String email = resultSet.getString("email");
					String bankingAccount = resultSet.getString("bankingAccount");
					String bankName = resultSet.getString("bankName");
					String job = resultSet.getString("job");
					String company = resultSet.getString("company");
					String groupSize = resultSet.getString("groupSize");
					String domain = resultSet.getString("domain");
					String taxCode = resultSet.getString("taxCode");
					double SponsorMoney = resultSet.getDouble("SponsorMoney");
					String sponsorDate = resultSet.getString("sponsorDate");

					if (type == 1) {
						sponsors.add(new Personal(type, sponsorId, name, address, phone, email, bankingAccount,
								bankName, job, company, SponsorMoney, sponsorDate));
					} else if (type == 2) {
						sponsors.add(new Group(type, sponsorId, name, address, phone, email, bankingAccount, bankName,
								type, domain, SponsorMoney, sponsorDate));
					} else {
						sponsors.add(new Company(type, sponsorId, name, address, phone, email, bankingAccount, bankName,
								company, taxCode, SponsorMoney, sponsorDate));
					}
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
		return sponsors;
	}

	@Override
	public void updateSponsor(String sponsorId, double sponsorMoney, String sponsorDate) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(
						"UPDATE dbo.sponsor SET SponsorMoney = ?, SponsorDate = ? WHERE SponsorId = ?");
				statement.setDouble(1, sponsorMoney);
				statement.setString(2, sponsorDate);
				statement.setString(3, sponsorId);
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
	public void deleteSponsor(Sponsor sponsor) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(
						"DELETE dbo.sponsor WHERE SponsorId = ?");
				statement.setString(1, sponsor.getSponsorId());
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
