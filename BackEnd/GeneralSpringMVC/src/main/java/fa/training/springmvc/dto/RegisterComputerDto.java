/**
 * @author HauHP
 * @date 27 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterComputerDto implements Validator{
	private String maKH;
	private String maMay;
	@NotBlank(message = "Vui long nhap ngay bat dau su dung")
	private String ngayBatDauSuDung;
	@NotBlank(message = "Vui long nhap gio bat dau su dung")
	private String gioBatDauSuDung;
	@NotBlank(message = "Vui long nhap thoi gian su dung")
	private String thoiGianSuDung;
	public RegisterComputerDto(String maKH, String maMay, String ngayBatDauSuDung, String gioBatDauSuDung,
			String thoiGianSuDung) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
	}
	public RegisterComputerDto() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}
	public void setNgayBatDauSuDung(String ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}
	public String getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}
	public void setGioBatDauSuDung(String gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}
	public String getThoiGianSuDung() {
		return thoiGianSuDung;
	}
	public void setThoiGianSuDung(String thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
}
