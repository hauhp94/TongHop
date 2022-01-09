package manager;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import comparator.ComparatorByCandidateType;
import connection_database.CandidateRepositoryImpl;
import connection_database.DBConnectionInsert;
import connection_database.DBConnectionUpdate;
import exception.BirthDayException;
import exception.EmailException;
import exception.ValidateData;
import model.Candidate;
import model.Certificated;
import model.Experience;
import model.Fresher;
import model.Intern;

public class CandidateManager {
	private static Logger logger = Logger.getLogger(CandidateManager.class);

	public static CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();

	public static int getCadidateCount() {
		return CandidateRepositoryImpl.getCadidateCount();
	}

	public static Set<Certificated> addCertificated() {
		Set<Certificated> certificateds = new HashSet<Certificated>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số lượng bằng cấp");
		int soBangCap = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= soBangCap; i++) {
			System.out.print("Nhập tên bằng cấp thứ " + i + ": ");
			String certificateName = scanner.nextLine();
			System.out.print("Nhập thứ hạng bằng cấp: ");
			int certificateRank = Integer.parseInt(scanner.nextLine());
			System.out.print("Nhập ngày cấp: ");
			String certificateDate = scanner.nextLine();
			certificateds.add(new Certificated(0, certificateName, certificateRank, certificateDate));
		}
		return certificateds;
	}

	public static ArrayList<Candidate> getCandidates() {

		ArrayList<Candidate> candidates = (ArrayList<Candidate>) candidateRepositoryImpl.findAll();
		Collections.sort(candidates, new ComparatorByCandidateType());

		for (Candidate candidate : candidates) {
			candidate.showMe();
		}
		return candidates;
	}

	public static void addCandidate() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Thêm ứng viên:\n1.Experience\n2.Fresher\n3.Intern");
			String chon = scanner.nextLine();
			if (chon.equals("1")) {
				addExperience();
			} else if (chon.equals("2")) {
				addFresher();
			} else {
				addIntern();
			}
			System.out.println("Đã thêm " + getCadidateCount() + "ứng viên");
		} catch (Exception e) {
			logger.error(e.getMessage());
			System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
		}

	}

	private static void addIntern() {
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
		candidateRepositoryImpl.saveIntern(intern);
		System.out.println("Thêm mới intern thành công");
		logger.info("Thêm mới intern thành công");

	}

	private static void addFresher() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm ứng viên Fresher");
		System.out.print("Nhập tên: ");
		String fullName = scanner.nextLine();
		String birthDate = inputBirthday();
		System.out.print("Nhập số điện thoại: ");
		String phone = scanner.nextLine();
		String email = inputEmail();
		System.out.print("Nhập ngày tốt nghiệp: ");
		String graduationDate = inputDate();
		System.out.print("Nhập số hạng tốt nghiệp: ");
		int graduationRank = Integer.parseInt(scanner.nextLine());
		System.out.print("Nhập số trình độ học vấn: ");
		String education = scanner.nextLine();
		Set<Certificated> certificateds = addCertificated();
		Fresher fresher = new Fresher(0, fullName, birthDate, phone, email, 1, 0, certificateds, graduationRank,
				graduationDate, education);
		candidateRepositoryImpl.saveFresher(fresher);
		System.out.println("Thêm mới fresher thành công");
		logger.info("Thêm mới fresher thành công");

	}

	private static void addExperience() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm ứng viên Fresher");
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
		candidateRepositoryImpl.saveExperience(experience);
		System.out.println("Thêm mới Experience thành công");
		logger.info("Thêm mới Experience thành công");

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
				logger.error(e.getMessage());
				System.out.println("Da xay ra ngoai le, nhap lai ngay sinh");
				System.err.println(e.getMessage());
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
				System.out.print("Nhập ngày tháng (dd/mm/yyy) : ");
				birthdayString = scanner.nextLine();
				if (ValidateData.validateDate(birthdayString)) {
					break;
				}
			} catch (BirthDayException | DateTimeException e) {
				logger.error(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
		birthdayString = ValidateData.stringBirthdayToLocadateBirthday(birthdayString).toString();
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
				logger.error(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
		return email;
	}

	public static void displayName() {
		ArrayList<Candidate> candidates = (ArrayList<Candidate>) candidateRepositoryImpl.findAll();
		StringBuffer nameBuffer = new StringBuffer();
		for (Candidate candidate : candidates) {
			nameBuffer.append(candidate.getFullName() + ",");
		}
		System.out.println(nameBuffer);

	}

	public static void getMapCandidates() {
		Map<Integer, Candidate> map = new HashMap<Integer, Candidate>();
		ArrayList<Candidate> candidates = getCandidates();
		for (Candidate candidate : candidates) {
			if (!map.containsKey(candidate.getCandidateID())) {
				map.put(candidate.getCandidateID(), candidate);
			}
		}
		System.out.println("Danh sách ứng viên không trùng id:");
		for (Integer candidate2 : map.keySet()) {
			map.get(candidate2).showMe();
		}
	}

	public static void updateCandidate(int id) {

	}

	public static void updateCandidateByConcur() {
		DBConnectionUpdate.getConnect();

	}

	public static void insertCandidateByConcur() {
		DBConnectionInsert.getConnect();
	}
}
