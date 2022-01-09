package day1;

import java.util.Scanner;

public class Cau9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int soDong, soCot;
		System.out.println("nhap so dong: ");
		soDong = scanner.nextInt();
		System.out.println("nhap so cot: ");
		soCot = scanner.nextInt();
		int[][] arr = new int[soDong][soCot];

		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print("nhap phan tu thu [" + i + ", " + j + "]: ");
				arr[i][j] = scanner.nextInt();
			}
		}
		System.out.println("mang vua nhap: ");
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("\n");
		}
		int x = 1;
		int count = 0;
		for (int j = 0; j < soCot; j++) {
			if (arr[0][j] % 3 == 0) {
				x *= arr[0][j];
				count++;
			}
		}
		if (count == 0) {
			System.out.println("khong co so nao o dong dau tien la boi cua 3");
		} else {
			System.out.println("co " + count + " " + " so la boi cua 3");
			System.out.println("tich cac so la boi cua 3 o dong dau tien la: " + x);
		}
		int[] arrX = new int[soDong];
		for (int i = 0; i < arrX.length; i++) {
			arrX[i] = timSoLonNhat(arr[i]);
		}
		System.out.println("mang chua cac phan tu lon nhat cua moi dong la ");
		for (int i : arrX) {
			System.out.print(i+ " ");
		}
		scanner.close();
	}
	public static int timSoLonNhat(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i >max) {
				max =i;
			}
		}
		return max;
	}
	

}
