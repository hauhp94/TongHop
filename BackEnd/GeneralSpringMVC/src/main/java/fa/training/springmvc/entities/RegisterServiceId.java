/**
 * @author HauHP
 * @date 25 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.entities;

import java.io.Serializable;

public class RegisterServiceId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKH;
	private String maDV;
	private String ngaySuDung;
	private String gioSuDung;
	public RegisterServiceId(String maKH, String maDV, String ngaySuDung, String gioSuDung) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
	}
	public RegisterServiceId() {
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
	

}
