package day1;

import java.util.ArrayList;

public class Cau10 {

	public static void main(String[] args) {
		System.out.println("cau a: doc danh sach sinh vien trong file STD.csv");
		ArrayList<SinhVien> arrayList = new ArrayList<SinhVien>();
		arrayList = FuncWriteRead.docDanhSachSinhVien();
		for (SinhVien sinhVien : arrayList) {
			System.out.println(sinhVien.toString());
		}
		System.out.println("cau b: ghi loi vao file csv neu khong dung dinh dang sdt va email");
		String errString = "";
		for (int i = 0; i < arrayList.size(); i++) {
			if (!ValidateData.validateSoDienThoai(arrayList.get(i).studentPhone)
					&& !ValidateData.validateEmail(arrayList.get(i).email)) {
				errString += "Line " + (i + 1) + " co loi dinh dang so dien thoai va email \n";
			} else if (!ValidateData.validateSoDienThoai(arrayList.get(i).studentPhone)) {
				errString += "Line " + (i + 1) + " co loi dinh dang so dien thoai \n";
			} else if (!ValidateData.validateEmail(arrayList.get(i).email)) {
				errString += "Line " + (i + 1) + " co loi dinh dang email \n";
			}
		}
		FuncWriteRead.ghiVaoFile(errString);
		ArrayList<String> errArrayList = new ArrayList<String>();
		errArrayList = FuncWriteRead.docFileErr();
		if (errArrayList.isEmpty()) {
			System.out.println("khong co loi dinh dang du lieu");
		}
		for (String string : errArrayList) {
			System.out.println(string);
		}

	}

}
