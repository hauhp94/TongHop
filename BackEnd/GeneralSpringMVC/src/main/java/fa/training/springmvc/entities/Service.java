/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service {
	@Id
	private String maDV;
	private String tenDV;
	private String donViTinh;
	private String donGia;
	@OneToMany(mappedBy = "maDV",cascade = CascadeType.ALL)
	private Set<RegisterService> registerServices;
	public Service(String maDV, String tenDV, String donViTinh, String donGia, Set<RegisterService> registerServices) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.registerServices = registerServices;
	}
	public Service() {
		super();
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public Set<RegisterService> getRegisterServices() {
		return registerServices;
	}
	public void setRegisterServices(Set<RegisterService> registerServices) {
		this.registerServices = registerServices;
	}

}
