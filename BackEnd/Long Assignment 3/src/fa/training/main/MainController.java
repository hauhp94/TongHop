package fa.training.main;

import java.util.Scanner;

import fa.training.entities.Employee;
import fa.training.services.EmployeeService;
import manager.CandidateManager;

public class MainController {
	public static void displayMainMenu() {
		String chon = "";
		while (true) {
			System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======\r\n" + "1.	Add an employee\r\n"
					+ "2.	Display employees\r\n" + "3.	Classify employees \r\n"
					+ "4.	Search book by (department, emp’s name)\r\n"
					+ "5.	Exit\r\n" + "\r\n"
					+ "Please choose function you'd like to do:\r\n" + "");
			Scanner scanner = new Scanner(System.in);
			chon = scanner.nextLine();
			switch (chon) {
			case "1":
				EmployeeService.addEmployee();
				break;
			case "2":
				EmployeeService.displayEmployee();
				break;
			case "3":
				EmployeeService.classifyEmployee();
				break;
			case "4":
				EmployeeService.searchEmployee();
				break;
			case "5":
				System.out.println("Thoát");
				System.exit(0);
			default:
				System.out.println("input 1-5");
			}
		}
	}
}
