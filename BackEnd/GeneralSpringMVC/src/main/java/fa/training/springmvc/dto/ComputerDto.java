/**
 * @author HauHP
 * @date 27 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ComputerDto implements Validator{
	@NotBlank(message = "Vui lòng nhập mã máy")
	private String maMay;
	@NotBlank(message = "Vui lòng nhập vị trí")
	private String viTri;
	@NotBlank(message = "Vui lòng nhập trạng thái")
	private String trangThai;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		  ComputerDto customerDto = (ComputerDto) target;
	        String patternCode = "^M\\d{3}";
	        if (!java.util.regex.Pattern.matches(patternCode, customerDto.maMay)) {
	            errors.rejectValue("maMay", "error.computer.maMay");
	        }
		
	}
	public ComputerDto(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}
	public ComputerDto() {
		super();
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
