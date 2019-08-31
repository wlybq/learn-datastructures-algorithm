package cn.chenshiwu121.tree.binaryTree;

import cn.chenshiwu121.tree.Compare;
import cn.chenshiwu121.tree.Tree;

public class TreeNode<T> implements Tree<T> {
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T obj;
	private int leftType = 0; // 指向左节点类型 0-子节点树 1-前驱节点
	private int rightType = 0; // 指向右节点类型 0-子节点树 1-后继节点
	
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
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
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
			left.midOrder();
		}
		System.out.println(obj);
		if (right != null) {
			right.midOrder();
		}
	}
	
	// 后序遍历
	@Override
	public void rearOrder() {
		if (left != null) {
			left.rearOrder();
		}
		if (right != null) {
			right.rearOrder();
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
	/**
	 * 删除节点
	 */
	@Override
	public boolean delNode(Compare<T> s) {
		TreeNode<T> temp = null;
		boolean flag = false;
		
		if (left != null && s.judge(left.getObj())) {
			temp = left.getLeft();
			// 被删除节点的左节点为空且被删除节点的右节点不为空
			if (temp == null && left.getRight() != null) {
				temp = left.getRight();
			}
			setLeft(temp);
			return true;
		}
		if (right != null && s.judge(right.getObj())) {
			temp = right.getLeft();
			// 被删除节点的左节点为空且被删除节点的右节点不为空
			if (temp == null && right.getRight() != null) {
				temp = right.getRight();
			}
			setRight(temp);
			return true;
		}
		if (left != null) {
			flag = left.delNode(s);
		}
		if (!flag && right != null) {
			flag = right.delNode(s);
		}
		return flag;
	}
}
