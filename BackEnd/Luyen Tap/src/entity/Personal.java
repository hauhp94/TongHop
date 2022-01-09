package entity;

import java.util.Objects;

public class Personal extends Sponsor {
	private String job;
	private String company;

	public Personal(int type, String sponsorId, String name, String address, String phone, String email,
			String bankingAccount, String bankName, String job,
			String company, double sponsorMoney, String sponsorDate) {
		super(type, sponsorId, name, address, phone, email, bankingAccount, bankName, sponsorMoney, sponsorDate);
		this.job = job;
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Personal [job=" + job + ", company=" + company + ", type=" + type + ", sponsorId=" + sponsorId
				+ ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", bankingAccount=" + bankingAccount + ", bankName=" + bankName + ", sponsorMoney=" + sponsorMoney
				+ ", sponsorDate=" + sponsorDate + "]";
	}

	//Biểu diễn thông tin của cá nhân
	@Override
	public void showMe() {
		System.out.println(toString());
	}



}
