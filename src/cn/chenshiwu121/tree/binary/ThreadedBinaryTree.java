package cn.chenshiwu121.tree.binary;

import cn.chenshiwu121.tree.Compare;
import cn.chenshiwu121.tree.Tree;

public class ThreadedBinaryTree<T> implements Tree<T> {
	private TreeNode<T> root;
	private TreeNode<T> __pre;

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	// 前序线索化二叉树
	public void threadedPreNodes() {
		threadedPreNodes(root);
	}
	// 前序线索化二叉树
	public void threadedPreNodes(TreeNode<T> node) {
		if (node == null) return;
		// 线索化当前节点
		if (node.getLeft() == null) {
			node.setLeft(__pre);
			node.setLeftType(1);
		}
		if (__pre != null && __pre.getRight() == null) {
			__pre.setRight(node);
			__pre.setRightType(1);
		}
		__pre = node;
		// 线索化左节点
		if (node.getLeftType() == 0) threadedPreNodes(node.getLeft());
		// 线索化右节点
		if (node.getRightType() == 0) threadedPreNodes(node.getRight());
	}
	
	// 中序线索化二叉树
	public void threadedMidNodes() {
		threadedMidNodes(root);
	}
	// 中序线索化二叉树
	public void threadedMidNodes(TreeNode<T> node) {
		if (node == null) return;
		// 线索化左节点
		threadedMidNodes(node.getLeft());
		// 线索化当前节点
		if (node.getLeft() == null) {
			node.setLeft(__pre);
			node.setLeftType(1);
		}
		if (__pre != null && __pre.getRight() == null) {
			__pre.setRight(node);
			__pre.setRightType(1);
		}
		__pre = node;
		// 线索化右节点
		threadedMidNodes(node.getRight());
	}
	
	// 后序线索化二叉树
	public void threadedRearNodes() {
		threadedRearNodes(root);
	}
	// 后序线索化二叉树
	public void threadedRearNodes(TreeNode<T> node) {
		if (node == null) return;
		// 线索化左节点
		threadedRearNodes(node.getLeft());
		// 线索化右节点
		threadedRearNodes(node.getRight());
		// 线索化当前节点
		if (node.getLeft() == null) {
			node.setLeft(__pre);
			node.setLeftType(1);
		}
		if (__pre != null && __pre.getRight() == null) {
			__pre.setRight(node);
			__pre.setRightType(1);
		}
		__pre = node;
	}
	
	// 遍历中序线索二叉树
	public void threadedMidOrder() {
		TreeNode<T> node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}

	@Override
	public void preOrder() {
	}

	@Override
	public void midOrder() {
	}

	@Override
	public void rearOrder() {
	}

	@Override
	public T preSearch(Compare<T> s) {
		return null;
	}

	@Override
	public T midSearch(Compare<T> s) {
		return null;
	}

	@Override
	public T rearSearch(Compare<T> s) {
		return null;
	}

	@Override
	public boolean delNode(Compare<T> s) {
		return false;
	}
	
}
