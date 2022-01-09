/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterServiceDto implements Validator {
	@NotBlank(message = "Vui long nhap ma khach hang")
	private String maKH;
	@NotBlank(message = "Vui long nhap ma dich vu")
	private String maDV;
	@NotBlank(message = "Vui long nhap ngay su dung")
	@Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "Ngay thang khong dung dinh dang dd/mm/yyyy")
	private String ngaySuDung;
	@NotBlank(message = "Vui long nhap gio su dung")
	@Pattern(regexp = "^([01][0-9]|2[0-3]):([0-5][0-9])$", message = "Thoi gian khong dung dinh dang 24h")
	private String gioSuDung;
	@Min(value = 1, message = "So luong phai lon hon 0")
	private int soLuong;

	public RegisterServiceDto(String maKH, String maDV, String ngaySuDung, String gioSuDung, int soLuong) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}

	public RegisterServiceDto() {
		super();
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(String ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public String getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(String gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterServiceDto registerServiceDto = (RegisterServiceDto) target;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		if (registerServiceDto.ngaySuDung.matches(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			LocalDate localDate = LocalDate.parse(registerServiceDto.ngaySuDung, formatter);
			if (localDate.isAfter(LocalDate.now())) {
				errors.rejectValue("ngaySuDung", "error.service.ngaySuDung");
			}
		}

	}

}
