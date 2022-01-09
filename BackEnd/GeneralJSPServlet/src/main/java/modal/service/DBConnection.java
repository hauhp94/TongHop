package modal.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;

	public static Connection getConnect() {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=InternetStore;user=sa;password=12345678";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionUrl);
			System.out.println("Ket noi thanh cong");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
