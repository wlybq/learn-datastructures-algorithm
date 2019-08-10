package cn.chenshiwu121.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 8, 10, 89, 1000, 1234};
		int index = binarySearch(arr, 0, arr.length - 1, 100000);
		System.out.println(index);
	}
	
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) return -1;
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
	
}
