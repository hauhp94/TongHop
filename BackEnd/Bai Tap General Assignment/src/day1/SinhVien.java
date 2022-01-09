package day1;

public class SinhVien {
	String studentNo;
	String studentName;
	String studentPhone;
	String email;
	int point;
	public SinhVien(String studentNo, String studentName, String studentPhone, String email, int point) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.email = email;
		this.point = point;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "SinhVien [studentNo=" + studentNo + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", email=" + email + ", point=" + point + "]";
	}
	
	

}
