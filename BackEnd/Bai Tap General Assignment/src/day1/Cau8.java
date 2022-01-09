package day1;

import java.util.Scanner;

public class Cau8 {
	public static void main(String[] args) {
		System.out.println("cau a");
		System.out.print("nhap n: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("nhap phan tu thu " + (i + 1));
			arr[i] = scanner.nextInt();
		}
		System.out.println("cau b");
		int tongSoLe = 0;
		for (int i : arr) {
			if (i > 0 && i % 2 != 0) {
				tongSoLe += i;
			}
		}
		System.out.println("tong so duong le la " + tongSoLe);
		System.out.println("cau c");
		System.out.println("nhap so k: ");
		int k = scanner.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (k == arr[i]) {
				System.out.println(k + " xuat hien trong mang tai vi tri " + i);
			}
		}
		System.out.println("cau d: sap xep mang tang dan ");
		sapXepTangDan(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println("cau e");
		System.out.println("nhap so p: ");
		int p = scanner.nextInt();
		int[] newArr = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = p;
		sapXepTangDan(newArr, newArr.length);
		System.out.println("mang sau khi chen va sap xep la ");
		for (int i : newArr) {
			System.out.print(i + " ");
		}
		scanner.close();
	}

	private static void sapXepTangDan(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					int tg = a[i];
					a[i] = a[j];
					a[j] = tg;
				}
			}
		}
	}
}
