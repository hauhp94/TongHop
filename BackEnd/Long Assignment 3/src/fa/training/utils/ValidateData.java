package fa.training.utils;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import manager.Main;

public class ValidateData {

    public static final String PHONE_REGEX = "^\\d{7,}$";
    public static final String BIRTHDAY_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*$";
    public static boolean validateEmail(String regex) {
        Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateBirthday(String regex)  {
        Matcher matcher = Pattern.compile(BIRTHDAY_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static boolean validatePhone(String regex)  {
        Matcher matcher = Pattern.compile(PHONE_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static LocalDate stringToLocadate(String stringBirthday) {
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
