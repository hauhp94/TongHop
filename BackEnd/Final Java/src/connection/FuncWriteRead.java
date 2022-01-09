package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout.Group;

import entity.Company;
import entity.ForeignPhone;
import entity.HomePhone;
import entity.OldPhone;
import entity.Personal;
import entity.Phone;
import entity.Sponsor;
import exception.PhoneException;
import validate.ValidateData;

/**
 * class chuc nang doc ghi file
 *
 */
public class FuncWriteRead {
	public static ArrayList<Phone> readPhone() {
		ArrayList<Phone> phones = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/data/Data.txt"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");

				if (ValidateData.validateHomePhoneId(temp[0])) {
					phones.add(new HomePhone(temp[0], temp[1], Double.parseDouble(temp[2]), temp[3],
							Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), temp[7],
							Integer.parseInt(temp[8]), Integer.parseInt(temp[9])));
				} else if (ValidateData.validateForeignPhoneId(temp[0])) {
					phones.add(new ForeignPhone(temp[0], temp[1], Double.parseDouble(temp[2]), temp[3],
							Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), temp[7],
							temp[8], Double.parseDouble(temp[9])));
				} else if (ValidateData.validateOldPhoneId(temp[0])) {
					phones.add(new OldPhone(temp[0], temp[1], Double.parseDouble(temp[2]), temp[3],
							Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Double.parseDouble(temp[6]), temp[7],
							Integer.parseInt(temp[8]), Integer.parseInt(temp[9]), Double.parseDouble(temp[10])));
				} else {
					System.out.println("ID "+ temp[0]+" khong chinh xac");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phones;
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
