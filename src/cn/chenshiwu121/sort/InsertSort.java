package cn.chenshiwu121.sort;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class InsertSort {

	public static void main(String[] args) {
//		int[] arr = {3, 9, -1, 10, 20, 30, 40, 50, 60};
		int[] arr = {3, 20, 9, 30, -1, 60, 50, 10, 40};
//		int[] arr = SortUtils.getRandomArray(80000);
		long start = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("%dms\n", end - start);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			int insetIndex = i - 1;
			while(insetIndex >= 0 && insertVal < arr[insetIndex]) {
				arr[insetIndex + 1] = arr[insetIndex];
				insetIndex--;
			}
			arr[insetIndex + 1] = insertVal;
		}
	}
}
 