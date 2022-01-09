/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.bean;

public class CustomerUsing {
	private Customer customer;
	private Computer computer;
	private Service service;
	private String ngaySuDung;
	private String gioSuDung;
	private int soLuong;
	private String ngayBatDauSuDung;
	private String gioBatDauSuDung;
	private int thoiGianSuDung;
	private double tongTien;
	
	public CustomerUsing() {
		super();
	}
	
	public CustomerUsing(Customer customer, Computer computer, Service service, String ngaySuDung, String gioSuDung,
			int soLuong, String ngayBatDauSuDung, String gioBatDauSuDung, int thoiGianSuDung, double tongTien) {
		super();
		this.customer = customer;
		this.computer = computer;
		this.service = service;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
		this.tongTien = tongTien;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
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
	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}
	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	

	

}
