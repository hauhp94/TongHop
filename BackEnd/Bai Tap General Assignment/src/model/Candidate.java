package model;

import java.util.Set;

public abstract class Candidate {
	int CandidateID;
	String fullName;
	String birthDay;
	String phone;
	String email;
	int candidateType;
	int candidateCount;
	Set<Certificated> setCertificateds;

	

	public Candidate(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType,
			int candidateCount, Set<Certificated> setCertificateds) {
		
		super();
		CandidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidateType = candidateType;
		this.candidateCount = candidateCount;
		this.setCertificateds = setCertificateds;
	}
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getCandidateID() {
		return CandidateID;
	}

	public void setCandidateID(int candidateID) {
		CandidateID = candidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(int candidateType) {
		this.candidateType = candidateType;
	}

	public int getCandidateCount() {
		return candidateCount;
	}

	public void setCandidateCount(int candidateCount) {
		this.candidateCount = candidateCount;
	}

	public Set<Certificated> getSetCertificateds() {
		return setCertificateds;
	}

	public void setSetCertificateds(Set<Certificated> setCertificateds) {
		this.setCertificateds = setCertificateds;
	}

	public abstract void showMe();
	public String getCertificateString() {
		if(!this.setCertificateds.isEmpty()) {
			String certificateString = "";
			for (Certificated certificated : setCertificateds) {
				certificateString += certificated.getCertificateName() + " - ";
			}
			certificateString = certificateString.substring(0, certificateString.length()-2);
			return certificateString;
		}
		return "no certificate";
	}


}
