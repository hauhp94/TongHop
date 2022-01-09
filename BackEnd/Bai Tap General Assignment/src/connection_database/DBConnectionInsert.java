package connection_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DateTimeException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exception.BirthDayException;
import exception.EmailException;
import exception.ValidateData;
import model.Certificated;
import model.Experience;
import model.Fresher;
import model.Intern;

public class DBConnectionInsert {

	private static Connection connection;

	public static void getConnect() {

		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=CandidateManagement;user=sa;password=12345678";

		try (Connection con = DriverManager.getConnection(connectionUrl);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {

			// Create and execute an SQL statement, retrieving an updateable result set.
			String SQL = "SELECT * FROM Candidate;";
			ResultSet rs = stmt.executeQuery(SQL);
			Scanner scanner = new Scanner(System.in);
			System.out.println("thêm mới ứng viên bằng concur\n 1. Thêm ứng viên experience \n2. Thêm ứng viên Fresher\n 3. Thêm ứng viên Intern");
			String chonString = scanner.nextLine();
			if(chonString.equals("1")) {
				Experience experience =  addExperience();
				 rs.moveToInsertRow();
		            rs.updateString("FullName", experience.getFullName());
		            rs.updateString("BirthDate", experience.getBirthDay());
		            rs.updateString("Phone", experience.getPhone());
		            rs.updateString("Email", experience.getEmail());
		            rs.updateInt("CandidateTypeID", experience.getCandidateType());
		            rs.updateInt("expInYear", experience.getExpInYear());
		            rs.updateString("proSkillString", experience.getProSkillString());
		            rs.insertRow();
		            CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();
		            candidateRepositoryImpl.saveCertificated(experience.getSetCertificateds());
		            System.out.println("Them moi experience bang concur_updatable thanh cong");

			}else if(chonString.equals("2")) {
				Fresher fresher =  addFresher();
				 rs.moveToInsertRow();
		            rs.updateString("FullName", fresher.getFullName());
		            rs.updateString("BirthDate", fresher.getBirthDay());
		            rs.updateString("Phone", fresher.getPhone());
		            rs.updateString("Email", fresher.getEmail());
		            rs.updateInt("CandidateTypeID", fresher.getCandidateType());
		            rs.updateInt("graduationRank", fresher.getGraduationRank());
		            rs.updateString("graduationDate", fresher.getGraduationDate());
		            rs.insertRow();
		            CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();
		            candidateRepositoryImpl.saveCertificated(fresher.getSetCertificateds());
		            System.out.println("Them moi fresher bang concur_updatable thanh cong");
			}else {
				Intern intern =  addIntern();
				 rs.moveToInsertRow();
		            rs.updateString("FullName", intern.getFullName());
		            rs.updateString("BirthDate", intern.getBirthDay());
		            rs.updateString("Phone", intern.getPhone());
		            rs.updateString("Email", intern.getEmail());
		            rs.updateInt("CandidateTypeID", intern.getCandidateType());
		            rs.updateString("majors", intern.getMajors());
		            rs.updateString("semester", intern.getSemester());
		            rs.insertRow();
		            CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();
		            candidateRepositoryImpl.saveCertificated(intern.getSetCertificateds());
		            System.out.println("Them moi intern bang concur_updatable thanh cong");
			}
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
//			System.out.println("Nhập id ứng viên cần sửa thông tin:");
//			int id = Integer.parseInt(scanner.nextLine());
//
//			rs.absolute(id); // đi đến dòng thứ row_id trong ResultSet
//
//			System.out.println("Nhập tên mới: ");
//			String fullNameString = scanner.nextLine();
//			System.out.println("Nhập ngày sinh mới:");
//			String bifthDateString = scanner.nextLine();
//			System.out.println("Nhập số điện thoại mới");
//			String phoneString = scanner.nextLine();

//		            rs.first();
//			rs.updateString("FullName", fullNameString);
//			rs.updateString("birthDate", bifthDateString);
//			rs.updateString("phone", phoneString);
//			rs.updateRow();
//			System.out.println("Cập nhật thông tin ứng viên thành công bàng concur");
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

	private static Fresher addFresher() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm ứng viên Fresher");
		System.out.print("Nhập tên: ");
		String fullName = scanner.nextLine();
		String birthDate = inputBirthday();
		System.out.print("Nhập số điện thoại: ");
		String phone = scanner.nextLine();
		String email = inputEmail();
		System.out.print("Nhập số ngày tốt nghiệp: ");
		String graduationDate = scanner.nextLine();
		System.out.print("Nhập số hạng tốt nghiệp: ");
		int graduationRank = Integer.parseInt(scanner.nextLine());
		System.out.print("Nhập số trình độ học vấn: ");
		String education = scanner.nextLine();
		Set<Certificated> certificateds = addCertificated();
		Fresher fresher = new Fresher(0, fullName, birthDate, phone, email, 1, 0, certificateds, graduationRank,
				graduationDate, education);
		return fresher;
		
	}

	private static Intern addIntern() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm ứng viên Intern");
		System.out.print("Nhập tên: ");
		String fullName = scanner.nextLine();
		String birthDate = inputBirthday();
		System.out.print("Nhập số điện thoại: ");
		String phone = scanner.nextLine();
		String email = inputEmail();
		System.out.print("Nhập chuyên ngành: ");
		String majors = scanner.nextLine();
		System.out.print("Nhập học kỳ: ");
		String semester = scanner.nextLine();
		System.out.print("Nhập tên trường đại học: ");
		String universityName = scanner.nextLine();
		Set<Certificated> certificateds = addCertificated();
		Intern intern = new Intern(0, fullName, birthDate, phone, email, 2, 0, certificateds, majors, semester,
				universityName);
		return intern;
	}

	private static Experience addExperience() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm ứng viên Experience");
		System.out.print("Nhập tên: ");
		String fullName = scanner.nextLine();
		String birthDate = inputBirthday();
		System.out.print("Nhập số điện thoại: ");
		String phone = scanner.nextLine();
		String email = inputEmail();
		System.out.print("Nhập số năm kinh nghiệm: ");
		int ExpInYear = Integer.parseInt(scanner.nextLine());
		System.out.print("Nhập Pro Skill: ");
		String proSkillString = scanner.nextLine();
		Set<Certificated> certificateds = addCertificated();

		Experience experience = new Experience(0, fullName, birthDate, phone, email, 0, 0, certificateds, ExpInYear,
				proSkillString);
		return experience;
		
	}
	
