package day1;

import java.util.Scanner;

public class Cau6 {
	public static void convertBinary(int num) {
		int binary[] = new int[40];
		int index = 0;
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap  a = ");
		int a = scanner.nextInt();
		Cau6.convertBinary(a);
	}

}
