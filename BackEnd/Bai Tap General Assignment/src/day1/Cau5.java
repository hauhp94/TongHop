package day1;

import java.util.Scanner;

public class Cau5 {
	 public static int USCLN(int a, int b) {
	        if (b == 0) return a;
	        return USCLN(b, a % b);
	    }
	  public static int BSCNN(int a, int b) {
	        return (a * b) / USCLN(a, b);
	    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 System.out.print("Nhap  a = ");
	        int a = scanner.nextInt();
	        System.out.print("Nhap b = ");
	        int b = scanner.nextInt();
	        System.out.println("USCLN cua " + a + " và " + b
	                + " la: " + USCLN(a, b));
	        System.out.println("BSCNN cua " + a + " và " + b
	                + " la: " + BSCNN(a, b));

	}

}
