package cn.chenshiwu121.tree.binaryTree;

import cn.chenshiwu121.tree.Compare;

public class BinaryTree<T> implements Tree<T> {
	private TreeNode<T> root;

	public BinaryTree() {
		super();
	}

	public BinaryTree(TreeNode<T> root) {
		super();
		this.root = root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	@Override
	public void preOrder() {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("[]");
		}
	}

	@Override
	public void midOrder() {
		if (root != null) {
			root.midOrder();
		} else {
			System.out.println("[]");
		}
	}

	@Override
	public void rearOrder() {
		if (root != null) {
			root.rearOrder();
		} else {
			System.out.println("[]");
		}
	}

	@Override
	public T preSearch(Compare<T> s) {
		if (root != null) {
			return root.preSearch(s);
		} else {
			return null;
		}
	}

	@Override
	public T midSearch(Compare<T> s) {
		if (root != null) {
			return root.midSearch(s);
		} else {
			return null;
		}
	}

	@Override
	public T rearSearch(Compare<T> s) {
		if (root != null) {
			return root.rearSearch(s);
		} else {
			return null;
		}
	}

	@Override
	public boolean delNode(Compare<T> s) {
		if (root != null && s.judge(root.getObj())) {
			root = null;
			return false;
		}
		return root.delNode(s);
	}
	
}
