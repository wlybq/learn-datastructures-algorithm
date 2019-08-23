package cn.chenshiwu121.search;

import java.util.Arrays;

public class InsertValSearch {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		int index = insertValSearch(arr, 0, arr.length - 1, 50);
		System.out.println(index);
	}
	
	
	/**
	 * 插值查找
	 * @param arr 源数组
	 * @param left 左开始下标
	 * @param right 右开始下标
	 * @param findVal 查找的值
	 * @return 查找到的值下标 没有则返回-1表示没找到
	 */
	public static int insertValSearch(int[] arr, int left, int right, int findVal) {
		if (left > right || findVal < arr[left] || findVal > arr[right]) return -1;
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if (findVal > midVal) {
			return insertValSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return insertValSearch(arr, left, right - 1, findVal);
		} else {
			return mid;
		}
	}
	
}
