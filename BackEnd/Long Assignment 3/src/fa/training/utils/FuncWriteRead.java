package fa.training.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout.Group;

import entity.Company;
import entity.Personal;
import entity.Sponsor;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.entities.HourtyEmployee;
import fa.training.entities.SalariedEmployee;

public class FuncWriteRead {
	public static ArrayList<Employee> readEmployee() {
		ArrayList<Employee> employees = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/data/employee.txt"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				if (temp.length == 9) {
					employees.add(new HourtyEmployee(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],
							new Department(temp[6], null), Double.parseDouble(temp[7]), Double.parseDouble(temp[8])));
				} else if (temp.length == 10) {
					employees.add(new SalariedEmployee(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],
							new Department(temp[6], null), Double.parseDouble(temp[7]), Double.parseDouble(temp[8]),
							Double.parseDouble(temp[9])));
				} else {
					System.out.println("co loi xay ra");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static void WriteToFile(String string, String url) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(url, true));
			bufferedWriter.write(string);
			bufferedWriter.newLine();
			bufferedWriter.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
