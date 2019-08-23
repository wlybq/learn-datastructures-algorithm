package cn.chenshiwu121.search;

import java.util.Arrays;

public class FibonacciSearch {

	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 7, 8, 14, 65, 70, 71, 79, 40};
		fibonacciSearch(arr, 10);
	}

	public static int[] fib(int max) {
		int[] arr = new int[max];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < max; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr;
	}
	
	public static int getFibNumByIndex(int i) {
		if (i <= 2) return 1; 
		int[] f = fib(i);
		return f[f.length - 1];
	}
	
	public static int fibonacciSearch(int[] arr, int findVal) {
		int[] f;
		int k = 0;
		int n = arr.length - 1;
		while(n > getFibNumByIndex(k) - 1) {
			k++;
		}
		f = fib(k);
		System.out.println(Arrays.toString(f));
		int[] temp = Arrays.copyOf(arr, f[k - 1]);
		return -1;
	}
}
