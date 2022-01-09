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
@IdClass(RegisterComputerId.class)
public class RegisterComputer {
	@Id
	private String maKH;
	@Id
	private String maMay;
	@Id
	private String ngayBatDauSuDung;
	@Id
	private String gioBatDauSuDung;
	private String thoiGianSuDung;
    
	@ManyToOne(targetEntity = Computer.class,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "maMay", referencedColumnName = "maMay",insertable=false, updatable=false)
	private Computer computer;
	
    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "maKH", referencedColumnName = "maKH",insertable=false, updatable=false)
    private Customer customer;

	public RegisterComputer(String maKH, String maMay, String ngayBatDauSuDung, String gioBatDauSuDung,
			String thoiGianSuDung) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public RegisterComputer() {
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

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
    

}
