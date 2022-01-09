package entity;

public class Group extends Sponsor{
	private int  groupeSize;
	private String domain;

	public Group(int type, String sponsorId, String name, String address, String phone, String email,
			String bankingAccount, String bankName,int groupeSize,String domain,
			 double sponsorMoney, String sponsorDate ) {
		super(type, sponsorId, name, address, phone, email, bankingAccount, bankName, sponsorMoney, sponsorDate);
		this.groupeSize = groupeSize;
		this.domain = domain;
	}

	public int getGroupeSize() {
		return groupeSize;
	}

	public void setGroupeSize(int groupeSize) {
		this.groupeSize = groupeSize;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "Group [groupeSize=" + groupeSize + ", domain=" + domain + ", type=" + type + ", sponsorId=" + sponsorId
				+ ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", bankingAccount=" + bankingAccount + ", bankName=" + bankName + ", sponsorMoney=" + sponsorMoney
				+ ", sponsorDate=" + sponsorDate + "]";
	}

	//Biểu diễn thông tin của tập thể
	@Override
	public void showMe() {
		System.out.println(toString());
	}

}
