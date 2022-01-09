package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.BankNameException;
import exception.EmailException;

public class ValidateData {
    public static final String DATE_REGEX = "^(19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+@gmail.com$";
    public static final String BANKNAME_REGEX = "^(VCB)|(AGB)|(MB)|(ACB)|(TPB)|(BIDV)$";
    public static boolean validateDate(String regex)   {
        Matcher matcher = Pattern.compile(DATE_REGEX).matcher(regex);
        return matcher.matches();
    }
    public static boolean validateEmail(String regex) throws EmailException  {
        Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        if(!matcher.matches()) throw new EmailException(regex+" Email này không hợp lệ ");
        return matcher.matches();
    }
    public static boolean validateBankName(String regex) throws BankNameException {
        Matcher matcher = Pattern.compile(BANKNAME_REGEX).matcher(regex);
        if (!matcher.matches()) {
            throw new BankNameException(regex + " Tên ngân hàng không hợp lệ.");  
        }
        return matcher.matches();
    }

  

}
