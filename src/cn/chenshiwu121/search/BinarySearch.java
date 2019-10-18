package cn.chenshiwu121.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1, 8, 10, 89, 1000, 1234};
		int index = binarySearch(arr, 1000);
		System.out.println(index);
	}
	/**
	 * 二分查找
	 * @param arr 源数组
	 * @param left 左开始下标
	 * @param right 右开始下标
	 * @param findVal 查找的值
	 * @return 查找到的值下标 没有则返回-1表示没找到
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right || findVal < arr[left] || findVal > arr[right]) return -1;
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return binarySearch(arr, left, right - 1, findVal);
		} else {
			return mid;
		}
	}
	
	/**
	 * 二分查找，非递归版
	 */
	public static int binarySearch(int[] arr, int findVal) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] == findVal) return mid;
			else if (arr[mid] > findVal) right = mid - 1;
			else left = mid + 1;
		}
		return -1;
	}
	
}
