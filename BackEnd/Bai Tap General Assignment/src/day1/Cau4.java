package day1;

import java.util.Iterator;
import java.util.Scanner;

public class Cau4 {

	public static void main(String[] args) {
		System.out.printf("Nhap so m: ");
		Scanner scanner = new Scanner(System.in);
		String m = scanner.nextLine();
		String[] arr = m.split("");
		int s = 0;
		int p = 1;
		for (int i=0;i<arr.length;i++) {
			s = s + Integer.parseInt(arr[i]);
			p = p* Integer.parseInt(arr[i]);
		}
		System.out.println("S la "+ s);
		System.out.println("P la "+ p);

	}

}
