/**
 * @author HauHP
 * @date 31 thg 12, 2021
 * @version 1.0
 */
package manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("123");
		
		String abcString= LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println(abcString);
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		LocalDate localDate = LocalDate.parse("22/12/2020",formatter);
		System.out.println(localDate);

	}

}
