package model;

public class CandidateType {
	int id;
	String nameString;
	public CandidateType(int id, String nameString) {
		super();
		this.id = id;
		this.nameString = nameString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	

}
