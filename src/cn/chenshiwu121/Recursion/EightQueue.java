package cn.chenshiwu121.Recursion;

public class EightQueue {
	
	private int max = 8;
	private int[] arr = new int[max];
	
	public static void main(String[] args) {
		 EightQueue q = new EightQueue();
//		 q.print();
		 q.run(0);
	}
	
	private void run(int n) {
		if (n == max) {
			print();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[n] = i;
			if (judge(n)) {
				run(n+1);
			}
		}
	}
	
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n] || 
					Math.abs(n-i) == Math.abs(arr[n]-arr[i])) 
				return false;
		}
		return true;
	}
	
	private void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf(" %d ", arr[i]);
		}
		System.out.println();
	}

}
