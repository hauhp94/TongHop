package manager;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class MainController {
	private static Logger logger = Logger.getLogger(MainController.class);

	public static void displayMainMenu(){
        String chon = "";
        while (true){
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ỨNG VIÊN –\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới ứng viên\n" +
                    "2. Hiển thị tên tất cả ứng viên nối nhau bằng dấu ,\n" +
                    "3. Xem danh sách các ứng viên\n" +
                    "4. Xem danh sách ứng viên không trùng id\n" +
                    "5. Sửa thông tin ứng viên bằng concur_updable\n" +
                    "6. Thêm ứng viên bằng concur_updable\n" +
                    "7. Thoát\n");
                Scanner scanner = new Scanner(System.in);
                chon = scanner.nextLine();
            switch (chon){
                case "1":
                	logger.info("Da vao phuong thuc them moi ung vien");
                    CandidateManager.addCandidate();;
                    break;
                case "2":
                	CandidateManager.displayName();
                    break;
                case "3":
                	logger.info("Da vao phuong thuc them hien thi danh sach ung vien");
                	CandidateManager.getCandidates();
                    break;
                case "4":
                	CandidateManager.getMapCandidates();
                    break;
                case "5":
                	CandidateManager.getCandidates();
                	CandidateManager.updateCandidateByConcur();
                    break;
                case "6":
                	CandidateManager.insertCandidateByConcur();
                    break;
                case "7":
                    System.out.println("Thoát");
                    System.exit(0);
                default:
                	logger.warn("da nhap sai lua chon");
                    System.out.println("Chỉ được chọn 1-7");
            }
        }
    }
}
