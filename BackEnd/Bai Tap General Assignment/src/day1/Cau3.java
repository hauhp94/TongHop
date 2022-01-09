package day1;

import java.util.Scanner;

public class Cau3 {
	public static int tinhGiaiThua(int a) {
		int b =1;
		for(int i=1; i<=a; i++) {
			b=b*i;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.printf("Nhap so n: ");
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		double s = 1;
		for (int i = 1; i <= n; i++) {
			s += 1.0/Cau3.tinhGiaiThua((2*i + 1));
		}
		System.out.println("ket qua la: " + s);

	}

}
