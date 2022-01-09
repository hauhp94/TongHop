package fa.training.entities;

public class HourtyEmployee extends Employee {
	private double wage;
	private double workingHours;

	public HourtyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			Department department, double wage, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email, department);
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "HourtyEmployee [wage=" + wage + ", workingHours=" + workingHours + ", ssn=" + ssn + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", phone=" + phone + ", email="
				+ email + ", department=" + department + "]";
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
		return ssn + "," + firstName + "," + lastName + "," + birthDate + "," + phone + "," + email + ","
				+ department.getDepartmentName() + "," + wage + "," + workingHours;
	}

}
