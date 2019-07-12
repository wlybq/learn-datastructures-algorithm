package cn.chenshiwu121.utils;

public class SortUtils {

	private SortUtils() {
	}
	
	public static int[] getRandomArray(int num) {
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = (int)(Math.random() * num * 100);
		}
		return arr;
	}
	
}
