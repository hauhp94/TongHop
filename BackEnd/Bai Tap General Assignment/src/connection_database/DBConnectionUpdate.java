package connection_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import manager.CandidateManager;
import model.Candidate;

public class DBConnectionUpdate {

	private static Connection connection;

	public static void getConnect() {

		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=CandidateManagement;user=sa;password=12345678";

		try (Connection con = DriverManager.getConnection(connectionUrl);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {

			// Create and execute an SQL statement, retrieving an updateable result set.
			String SQL = "SELECT * FROM Candidate;";
			ResultSet rs = stmt.executeQuery(SQL);

			// Insert a row of data.
//		            rs.moveToInsertRow();
//		            rs.updateString("FullName", "Huynh Van Noi");
//		            rs.updateString("BirthDate", "2000-12-12");
//		            rs.updateString("Phone", "0909123321");
//		            rs.insertRow();
//		            System.out.println("Them moi nhan vien bang concur_updatable thanh cong");

//		            // Retrieve the inserted row of data and display it.
//		            SQL = "SELECT * FROM HumanResources.Department WHERE Name = 'Accounting';";
//		            rs = stmt.executeQuery(SQL);
//		            displayRow("ADDED ROW", rs);
//
			// Update the row of data.
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhập id ứng viên cần sửa thông tin:");
			int id = Integer.parseInt(scanner.nextLine());
			CandidateManager candidateManager = new CandidateManager();
			List<Candidate> candidates = candidateManager.getCandidates();
			boolean check = false;
			for (Candidate candidate : candidates) {
				if(candidate.getCandidateID()==id) {
					check = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("id khong ton tai");
				return;
			}

			rs.absolute(id); // đi đến dòng thứ row_id trong ResultSet

			System.out.println("Nhập tên mới: ");
			String fullNameString = scanner.nextLine();
			System.out.println("Nhập ngày sinh mới:");
			String bifthDateString = scanner.nextLine();
			System.out.println("Nhập số điện thoại mới");
			String phoneString = scanner.nextLine();

//		            rs.first();
			rs.updateString("FullName", fullNameString);
			rs.updateString("birthDate", bifthDateString);
			rs.updateString("phone", phoneString);
			rs.updateRow();
			System.out.println("Cập nhật thông tin ứng viên thành công bàng concur");
//
//		            // Retrieve the updated row of data and display it.
//		            rs = stmt.executeQuery(SQL);
//		            displayRow("UPDATED ROW", rs);
//
//		            // Delete the row of data.
//		            rs.first();
//		            rs.deleteRow();
//		            System.out.println("ROW DELETED");
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
