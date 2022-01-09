package model;

import java.util.Set;

public class Experience extends Candidate {
	private int ExpInYear;
	private String proSkillString;

	

	public Experience(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType,
			int candidateCount, Set<Certificated> setCertificateds, int expInYear, String proSkillString) {
		super(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, setCertificateds);
		ExpInYear = expInYear;
		this.proSkillString = proSkillString;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkillString() {
		return proSkillString;
	}

	public void setProSkillString(String proSkillString) {
		this.proSkillString = proSkillString;
	}
	

	@Override
	public String toString() {
		return "Experience [ExpInYear=" + ExpInYear + ", proSkillString=" + proSkillString + ", CandidateID="
				+ CandidateID + ", fullName=" + fullName + ", birthDay=" + birthDay + ", phone=" + phone + ", email="
				+ email + ", candidateType=" + candidateType + ", candidateCount=" + candidateCount
				+ ", setCertificateds=" + super.getCertificateString() + "]";
	}

	@Override
	public void showMe() {
		System.out.println(toString());
	}

	
	
}
