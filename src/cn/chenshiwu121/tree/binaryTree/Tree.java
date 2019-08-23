package cn.chenshiwu121.tree.binaryTree;

import cn.chenshiwu121.tree.Compare;

public interface Tree<T> {
	void preOrder(); // 前序遍历
	void midOrder(); // 中序遍历
	void rearOrder(); // 后序遍历
	T preSearch(Compare<T> s); // 前序遍历
	T midSearch(Compare<T> s); // 前序遍历
	T rearSearch(Compare<T> s); // 前序遍历
	boolean delNode(Compare<T> s); // 删除节点
}
