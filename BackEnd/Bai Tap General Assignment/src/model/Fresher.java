package model;

import java.util.Set;

public class Fresher extends Candidate {
	private int graduationRank;
	private String graduationDate;
	private String education;






	public Fresher(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType,
			int candidateCount, Set<Certificated> setCertificateds, int graduationRank, String graduationDate,
			String education) {
		super(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, setCertificateds);
		this.graduationRank = graduationRank;
		this.graduationDate = graduationDate;
		this.education = education;
	}

	public int getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(int graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	

	@Override
	public String toString() {
		return "Fresher [graduationRank=" + graduationRank + ", graduationDate=" + graduationDate + ", education="
				+ education + ", CandidateID=" + CandidateID + ", fullName=" + fullName + ", birthDay=" + birthDay
				+ ", phone=" + phone + ", email=" + email + ", candidateType=" + candidateType + ", candidateCount="
				+ candidateCount + ", setCertificateds=" + super.getCertificateString() + "]";
	}

	@Override
	public void showMe() {
		System.out.println(toString());
	}

}
