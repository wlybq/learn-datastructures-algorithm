package cn.chenshiwu121.tree.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
		int[] arr = {4, 3, 6, 5, 7, 8};
		AVLTree tree = new AVLTree();
		for (int i : arr) {
			tree.add(new Node(i));
		}
		tree.midOrder();
	}

}
