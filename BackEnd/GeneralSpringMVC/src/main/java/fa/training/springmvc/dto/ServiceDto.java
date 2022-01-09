/**
 * @author HauHP
 * @date 27 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServiceDto implements Validator{
	@NotBlank(message = "Vui long nhap ma dich vu")
	private String maDV;
	@NotBlank(message = "Vui long nhap ten dich vu")
	private String tenDV;
	@NotBlank(message = "Vui long nhap don vi tinh")
	private String donViTinh;
	@NotBlank(message = "Vui long nhap don gia")
	@Min(value = 1,message = "Vui long nhap don gia > 0")
	private String donGia;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		 ServiceDto serviceDto = (ServiceDto) target;
	        String patternCode = "^DV\\d{3}";
	        if (!java.util.regex.Pattern.matches(patternCode, serviceDto.maDV)) {
	            errors.rejectValue("maDV", "error.service.maDV");
	        }
	        String patternInt = "^\\d*";
	        if (!java.util.regex.Pattern.matches(patternInt, serviceDto.donGia)) {
	            errors.rejectValue("donGia", "error.service.donGia");
	        }
		
	}
	public ServiceDto(String maDV, String tenDV, String donViTinh, String donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}
	public ServiceDto() {
		super();
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	

}
