package model;

import java.util.Set;

public class Intern extends Candidate {
	private String majors;
	private String semester;
	private String universityName;

	



	public Intern(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType,
			int candidateCount, Set<Certificated> setCertificateds, String majors, String semester,
			String universityName) {
		super(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, setCertificateds);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "Intern [majors=" + majors + ", semester=" + semester + ", universityName=" + universityName
				+ ", CandidateID=" + CandidateID + ", fullName=" + fullName + ", birthDay=" + birthDay + ", phone="
				+ phone + ", email=" + email + ", candidateType=" + candidateType + ", candidateCount=" + candidateCount
				+ ", setCertificateds=" + super.getCertificateString() + "]";
	}

	@Override
	public void showMe() {
		System.out.println(toString());
	}

}
