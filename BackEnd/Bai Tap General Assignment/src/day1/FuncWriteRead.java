package day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FuncWriteRead {
	public static ArrayList<SinhVien> docDanhSachSinhVien() {
		ArrayList<SinhVien> sinhViens = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/day1/STD.csv"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				if (temp.length == 5) {
					sinhViens.add(new SinhVien(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4])));
				} else {
					System.out.println("co loi xay ra");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sinhViens;
	}
	
	public static ArrayList<String> docFileErr() {
		ArrayList<String> errArrayList = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/day1/err.txt"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				errArrayList.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return errArrayList;
	}

	public static void ghiVaoFile(String loi) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("src/day1/err.txt", false));
			bufferedWriter.write(loi);
			bufferedWriter.newLine();
			bufferedWriter.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
