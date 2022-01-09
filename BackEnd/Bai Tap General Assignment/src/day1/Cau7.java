package day1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Cau7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap  a = ");
		String a = scanner.nextLine();
		StringBuilder builder = new StringBuilder(a);
		builder.reverse();
		System.out.println("a: Mang sau khi dao la " + builder);

		String[] arr = a.split("");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].toUpperCase();
		}
		System.out.println("b:chuoi sau khi viet hoa la ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		String[] arr1 = a.split("");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i].toLowerCase();
		}
		System.out.println("c:chuoi sau khi viet thuong la ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		String[] arr2 = a.split("");
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		System.out.println("do dai cua chuoi la " + arr.length);
		System.out.println("cau d:");
		for (int i = 0; i < arr2.length; i++) {
			if (map.keySet().contains(arr2[i])) {
				map.put(arr2[i], map.get(arr2[i]) + 1);
			} else {
				map.put(arr2[i], 1);
			}
		}
		for (String string : map.keySet()) {
			System.out.println("ky tu " + string + " xuat hien " + map.get(string) + " lan");
		}
		
		System.out.println("cau e:");
		System.out.print("Nhap  m = ");
		int m = scanner.nextInt();
		System.out.print("Nhap  n = ");
		int n = scanner.nextInt();
		if(m>a.length() || n>a.length() || m>=n) {
			System.out.println("nhap vi tri khong hop le");
		}else {
			String cString = a.substring(m, n);
			System.out.println("chuoi cat tu m den n la "+ cString);
		}
	



	}
}
