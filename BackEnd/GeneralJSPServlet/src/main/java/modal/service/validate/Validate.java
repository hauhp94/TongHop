package modal.service.validate;

import modal.service.CustomerService;
import modal.service.CustomerServiceImpl;

public class Validate {
	public static CustomerService service = new CustomerServiceImpl();
    public static String validateName(String name) {
        String message = null;
        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if (!name.matches(regex)) {
            message = "Not OK. Student name invalid";
        }
        return message;
    }
    public static String validateMaKH(String maKH) {
        String message = null;
        String regex = "^KH\\d{5}$";
        if (!maKH.matches(regex)) {
            message = "Mã khách hàng không hợp lệ KH12345";
        }
        return message;
    }

    public static String validatePoint(int point) {
        String message = null;
        if (point < 0 || point > 100) {
            message = "Not OK. Student point invalid";
        }
        return message;
    }

    public static String validateCustomerCode(String code) {
        String message = null;
        String regex = "^KH-\\d{4}$";
        if (!code.matches(regex)) {
            message = "Not OK. Customer code invalid KH-1234";
        }
        return message;
    }

    public static String validateServiceCode(String code) {
        String message = null;
        String regex = "^DV-\\d{4}$";
        if (!code.matches(regex)) {
            message = "Not OK. Customer code invalid DV-1234";
        }
        return message;
    }

    public static String validatePhoneNumber(String phone) {
        String message = null;
        String regex = "^\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7}|090\\d{7}|091\\d{7}$";
        if (!phone.matches(regex)) {
            message = "Số điện thoại không hợp lệ (84)+901234567 hoặc 0901234567";
        }
        return message;
    }
    public static String validateCodeExist(String maKH) {
    	String message = null;
   
    	if (service.isCustomerCodeExist(maKH)) {
    		message = "Mã khách hàng đã tồn tại";
    	}
    	return message;
    }

    public static String validateIdCard(String idCard) {
        String message = null;
        String regex = "^\\d{9}$";
        if (!idCard.matches(regex)) {
            message = "Not OK. Id card invalid - 9 numbers";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(regex)) {
            message = "Email không hợp lệ";
        }
        return message;
    }

    public static String validateIntegerNumbers(int number) {
        String message = null;
        String regex = "^\\d+$";
        if (!(String.valueOf(number)).matches(regex)) {
            message = "Not OK. Number >=0 ";
        }
        return message;
    }

    public static String validatePositiveNumbers(double number) {
        String message = null;
        if (number < 0) {
            message = "Not OK. Number >=0 ";
        }
        return message;
    }

    public static boolean validateNumber(String num) {
        String regex = "^\\d$";
        return num.matches(regex);
    }
}