	 private static String inputBirthday() {
	        Scanner scanner = new Scanner(System.in);
	        String birthdayString = "";
	        while (true) {
	            try {
	                System.out.print("Nhập ngày sinh (dd/mm/yyy) : ");
	                birthdayString = scanner.nextLine();
	                if (ValidateData.validateBirthday(birthdayString)) {
	                    break;
	                }
	            } catch (BirthDayException | DateTimeException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        birthdayString = ValidateData.stringBirthdayToLocadateBirthday(birthdayString).toString();
	        return birthdayString;
	    }
	   private static String inputDate() {
	        Scanner scanner = new Scanner(System.in);
	        String birthdayString = "";
	        while (true) {
	            try {
	                System.out.print("Nhập ngày cấp (dd/mm/yyy) : ");
	                birthdayString = scanner.nextLine();
	                if (ValidateData.validateBirthday(birthdayString)) {
	                    break;
	                }
	            } catch (BirthDayException | DateTimeException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        return birthdayString;
	    }
	   private static String inputEmail() {
	        String email = "";
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            try {
	                System.out.print("Nhập email : ");
	                email = scanner.nextLine();
	                if (ValidateData.validateEmail(email)) {
	                    break;
	                }
	            } catch (EmailException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        return email;
	    }
		public static Set<Certificated> addCertificated() {
			Set<Certificated> certificateds = new HashSet<Certificated>();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhập số lượng bằng cấp");
			int soBangCap = Integer.parseInt(scanner.nextLine());
			for (int i = 1; i <= soBangCap; i++) {
				System.out.print("Nhập tên bằng cấp thứ "+ i + ": ");
				String certificateName = scanner.nextLine();
				System.out.print("Nhập thứ hạng bằng cấp: ");
				int certificateRank = Integer.parseInt(scanner.nextLine());
				System.out.print("Nhập ngày cấp: ");
				String certificateDate = scanner.nextLine();
				certificateds.add(new Certificated(0, certificateName, certificateRank, certificateDate));
			}
			return certificateds;
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
