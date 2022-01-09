/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ViecLamDto implements Validator{
	private String maVL;
	private String moTa;
	private String duAn;
	private String ngonNgu;
	private String ngayBD;
	private String ngayKT;
	private int tongNgayCong;
	private String trangThai;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	}
	public ViecLamDto(String maVL, String moTa, String duAn, String ngonNgu, String ngayBD, String ngayKT,
			int tongNgayCong, String trangThai) {
		super();
		this.maVL = maVL;
		this.moTa = moTa;
		this.duAn = duAn;
		this.ngonNgu = ngonNgu;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		this.tongNgayCong = tongNgayCong;
		this.trangThai = trangThai;
	}
	public ViecLamDto() {
		super();
	}
	public String getMaVL() {
		return maVL;
	}
	public void setMaVL(String maVL) {
		this.maVL = maVL;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getDuAn() {
		return duAn;
	}
	public void setDuAn(String duAn) {
		this.duAn = duAn;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(String ngayBD) {
		this.ngayBD = ngayBD;
	}
	public String getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(String ngayKT) {
		this.ngayKT = ngayKT;
	}
	public int getTongNgayCong() {
		return tongNgayCong;
	}
	public void setTongNgayCong(int tongNgayCong) {
		this.tongNgayCong = tongNgayCong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
