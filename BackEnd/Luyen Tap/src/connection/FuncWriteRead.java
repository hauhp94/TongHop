package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entity.Company;
import entity.Group;
import entity.Personal;
import entity.Sponsor;

public class FuncWriteRead {
	public static ArrayList<Sponsor> readSponsor() {
		ArrayList<Sponsor> sponsors = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/data/sponsor.txt"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				if (temp.length == 12) {
					if (temp[0].equals("1")) {
						sponsors.add(new Personal(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4],
								temp[5], temp[6], temp[7], temp[8], temp[9], Double.parseDouble(temp[10]), temp[11]));
					} else if (temp[0].equals("2")) {
						sponsors.add(new Group(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5],
								temp[6], temp[7], Integer.parseInt(temp[8]), temp[9], Double.parseDouble(temp[10]),
								temp[11]));
					} else if (temp[0].equals("3")) {
						sponsors.add(new Company(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5],
								temp[6], temp[7], temp[8], temp[9], Double.parseDouble(temp[10]), temp[11]));
					} else {
						System.out.println("loi type");
					}
				} else {
					System.out.println("co loi xay ra");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sponsors;
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
