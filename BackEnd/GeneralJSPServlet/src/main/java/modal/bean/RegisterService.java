/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.bean;

public class RegisterService {
	private String maKH;
	private String maDV;
	private String ngaySuDung;
	private String gioSuDung;
	private int soLuong;
	public RegisterService(String maKH, String maDV, String ngaySuDung, String gioSuDung, int soLuong) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}
	public RegisterService() {
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

	

}
