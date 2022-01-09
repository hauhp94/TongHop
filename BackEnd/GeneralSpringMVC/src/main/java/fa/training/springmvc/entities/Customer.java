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
public class Customer {
	@Id
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soDienThoai;
	private String email;
	@OneToMany(mappedBy = "maKH",cascade = CascadeType.ALL)
	private Set<RegisterComputer> registerComputers;
	@OneToMany(mappedBy = "maKH",cascade = CascadeType.ALL)
	private Set<RegisterService> registerServices;
	public Customer(String maKH, String tenKH, String diaChi, String soDienThoai, String email,
			Set<RegisterComputer> registerComputers, Set<RegisterService> registerServices) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.registerComputers = registerComputers;
		this.registerServices = registerServices;
	}
	public Customer() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<RegisterComputer> getRegisterComputers() {
		return registerComputers;
	}
	public void setRegisterComputers(Set<RegisterComputer> registerComputers) {
		this.registerComputers = registerComputers;
	}
	public Set<RegisterService> getRegisterServices() {
		return registerServices;
	}
	public void setRegisterServices(Set<RegisterService> registerServices) {
		this.registerServices = registerServices;
	}
	
	

}
