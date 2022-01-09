/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(RegisterServiceId.class)
public class RegisterService {
	@Id
	private String maKH;
	@Id
	private String maDV;
	@Id
	private String ngaySuDung;
	@Id
	private String gioSuDung;
	private int soLuong;
	
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "maKH", referencedColumnName = "maKH",insertable=false, updatable=false)
	private Customer customer;
	
	@ManyToOne(targetEntity = Service.class, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "maDV", referencedColumnName = "maDV",insertable=false, updatable=false)
	private Service service;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	

}
