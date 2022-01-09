package fa.training.entities;

public class SalariedEmployee extends Employee {
	private double commissionRate;
	private double grossSales;
	private double basicSalary;

	public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			Department department, double commissionRate, double grossSales, double basicSalary) {
		super(ssn, firstName, lastName, birthDate, phone, email, department);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [commissionRate=" + commissionRate + ", grossSales=" + grossSales + ", basicSalary="
				+ basicSalary + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", phone=" + phone + ", email=" + email + ", department=" + department + "]";
	}

	@Override
	public void display() {
		System.out.println(toString());
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getStringToWrite() {
		return ssn + "," + firstName + "," + lastName + "," + birthDate + "," + phone + "," + email + "," + department.getDepartmentName()
				+ "," + commissionRate + "," + grossSales + "," + basicSalary;
	}

}
