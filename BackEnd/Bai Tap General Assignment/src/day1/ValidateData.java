package day1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    public static final String SO_DIEN_THOAI_REGEX = "^\\d{9}$";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";


	public static boolean validateSoDienThoai(String regex) {
        Matcher matcher = Pattern.compile(SO_DIEN_THOAI_REGEX).matcher(regex);
        return matcher.matches();
    }
	public static boolean validateEmail(String regex) {
        Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        return matcher.matches();
    }
}
