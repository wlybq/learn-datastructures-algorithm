package cn.chenshiwu121.tree.binarySortTree;

public class BinarySortTree {
	private Node root;
	
	public BinarySortTree() {
		super();
	}

	public BinarySortTree(Node root) {
		super();
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void add(Node node) {
		if (root == null) {
			root = node;
			return;
		}
		root.add(node);
	}
	
	public void midOrder() {
		if (root == null) System.out.println("[]");
		else root.midOrder();
	}
}
