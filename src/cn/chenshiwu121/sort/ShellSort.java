package cn.chenshiwu121.sort;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class ShellSort {

	public static void main(String[] args) {
//		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		int[] arr = SortUtils.getRandomArray(80000);
		long start = System.currentTimeMillis();
//		sort(arr);
		sort2(arr);
		long end = System.currentTimeMillis();
		System.out.printf("%dms", end - start);
//		System.out.println(Arrays.toString(arr));
	}
	
	// 交换法
	public static void sort(int[] arr) {
		int temp, n = arr.length / 2;
		for (; n > 0; n /= 2) {
			for (int i = n; i < arr.length; i++) {
				for (int j = i - n; j >= 0; j -= n) {
					if (arr[j] > arr[j + n]) {
						temp = arr[j];
						arr[j] = arr[j + n];
						arr[j + n] = temp;
					}
				}
			}
		}
	}
	
	// 位移法
	public static void sort2(int[] arr) {
		int temp, n = arr.length / 2;
		for (; n > 0; n /= 2) {
			for (int i = n; i < arr.length; i++) {
				int j = i;
				temp = arr[j];
				while (j - n >= 0 && temp < arr[j - n]) {
					arr[j] = arr[j - n];
					j -=n;
				}
				arr[j] = temp;
			}
		}
	}
	
}
