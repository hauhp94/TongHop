package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.BankNameException;
import exception.EmailException;
import exception.PhoneException;

public class ValidateData {
    public static final String DATE_REGEX = "^(19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+@gmail.com$";
    public static final String BANKNAME_REGEX = "^(VCB)|(AGB)|(MB)|(ACB)|(TPB)|(BIDV)$";
    public static final String HOME_PHONE = "^CH\\d{4}$";
    public static final String FOREIGN_PHONE = "^XT\\d{4}$";
    public static final String OLD_PHONE = "^OD\\d{4}$";
    public static final String PHONE = "^(CH|XT|OD)\\d{4}$";
    public static boolean validatePhone(String regex) throws PhoneException   {
        Matcher matcher = Pattern.compile(PHONE).matcher(regex);
        if(!matcher.matches()) throw new PhoneException("ID "+regex+" khong chinh xac");
        return matcher.matches();
    }

    public static boolean validateHomePhoneId(String regex)   {
        Matcher matcher = Pattern.compile(HOME_PHONE).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateForeignPhoneId(String regex)   {
        Matcher matcher = Pattern.compile(FOREIGN_PHONE).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateOldPhoneId(String regex)   {
        Matcher matcher = Pattern.compile(OLD_PHONE).matcher(regex);
        return matcher.matches();
    }

    public static boolean validateDate(String regex)   {
        Matcher matcher = Pattern.compile(DATE_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateEmail(String regex)   {
        Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateBankName(String regex) {
        Matcher matcher = Pattern.compile(BANKNAME_REGEX).matcher(regex);
   
        return matcher.matches();
    }

  

}
