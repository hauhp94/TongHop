package entity;

public class Company extends Sponsor {
	private String company;
	private String taxCode;

	public Company(int type, String sponsorId, String name, String address, String phone, String email,
			String bankingAccount, String bankName, String company,
			String taxCode, double sponsorMoney, String sponsorDate) {
		super(type, sponsorId, name, address, phone, email, bankingAccount, bankName, sponsorMoney, sponsorDate);
		this.company = company;
		this.taxCode = taxCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	@Override
	public String toString() {
		return "Company [company=" + company + ", taxCode=" + taxCode + ", type=" + type + ", sponsorId=" + sponsorId
				+ ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", bankingAccount=" + bankingAccount + ", bankName=" + bankName + ", sponsorMoney=" + sponsorMoney
				+ ", sponsorDate=" + sponsorDate + "]";
	}

	//Biểu diễn thông tin của công ty
	@Override
	public void showMe() {
		System.out.println(toString());
	}
	

}
