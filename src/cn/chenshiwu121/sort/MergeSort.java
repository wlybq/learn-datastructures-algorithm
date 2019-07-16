package cn.chenshiwu121.sort;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class MergeSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
		int[] arr = SortUtils.getRandomArray(80000);
		long start = System.currentTimeMillis();
		sort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		System.out.printf("%dms\n", end - start);
//		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right) {
		int[] temp = new int[arr.length];
		split(arr, left, right, temp);
	}

	public static void split(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 左分支
			split(arr, left, mid, temp);
			// 右分支
			split(arr, mid + 1, right, temp);
			// 合并
			merge(arr, left, mid, right, temp);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		
		int l = left;
		int r = mid + 1;
		int t = 0;

		while (l <= mid && r <= right) {
			if (arr[l] < arr[r])
				temp[t++] = arr[l++];
			else
				temp[t++] = arr[r++];
		}

		while (l <= mid)
			temp[t++] = arr[l++];
		while (r <= right)
			temp[t++] = arr[r++];

		System.arraycopy(temp, 0, arr, left, t);
	}

}
