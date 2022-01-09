package exception;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import manager.Main;

public class ValidateData {
	private static Logger logger = Logger.getLogger(ValidateData.class);

    public static final String CUSTOMER_EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*$";
    public static final String CUSTOMER_BIRTHDAY_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$";
    public static boolean validateEmail(String regex) throws EmailException {
        Matcher matcher = Pattern.compile(CUSTOMER_EMAIL_REGEX).matcher(regex);
        if(!matcher.matches()) throw new EmailException("Email này không hợp lệ ");
        return matcher.matches();
    }
    public static boolean validateBirthday(String regex) throws BirthDayException {
        Matcher matcher = Pattern.compile(CUSTOMER_BIRTHDAY_REGEX).matcher(regex);
        if (!matcher.matches()) {
            throw new BirthDayException("Ngày sinh không hợp lệ.");  
        }
        LocalDate birthday = stringBirthdayToLocadateBirthday(regex);
        if(!birthday.isBefore(LocalDate.now().minusYears(18))) throw new BirthDayException("Chưa đủ 18 tuổi");
        return birthday.isBefore(LocalDate.now().minusYears(18));
    }
    public static boolean validateDate(String regex) throws BirthDayException {
        Matcher matcher = Pattern.compile(CUSTOMER_BIRTHDAY_REGEX).matcher(regex);
        if (!matcher.matches()) {
            throw new BirthDayException("Ngày tháng không hợp lệ.");
            
        }
        return true;
    }
    public static LocalDate stringBirthdayToLocadateBirthday(String stringBirthday) {
        String[] arrayBirthday = stringBirthday.split("/");
        int day = Integer.parseInt(arrayBirthday[0]);
        int month = Integer.parseInt(arrayBirthday[1]);
        int year = Integer.parseInt(arrayBirthday[2]);
        return LocalDate.of(year, month, day);

    }
    public static LocalDate stringBirthdayToLocadateBirthday2(String stringBirthday) {
        String[] arrayBirthday = stringBirthday.split("-");
        int day = Integer.parseInt(arrayBirthday[2]);
        int month = Integer.parseInt(arrayBirthday[1]);
        int year = Integer.parseInt(arrayBirthday[0]);
        return LocalDate.of(year, month, day);

    }
}
