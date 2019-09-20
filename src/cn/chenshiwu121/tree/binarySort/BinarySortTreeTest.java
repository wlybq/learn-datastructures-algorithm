package cn.chenshiwu121.tree.binarySort;

public class BinarySortTreeTest {

	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		BinarySortTree tree = new BinarySortTree();
		for (int i : arr) {
			tree.add(new Node(i));
		}
		tree.midOrder();
		tree.remove(1);
		tree.remove(2);
		tree.remove(3);
		tree.remove(5);
		tree.remove(7);
		tree.remove(9);
		tree.remove(12);
		tree.remove(10);
		System.out.println("===================");
		tree.midOrder();
	}

}
