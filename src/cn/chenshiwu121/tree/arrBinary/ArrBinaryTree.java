package cn.chenshiwu121.tree.arrBinary;

import cn.chenshiwu121.tree.Compare;
import cn.chenshiwu121.tree.Tree;

public class ArrBinaryTree<T> implements Tree<T> {
	private int[] arr;
	
	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}

	@Override
	public void preOrder() {
		preOrder(0);
	}
	
	public void preOrder(int index) {
		if (arr == null && arr.length == 0) {
			System.out.println("[]");
		}
		System.out.println(arr[index]);
		if (index * 2 + 1 < arr.length) {
			preOrder(index * 2 + 1);
		}
		if (index * 2 + 2 < arr.length) {
			preOrder(index * 2 + 2);
		}
	}

	@Override
	public void midOrder() {
		midOrder(0);
	}
	
	public void midOrder(int index) {
		if (arr == null && arr.length == 0) {
			System.out.println("[]");
		}
		if (index * 2 + 1 < arr.length) {
			midOrder(index * 2 + 1);
		}
		System.out.println(arr[index]);
		if (index * 2 + 2 < arr.length) {
			midOrder(index * 2 + 2);
		}
	}

	@Override
	public void rearOrder() {
		rearOrder(0);
	}

	public void rearOrder(int index) {
		if (arr == null && arr.length == 0) {
			System.out.println("[]");
		}
		if (index * 2 + 1 < arr.length) {
			rearOrder(index * 2 + 1);
		}
		if (index * 2 + 2 < arr.length) {
			rearOrder(index * 2 + 2);
		}
		System.out.println(arr[index]);
	}

	
	@Override
	public T preSearch(Compare<T> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T midSearch(Compare<T> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T rearSearch(Compare<T> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delNode(Compare<T> s) {
		// TODO Auto-generated method stub
		return false;
	}

}
