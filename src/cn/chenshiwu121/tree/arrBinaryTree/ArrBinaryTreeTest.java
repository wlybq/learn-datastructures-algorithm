package cn.chenshiwu121.tree.arrBinaryTree;

public class ArrBinaryTreeTest {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrBinaryTree<Integer> arrBinaryTree = new ArrBinaryTree<Integer>(arr);
		arrBinaryTree.preOrder();
		System.out.println("======================");
		arrBinaryTree.midOrder();
		System.out.println("======================");
		arrBinaryTree.rearOrder();
	}
}
