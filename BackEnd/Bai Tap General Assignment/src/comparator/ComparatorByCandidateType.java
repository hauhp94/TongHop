package comparator;

import java.util.Comparator;

import exception.ValidateData;
import model.Candidate;

public class ComparatorByCandidateType implements Comparator<Candidate> {
	@Override
	public int compare(Candidate o1, Candidate o2) {
		if (o1.getCandidateType() > o2.getCandidateType()) {
			return 1;
		} else if (o1.getCandidateType() < o2.getCandidateType()) {
			return -1;
		} else {
			return ValidateData.stringBirthdayToLocadateBirthday2(o1.getBirthDay())
					.compareTo(ValidateData.stringBirthdayToLocadateBirthday2(o2.getBirthDay()));
		}
	}

}
