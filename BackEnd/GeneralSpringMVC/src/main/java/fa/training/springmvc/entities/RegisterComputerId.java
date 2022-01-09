/**
 * @author HauHP
 * @date 25 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.entities;

import java.io.Serializable;

public class RegisterComputerId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKH;
	private String maMay;
	private String ngayBatDauSuDung;
	private String gioBatDauSuDung;
	public RegisterComputerId(String maKH, String maMay, String ngayBatDauSuDung, String gioBatDauSuDung) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
	}
	public RegisterComputerId() {
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
	
	

}
