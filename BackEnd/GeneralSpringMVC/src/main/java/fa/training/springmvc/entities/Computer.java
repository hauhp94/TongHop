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
public class Computer {
	@Id
	private String maMay;
	private String viTri;
	private String trangThai;
	
    @OneToMany(mappedBy = "maMay",cascade = CascadeType.ALL)
	private Set<RegisterComputer> registerComputers;

	public Computer(String maMay, String viTri, String trangThai, Set<RegisterComputer> registerComputers) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.registerComputers = registerComputers;
	}

	public Computer() {
		super();
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Set<RegisterComputer> getRegisterComputers() {
		return registerComputers;
	}

	public void setRegisterComputers(Set<RegisterComputer> registerComputers) {
		this.registerComputers = registerComputers;
	}
	
    

}
