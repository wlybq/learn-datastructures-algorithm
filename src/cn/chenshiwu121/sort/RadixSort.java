package cn.chenshiwu121.sort;

import java.util.Arrays;

import cn.chenshiwu121.utils.SortUtils;

public class RadixSort {

	public static void main(String[] args) {
//		int[] arr = { 53, 3, 542, 748, 14, 241 };
		int[] arr = SortUtils.getRandomArray(8000000);
		long start = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.printf("%dms\n", end - start);
//		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int[][] bucket = new int[10][arr.length];
		int[] bucketEleCount = new int[10];
		int max = arr[0];
		int maxLen, descNum, index;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		maxLen = (max + "").length();
		
		for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				descNum = arr[j] / n % 10;
				bucket[descNum][bucketEleCount[descNum]++] = arr[j];
			}
			index = 0;
			for (int j = 0; j < bucketEleCount.length; j++) {
				if (bucketEleCount[j] > 0) {
					for (int j2 = 0; j2 < bucketEleCount[j]; j2++) {
						arr[index++] = bucket[j][j2];
					}
				}
				bucketEleCount[j] = 0;
			}
		}
	}

}
