package cn.chenshiwu121.tree.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
//		int[] arr = {4, 3, 6, 5, 7, 8};
//		int[] arr = {10, 12, 8, 9, 7, 6};
		int[] arr = {10, 11, 7, 6, 8, 9};
		AVLTree tree = new AVLTree();
		for (int i : arr) {
			tree.add(new Node(i));
		}
		tree.midOrder();
		
		System.out.println(tree.getRoot().length());
		System.out.println(tree.leftLength());
		System.out.println(tree.rightLenght());
//		System.out.println(tree.getRoot());
//		System.out.println(tree.getRoot().getLeft());
//		System.out.println(tree.getRoot().getLeft().getLeft());
//		System.out.println(tree.getRoot().getLeft().getRight());
//		System.out.println(tree.getRoot().getRight());
//		System.out.println(tree.getRoot().getRight().getLeft());
//		System.out.println(tree.getRoot().getRight().getRight());
	}

}
