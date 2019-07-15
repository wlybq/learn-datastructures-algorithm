package cn.chenshiwu121.sort;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class SelectSort {

	public static void main(String[] args) {
//		int[] arr = {3, 9, -1, 10, 20, 30, 40, 50, 60};
//		int[] arr = {3, 20, 9, 30, -1, 60, 50, 10, 40};
		int[] arr = SortUtils.getRandomArray(80000);
		long start = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("%dms", end - start);
//		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

}
