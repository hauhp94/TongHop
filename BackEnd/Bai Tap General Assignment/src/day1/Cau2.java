package day1;

import java.util.Scanner;

public class Cau2 {
	public static void main(String[] args) {
		System.out.printf("Nhap so n: ");
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		double a = 0;
		for (int i = 1; i <= n; i++) {
			a= a+ 1.0/i;
		}
		System.out.println("ket qua la: " + a);
	}

}
