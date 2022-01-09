/**
 * @author HauHP
 * @date 26 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class CustomerDto implements Validator{
	@NotBlank(message = "Vui lòng nhập mã khách hàng")
	private String maKH;
	@NotBlank(message = "Vui lòng nhập tên khách hàng")
	private String tenKH;
	@NotBlank(message = "Vui lòng nhập địa chỉ")
	private String diaChi;
	@NotBlank(message = "Vui lòng nhập số điện thoại")
	private String soDienThoai;
	
	@NotBlank(message = "Vui lòng nhập email")
	@Email(message = "Vui lòng nhập email đúng định dạng")
	private String email;
	
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CustomerDto() {
		super();
	}
	public CustomerDto(String maKH, String tenKH, String diaChi, String soDienThoai, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
	    CustomerDto customerDto = (CustomerDto) target;
        String patternCode = "^KH\\d{5}";
        if (!java.util.regex.Pattern.matches(patternCode, customerDto.maKH)) {
            errors.rejectValue("maKH", "error.customer.maKH");
        }
        String patternPhone = "(09[0,1]\\d{7})|(\\(84\\)\\+9[0,1]\\d{7})";
        if (!java.util.regex.Pattern.matches(patternPhone, customerDto.soDienThoai)) {
            errors.rejectValue("soDienThoai", "error.customer.soDienThoai");
        }
		
	}
}
