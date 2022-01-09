package Comparator;

import java.util.Comparator;

import entity.Phone;

public class ComparatorByPriceAndStorage implements Comparator<Phone> {

	@Override
	public int compare(Phone o1, Phone o2) {
		if(o1.getPrice()>o2.getPrice()) {
			return 1;
			
		}else if (o1.getPrice()<o2.getPrice()) {
			return -1;
		}else {
			if(o1.getStorage()>o2.getStorage()) {
				return 1;
			}else if (o1.getStorage()<o2.getStorage()) {
				return -1;
			}else {
				return 0;
			}
		}
	}

}
