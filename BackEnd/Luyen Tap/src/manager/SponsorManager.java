package manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import comparator.ComparatorByDateAndId;
import connection.FuncWriteRead;
import connection.SponsorRepositoryImpl;
import entity.Sponsor;
import exception.BankNameException;
import exception.EmailException;
import validate.ValidateData;

public class SponsorManager {
	public static void showInformation(List<Sponsor> sponsors) {
		for (Sponsor sponsor : sponsors) {
			sponsor.showMe();
//			System.out.println(sponsor.hashCode());
		}
	}

	public static Set<Sponsor> getSetSponsorValid() {
		List<Sponsor> sponsoros = FuncWriteRead.readSponsor();
		Set<Sponsor> sponsoroValidSet = new HashSet<Sponsor>();
		for (Sponsor sponsor : sponsoros) {
			try {
				if (ValidateData.validateBankName(sponsor.getBankName())
						&& ValidateData.validateEmail(sponsor.getEmail())) {
					if (sponsoroValidSet.add(sponsor)) {
						System.out.println("add sponsor to set ok");
					} else {
						System.err.println(sponsor.getSponsorId() + " duplicate sponsor id, no insert");
					}
				}
			} catch (EmailException | BankNameException e) {
				System.err.println(e.getMessage());
			}
		}
		return sponsoroValidSet;
	}

	public static void insertSetSponsor(Set<Sponsor> sponsors) {
		SponsorRepositoryImpl sponsorRepositoryImpl = new SponsorRepositoryImpl();
		for (Sponsor sponsor : sponsors) {
			sponsorRepositoryImpl.saveSponsor(sponsor);
		}
		System.out.println("insert list sponsor ok");
	}

	public static List<Sponsor> getListSponsorFromDB() {
		SponsorRepositoryImpl sponsorRepositoryImpl = new SponsorRepositoryImpl();
		return sponsorRepositoryImpl.findAll();
	}

	public static boolean checkIdExist(String sponsorId) {
		List<Sponsor> sponsors = getListSponsorFromDB();
		for (Sponsor sponsor : sponsors) {
			if (sponsorId.equals(sponsor.getSponsorId())) {
				return true;
			}
		}
		return false;
	}

	public static void updateSponsor() {
		SponsorManager.showInformation(getListSponsorFromDB());
		Scanner scanner = new Scanner(System.in);
		String sponsorIdString = "";
		while (true) {
			System.out.println("input id sponsor");
			sponsorIdString = scanner.nextLine();
			if (!checkIdExist(sponsorIdString)) {
				System.out.println("ID not exist");
			} else {
				break;
			}
		}
		System.out.println("input money");
		double sponsorMoney = 0;
		while (true) {
			System.out.println("input sponsor money");
			sponsorMoney = Double.parseDouble(scanner.nextLine());
			if (sponsorMoney < 50000) {
				System.out.println("money must >= 50.000");
			} else {
				break;
			}
		}
		System.out.println("input sponsor date yyyy-mm-dd");
		String sponsorDateString = "";
		while (true) {
			sponsorDateString = scanner.nextLine();
			if (!ValidateData.validateDate(sponsorDateString)) {
				System.out.println("Ngày tháng không đúng định dạng yyyy-mm-dd, nhập lại: ");
				continue;
			}
			LocalDate localDate = stringToLocalDate(sponsorDateString);

			if (getTypeSponsor(sponsorIdString) == 1 && localDate.getDayOfMonth() >= 1
					&& localDate.getDayOfMonth() <= 13) {
				break;
			} else if (getTypeSponsor(sponsorIdString) == 2 && localDate.getDayOfMonth() >= 14
					&& localDate.getDayOfMonth() <= 20) {
				break;
			} else if (getTypeSponsor(sponsorIdString) == 3 && localDate.getDayOfMonth() >= 21
					&& localDate.getDayOfMonth() <= 31) {
				break;
			} else {
				System.err.println("Date invalid, please input again");
			}
		}
		SponsorRepositoryImpl sponsorRepositoryImpl = new SponsorRepositoryImpl();
		sponsorRepositoryImpl.updateSponsor(sponsorIdString, sponsorMoney, sponsorDateString);
		System.out.println("update sponsor ok");
	}

	public static int getTypeSponsor(String sponsorId) {
		List<Sponsor> sponsors = getListSponsorFromDB();
		for (Sponsor sponsor : sponsors) {
			if (sponsor.getSponsorId().equals(sponsorId)) {
				return sponsor.getType();
			}
		}
		return 0;
	}

	public static LocalDate stringToLocalDate(String sponsorDateString) {
		String[] arr = sponsorDateString.split("-");
		int day = Integer.parseInt(arr[2]);
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		return LocalDate.of(year, month, day);
	}

	public static List<Sponsor> getListSponsorFullInfor() {
		List<Sponsor> sponsors = getListSponsorFromDB();
		List<Sponsor> sponsorsFullInfor = new ArrayList<Sponsor>();
		for (Sponsor sponsor : sponsors) {
			if (sponsor.getSponsorMoney() >= 50000 && sponsor.getSponsorDate() != null) {
				sponsorsFullInfor.add(sponsor);
			}
		}
		Collections.sort(sponsorsFullInfor, new ComparatorByDateAndId());
		return sponsorsFullInfor;
	}

	public static void deleteSponsorMissMoneyAndDate() {
		SponsorRepositoryImpl sponsorRepositoryImpl = new SponsorRepositoryImpl();
		List<Sponsor> sponsors = sponsorRepositoryImpl.findAll();
		for (Sponsor sponsor : sponsors) {
			if (sponsor.getSponsorDate() == null || sponsor.getSponsorMoney() < 50000) {
				sponsorRepositoryImpl.deleteSponsor(sponsor);
				System.out.println("delete sponsor id " + sponsor.getSponsorId() + " ok");
			}
		}
	}

}
