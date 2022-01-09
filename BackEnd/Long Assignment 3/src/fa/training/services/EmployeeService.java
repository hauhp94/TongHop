package fa.training.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.entities.HourtyEmployee;
import fa.training.entities.SalariedEmployee;
import fa.training.utils.FuncWriteRead;
import fa.training.utils.ValidateData;

public class EmployeeService {
	public static void addEmployee() {
		System.out.println("Add employee\n 1. Salaried Employee \n2. Hourty Employee");
		Scanner scanner = new Scanner(System.in);
		String chonString = scanner.nextLine();
		if (chonString.equals("1")) {
			addSalariedEmployee();
		} else {
			addHourtyEmployee();
		}
	}

	private static void addHourtyEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input ssn");
		String ssn = scanner.nextLine();
		System.out.println("input firstName");
		String firstNameString = scanner.nextLine();
		System.out.println("input lastName");
		String lastNameString = scanner.nextLine();
		System.out.println("input birth date");
		String birthDateString = scanner.nextLine();
		System.out.println("input phone");
		String phoneString = scanner.nextLine();
		System.out.println("input email");
		String emailString = scanner.nextLine();
		System.out.println("input department name");
		String departmentName = scanner.nextLine();

		System.out.println("input wage");
		double wage = Double.parseDouble(scanner.nextLine());
		System.out.println("input working hours");
		double workingHours = Double.parseDouble(scanner.nextLine());
		HourtyEmployee hourtyEmployee = new HourtyEmployee(ssn, firstNameString, lastNameString, birthDateString,
				phoneString, emailString, new Department(departmentName, null), wage, workingHours);
		FuncWriteRead.WriteToFile(hourtyEmployee.getStringToWrite(), "src/data/employee.txt");
		System.out.println("add new hourty employee ok");

	}

	private static void addSalariedEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input ssn");
		String ssn = scanner.nextLine();
		System.out.println("input firstName");
		String firstNameString = scanner.nextLine();
		System.out.println("input lastName");
		String lastNameString = scanner.nextLine();
		String birthDateString = "";
		while (true) {
			System.out.println("input birth date dd/mm/yyyy");
			birthDateString = scanner.nextLine();
			if (ValidateData.validateBirthday(birthDateString)) {
				break;
			}
		}
		
		
		String phoneString = "";
		while (true) {
			System.out.println("input phone >7 number");
			phoneString = scanner.nextLine();
			if (ValidateData.validatePhone(phoneString)) {
				break;
			}
		}

		String emailString = "";

		while (true) {
			System.out.println("input email valid ex: abc@gmail.com");
			emailString = scanner.nextLine();
			if (ValidateData.validateEmail(emailString)) {
				break;
			}
		}
		System.out.println("input department name");
		String departmentName = scanner.nextLine();

		System.out.println("input commission rate");
		double commissionRate = Double.parseDouble(scanner.nextLine());
		System.out.println("input grossSales");
		double grossSales = Double.parseDouble(scanner.nextLine());
		System.out.println("input basicSalary");
		double basicSalary = Double.parseDouble(scanner.nextLine());
		SalariedEmployee salariedEmployee = new SalariedEmployee(ssn, firstNameString, lastNameString, birthDateString,
				phoneString, emailString, new Department(departmentName, null), commissionRate, grossSales,
				basicSalary);
		FuncWriteRead.WriteToFile(salariedEmployee.getStringToWrite(), "src/data/employee.txt");
		System.out.println("add new salaried employee ok");

	}

	public static void displayEmployee() {
		List<Employee> employees = FuncWriteRead.readEmployee();
		for (Employee employee : employees) {
			employee.display();
		}
	}

	public static void searchEmployee() {
		System.out.println("1. search by department\n2. search by name");
		Scanner scanner = new Scanner(System.in);
		String chonString = scanner.nextLine();
		if (chonString.equals("1")) {
			System.out.println("input name department");
			String departementNameString = scanner.nextLine();
			List<Employee> employees = FuncWriteRead.readEmployee();
			for (Employee employee : employees) {
				if (employee.getDepartment().getDepartmentName().equals(departementNameString)) {
					employee.display();
				}
			}

		}else {
			System.out.println("input first name");
			String firstNameString = scanner.nextLine();
			List<Employee> employees = FuncWriteRead.readEmployee();
			for (Employee employee : employees) {
				if (employee.getFirstName().equals(firstNameString)) {
					employee.display();
				}
			}
		}
	}
	public static void classifyEmployee() {
		List<Employee> employees = FuncWriteRead.readEmployee();
		List<Employee> hourtyEmployees = new ArrayList<Employee>();
		List<Employee> salariedEmployees = new ArrayList<Employee>();

		for (Employee employee : employees) {
			if (employee instanceof HourtyEmployee) {
				hourtyEmployees.add(employee);
			}else {
				salariedEmployees.add(employee);
			}
		}
		System.out.println("Hourty employee list:");
		for (Employee employee : hourtyEmployees) {
			employee.display();
		}
		System.out.println("salaried employee list:");
		for (Employee employee : salariedEmployees) {
			employee.display();
		}
	}
}
