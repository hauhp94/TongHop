package main;

import java.util.List;

import connection.FuncWriteRead;
import entity.Phone;
import manager.PhoneManager;

public class Main {

	public static void main(String[] args) {
//		List<Phone> phones = FuncWriteRead.readPhone();
//		System.out.println("danh sach dien thoai trong file");
//		for (Phone phone : phones) {
//			phone.showInfo();
//		}
//		Set<Phone> phones2 = PhoneManager.getSetSponsorValid();
//		for (Phone phone : phones2) {
//			phone.showInfo();
//		}
//		PhoneManager.insertToDB();
		PhoneManager.searchPhone();
	
	}

}
