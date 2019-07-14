package cn.chenshiwu121.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int temp, n = arr.length / 2;
		while (n > 0) {
			for(int i = n; i < arr.length; i++) {
				for (int j = i - n; j >= 0; j -= n) {
					if (arr[j] > arr[j+n]) {
						temp = arr[j];
						arr[j] = arr[j+n];
						arr[j+n] = temp;
					}
				}
			}
			n /= 2;
		}
	}
	
}
