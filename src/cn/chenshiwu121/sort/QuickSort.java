package cn.chenshiwu121.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.chenshiwu121.utils.SortUtils;

public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr = SortUtils.getRandomArray(800000);
		long start = System.currentTimeMillis();
		sort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		System.out.printf("%dms", end - start);
//		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right) {
		int l = left; // 左活动指针
		int r = right;// 右活动指针
		int pivot = arr[(left + right) / 2]; // 基准值
		int temp;
		// 左活动指针小于又活动指针
		while(l < r) {
			// 指针移动
			while(arr[l] < pivot) l++; // 左活动指针持续往右移动，直到碰到大于等于基准值
			while(arr[r] > pivot) r--; // 右活动指针持续往左移动，直到碰到小于等于基准值
			
			if(l >= r) break; // 如果两个活动指针越过或碰上，退出循环
			
			// 交换活动指针停止边界值
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			// 如果左活动指针的值等于基准值，右活动指针往左运动一步
			if (arr[l] == pivot) r--;
			// 如果右活动指针的值等于基准值，左活动指针往右运动一步
			if (arr[r] == pivot) l++;
		}
		
		// 如果指针位置一样，将跳过当前的位置
		if (l == r) {
			l++;
			r--;
		}
		// 如果左指针初始值与活动右指针存在未排序区间，递归执行排序
		if (left < r) sort(arr, left, r);
		// 如果右指针初始值与活动左指针存在未排序区间，递归执行排序
		if (right > l) sort(arr, l, right);
	}

}
