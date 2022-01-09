package day1;

public class Cau11 {
	public int a = 2;
	public int b = 3;

	public static void thayDoiSo(int a, int b) {
		a = a + 1;
		b = b + 2;
	}

	public static void thayDoiSoKieuDoiTuong(Cau11 cau11) {
		cau11.a += 1;
		cau11.b += 2;
	}

	public static void thayDoiArr(int[] a) {
		a[0] = 99;
	}

	public static void main(String[] args) {
		Cau11 cau11 = new Cau11();
		System.out.println("a va b truoc khi chay ham thayDoiSo la " + cau11.a + " " + cau11.b);
		thayDoiSo(cau11.a, cau11.b);
		System.out.println("a va b sau khi chay ham thayDoiSo la " + cau11.a + " " + cau11.b);
		
		
		System.out.println("a va b truoc khi chay ham thayDoiSoKieuDoiTuong la " + cau11.a + " " + cau11.b);
		thayDoiSoKieuDoiTuong(cau11);
		System.out.println("a va b sau khi chay ham thayDoiSoKieuDoiTuong la " + cau11.a + " " + cau11.b);
		
		int[] arr = { 1, 2, 3, 4 };
		System.out.println("mang truoc khi chay ham thayDoiArr");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		thayDoiArr(arr);
		System.out.println("mang sau khi chay ham thayDoiArr");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
