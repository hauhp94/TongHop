package entity;

import java.util.Objects;

public abstract class Sponsor {
	int type;
	String sponsorId;
	String name;
	String address;
	String phone;
	String email;
	String bankingAccount;
	String bankName;
	double sponsorMoney;
	String sponsorDate;

	public Sponsor(int type, String sponsorId, String name, String address, String phone, String email,
			String bankingAccount, String bankName, double sponsorMoney, String sponsorDate) {
		super();
		this.type = type;
		this.sponsorId = sponsorId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.bankingAccount = bankingAccount;
		this.bankName = bankName;
		this.sponsorMoney = sponsorMoney;
		this.sponsorDate = sponsorDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankingAccount() {
		return bankingAccount;
	}

	public void setBankingAccount(String bankingAccount) {
		this.bankingAccount = bankingAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getSponsorMoney() {
		return sponsorMoney;
	}

	public void setSponsorMoney(double sponsorMoney) {
		this.sponsorMoney = sponsorMoney;
	}

	public String getSponsorDate() {
		return sponsorDate;
	}

	public void setSponsorDate(String sponsorDate) {
		this.sponsorDate = sponsorDate;
	}

	public abstract void showMe();

	@Override
	public int hashCode() {
		return Objects.hash(sponsorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sponsor other = (Sponsor) obj;
		return Objects.equals(sponsorId, other.sponsorId);
	}
	

}
