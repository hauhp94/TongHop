package manager;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.Soundbank;

import Comparator.ComparatorByPriceAndStorage;
import connection.FuncWriteRead;
import connection.PhoneRepositoryImpl;
import entity.ForeignPhone;
import entity.OldPhone;
import entity.Phone;
import exception.DuplicateException;
import exception.PhoneException;
import validate.ValidateData;

/**
 * @author hauhp
 *
 */
public class PhoneManager {
	/**
	 * phuong thuc lay danh sach phong trong file
	 */
	public static Set<Phone> getSetPhoneValid() {
		List<Phone> phones = FuncWriteRead.readPhone();
		Set<Phone> phoneSet = new HashSet<Phone>();
		for (Phone phone : phones) {
			try {
				if (ValidateData.validatePhone(phone.getId())) {
					if (!phoneSet.add(phone)) {
						throw new DuplicateException("ID " + phone.getId() + " da bi trung lap truoc do");
					}
				}
			} catch (PhoneException e) {
				System.err.println(e.getMessage());
			} catch (DuplicateException e) {
				System.err.println(e.getMessage());
			}

		}
		return phoneSet;
	}

	/**
	 * phuong thuc insert du lieu vao database
	 */
	public static void insertToDB() {
		PhoneRepositoryImpl phoneRepositoryImpl = new PhoneRepositoryImpl();
		Set<Phone> phones = PhoneManager.getSetPhoneValid();
		for (Phone phone : phones) {
			phoneRepositoryImpl.savePhone(phone);
		}
	}

	/**
	 * phuong thuc tim kiem dien thoai theo gia tien
	 */
	public static void searchPhone() {
		PhoneRepositoryImpl phoneRepositoryImpl = new PhoneRepositoryImpl();
		System.out.println("Tim kiem dien thoai theo gia tien 1.000.000 den 50.000.000");
		Scanner scanner = new Scanner(System.in);
		double minPrice =0;
		double maxPrice =0;
		while (true) {
			try {
				System.out.println("Nhap gia thap nhat");
				minPrice = Double.parseDouble(scanner.nextLine());
				if (minPrice>=1000000 && minPrice<=50000000) {
					break;
				}
			} catch (Exception e) {
				System.out.println("vui long nhap lai so lop le");
			}
		}
		while (true) {
			try {
				System.out.println("Nhap gia cao nhat nhat");
				maxPrice = Double.parseDouble(scanner.nextLine());
				if (maxPrice>=minPrice && minPrice<=50000000) {
					break;
				}
			} catch (Exception e) {
				System.out.println("vui long nhap lai so lop le");
			}
		}
		System.out.println("du lieu ok");
		List<Phone> phones = phoneRepositoryImpl.searchByPrice(minPrice, maxPrice);
		if(phones.size()==0) {
			System.out.println("khong co dien thoai nao phu hop");
			return;
		}
		Collections.sort(phones, new ComparatorByPriceAndStorage());
		System.out.println("ket qua tim duoc tu db gia tu "+ minPrice+ " den "+maxPrice + " sap xep theo gia tien va bo nho trong");
		for (int i = 0; i < phones.size(); i++) {
			System.out.println("so thu tu "+ i);
			phones.get(i).showInfo();
		}
		
		System.out.println("nhap so thu tu dien thoai muon mua ");
		int stt = Integer.parseInt(scanner.nextLine());
		System.out.println("chuc mung ban da mua thanh cong , thong tin dien thoai: ");
		phones.get(stt).showInfo();
		String chonString = "";
		if(ValidateData.validateForeignPhoneId(phones.get(stt).getId())) {
			ForeignPhone foreignPhone = (ForeignPhone) phones.get(stt);
			System.out.println("ban vua mua dien thoai xach tay, ban co muon mua goi bao hanh vang 1 nam khong y hoac n");
			chonString = scanner.nextLine();
			if (chonString.equals("y")) {
				System.out.println("cam on ban da mua goi bao hanh, tong tien");
				System.out.println(foreignPhone.getPrice() + foreignPhone.getPriceWarranty());
			}else {
				System.out.println("ban khong mua bao hanh, ok, tong tien");
				System.out.println(foreignPhone.getPrice() );
			}
			
		}
		if(ValidateData.validateOldPhoneId(phones.get(stt).getId())) {
			OldPhone oldPhone = (OldPhone) phones.get(stt);
			System.out.println("ban cua mua dien thoai cu, ban co muon mua goi bao hanh vang 1 nam khong y hoac n");
			chonString = scanner.nextLine();
			if (chonString.equals("y")) {
				System.out.println("cam on ban da mua goi bao hanh, tong tien");
				System.out.println(oldPhone.getPrice() + oldPhone.getPriceWarranty());
			}else {
				System.out.println("ban khong mua bao hanh, ok, tong tien");
				System.out.println(oldPhone.getPrice() );
			}
			
		}
		deletePhone(phones.get(stt).getId());
		System.out.println("Da xoa thanh cong id "+ phones.get(stt).getId()+" trong database");
		System.out.println("ban da mua thanh cong!!!");
		

	}
	/**
	 * phuong thuc xoa dien thoai trong database
	 */
	public static void deletePhone(String id) {
		PhoneRepositoryImpl phoneRepositoryImpl = new PhoneRepositoryImpl();
		phoneRepositoryImpl.deletePhone(id);
		System.out.println("xoa thanh cong id "+ id);
	}
}
