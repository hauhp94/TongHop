/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DangKyLamThem {
	@Id
	private String maDK;
	private String maNV;
	private String hoTen;
	private String gioiTinh;
	private String capBac;
	private String maVL;
	private int soNgayCong;
	private double tongTien;
	
	@ManyToOne(targetEntity = ViecLam.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "maVL", referencedColumnName = "maVL", insertable = false, updatable = false)
	private ViecLam viecLam;
	public DangKyLamThem(String maDK, String maNV, String hoTen, String gioiTinh, String capBac, String maVL,
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
	public DangKyLamThem() {
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
