package manager;

import java.util.Scanner;

import connection.FuncWriteRead;
import entity.Sponsor;

public class MaiController {
	public static void displayMainMenu() {
		String chon = "";
		while (true) {
			System.out.println("--Manager Sponsor –\n" + "Chọn chức năng theo số (để tiếp tục):\n"
					+ "1. Đọc dữ liệu từ file (YC1)\n" + "2. Đọc và thêm dữ liệu hợp lệ vào database (YC2)\n"
					+ "3. Thông tin Sponsor từ database (YC3)\n" + "4. Cập nhật tiền ủng hộ và ngày ủng hộ (YC3)\n"
					+ "5. Hiển thị sponsor đầy đủ thông tin và đã sắp xếp theo ngày ủng hộ và id (YC3)\n"
					+ "6. Xóa các sponsor chưa có số tiền và ngày ủng hộ\n" + "7. Thoát\n");
			Scanner scanner = new Scanner(System.in);
			chon = scanner.nextLine();
			switch (chon) {
			case "1":
				System.out.println("Thông tin sponsor từ file");
				SponsorManager.showInformation(FuncWriteRead.readSponsor());
				break;
			case "2":
				System.out.println("Dữ liệu hợp lệ");
				for (Sponsor sponsor : SponsorManager.getSetSponsorValid()) {
					sponsor.showMe();
				}
				SponsorManager.insertSetSponsor(SponsorManager.getSetSponsorValid());
				break;
			case "3":
				System.out.println("Thông tin ủng hộ từ database");
				SponsorManager.showInformation(SponsorManager.getListSponsorFromDB());
				break;
			case "4":
				System.out.println("Cập nhật số tiền ủng hộ và ngày ủng hộ");
				SponsorManager.updateSponsor();
				break;
			case "5":
				System.out.println("Sponsor full infor");
				SponsorManager.showInformation(SponsorManager.getListSponsorFullInfor());
				break;
			case "6":
				System.out.println("Xóa các ủng hộ chưa có thông tin số tiền ủng hộ và ngày ủng hộ");
				SponsorManager.deleteSponsorMissMoneyAndDate();
				break;
			case "7":
				System.out.println("Thoát");
				System.exit(0);
			default:
				System.out.println("Chỉ được chọn 1-7");
			}
		}
	}
}
