package comparator;

import java.time.LocalDate;
import java.util.Comparator;

import entity.Sponsor;
import manager.SponsorManager;

public class ComparatorByDateAndId implements Comparator<Sponsor> {

	@Override
	public int compare(Sponsor o1, Sponsor o2) {
		if (o1.getSponsorDate().equals(o2.getSponsorDate())) {
			return o1.getSponsorId().compareTo(o2.getSponsorId());
		}else {
			LocalDate localDate1 = SponsorManager.stringToLocalDate(o1.getSponsorDate());
			LocalDate localDate2 = SponsorManager.stringToLocalDate(o2.getSponsorDate());
			return localDate1.compareTo(localDate2);
		}
	}

}
