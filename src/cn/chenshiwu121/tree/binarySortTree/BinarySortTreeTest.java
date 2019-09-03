package cn.chenshiwu121.tree.binarySortTree;

public class BinarySortTreeTest {

	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9};
		BinarySortTree tree = new BinarySortTree();
		for (int i : arr) {
			tree.add(new Node(i));
		}
		tree.midOrder();
	}

}
