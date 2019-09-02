package cn.chenshiwu121.tree;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class HeapSort2 {
	public static void main(String[] args) {
//		int[] arr = {4, 6, 8, 5, 9};
		int[] arr = SortUtils.getRandomArray(8);
		long start = System.currentTimeMillis();
		heapSort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("%dms", end - start);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapSort(int[] arr) {
		int temp;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			shiftDown(arr, i, arr.length);
		}
		for (int i = arr.length - 1; i > 0; i--) {
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			shiftDown(arr, 0, i);
		}
	}
	
	public static void shiftDown(int[] arr, int i, int len) {
		int temp = arr[i];
		for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
			if (len > j + 1 && arr[j] < arr[j + 1]) {
				j++;
			}
			if (arr[j] > temp) {
				arr[i] = arr[j];
				i = j;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
}
