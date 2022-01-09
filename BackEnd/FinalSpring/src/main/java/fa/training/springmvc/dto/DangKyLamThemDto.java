/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DangKyLamThemDto implements Validator{
	private String maDK;
	private String maNV;
	private String hoTen;
	private String gioiTinh;
	private String capBac;
	private String maVL;
	@Min(value = 1,message = "nhap 1 toi 30")
	@Max(value=30,message = "nhap 1 toi 30")
	private int soNgayCong;
	private double tongTien;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	public DangKyLamThemDto(String maDK, String maNV, String hoTen, String gioiTinh, String capBac, String maVL,
			int soNgayCong, double tongTien) {
		super();
		this.maDK = maDK;
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.capBac = capBac;
		this.maVL = maVL;
		this.soNgayCong = soNgayCong;
		this.tongTien = tongTien;
	}
	public DangKyLamThemDto() {
		super();
	}
	public String getMaDK() {
		return maDK;
	}
	public void setMaDK(String maDK) {
		this.maDK = maDK;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCapBac() {
		return capBac;
	}
	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}
	public String getMaVL() {
		return maVL;
	}
	public void setMaVL(String maVL) {
		this.maVL = maVL;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
}
