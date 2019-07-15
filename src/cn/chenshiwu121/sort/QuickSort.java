package cn.chenshiwu121.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.chenshiwu121.utils.SortUtils;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//		int[] arr = SortUtils.getRandomArray(80000);
		long start = System.currentTimeMillis();
		sort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		System.out.printf("%dms", end - start);
//		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right) {
		
	}

}
