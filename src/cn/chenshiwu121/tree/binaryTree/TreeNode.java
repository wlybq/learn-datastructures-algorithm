package cn.chenshiwu121.tree.binaryTree;

import cn.chenshiwu121.tree.Compare;

public class TreeNode<T> implements Tree<T> {
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T obj;
	
	public TreeNode() {
		super();
	}
	public TreeNode(T obj) {
		super();
		this.obj = obj;
	}
	public TreeNode(TreeNode<T> left, TreeNode<T> right, T obj) {
		super();
		this.left = left;
		this.right = right;
		this.obj = obj;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		return obj + "";
	}
	
	// 前序遍历
	@Override
	public void preOrder() {
		System.out.println(obj);
		if (left != null) {
			left.preOrder();
		}
		if (right != null) {
			right.preOrder();
		}
	}
	
	// 中序遍历
	@Override
	public void midOrder() {
		if (left != null) {
			left.preOrder();
		}
		System.out.println(obj);
		if (right != null) {
			right.preOrder();
		}
	}
	
	// 后序遍历
	@Override
	public void rearOrder() {
		if (left != null) {
			left.preOrder();
		}
		if (right != null) {
			right.preOrder();
		}
		System.out.println(obj);
	}
	@Override
	public T preSearch(Compare<T> s) {
		if (s.judge(obj)) return obj;
		T result = null;
		if (left != null) {
			result = left.preSearch(s);
		}
		if (result != null) return result;
		if (right != null) {
			result = right.preSearch(s);
		}
		return result;
	}
	@Override
	public T midSearch(Compare<T> s) {
		T result = null;
		if (left != null) {
			result = left.midSearch(s);
		}
		if (result != null) return result;
		if (s.judge(obj)) return obj;
		if (right != null) {
			result = right.midSearch(s);
		}
		return result;
	}
	@Override
	public T rearSearch(Compare<T> s) {
		T result = null;
		if (left != null) {
			result = left.rearSearch(s);
		}
		if (result != null) return result;
		if (right != null) {
			result = right.rearSearch(s);
		}
		if (result != null) return result;
		if (s.judge(obj)) return obj;
		return result;
	}
	@Override
	public boolean delNode(Compare<T> s) {
		TreeNode<T> temp = null;
		if (left != null && s.judge(left.getObj())) {
			if (left.getLeft() != null) {
				temp = left.getLeft();
				if (left.getRight() != null) {
					temp.setRight(left.getRight());
				}
			}
			if (left.getRight() != null) {
				temp = left.getRight();
			}
			setLeft(temp);
			return true;
		}
		if (right != null && s.judge(right.getObj())) {
			if (right.getLeft() != null) {
				temp = right.getLeft();
				if (right.getRight() != null) {
					temp.setRight(right.getRight());
				}
			}
			if (right.getRight() != null) {
				temp = right.getRight();
			}
			setRight(temp);
			return true;
		}
		boolean flag = false;
		if (left != null) {
			flag = left.delNode(s);
		}
		if (!flag && right != null) {
			flag = right.delNode(s);
		}
		return flag;
	}
}
