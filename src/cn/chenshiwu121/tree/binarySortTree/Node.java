package cn.chenshiwu121.tree.binarySortTree;

public class Node {

	private int value;
	private Node left;
	private Node right;
	
	
	public Node(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public void add(Node node) {
		if (node == null) return;
		if (value > node.getValue()) {
			if (left !=null) {
				left.add(node);
			} else {
				left = node;
			}
		} else {
			if (right != null) {
				right.add(node);
			} else {
				right = node;
			}
		}
	}
	
	public void midOrder() {
		if (left != null) left.midOrder();
		System.out.println(this);
		if (right != null) right.midOrder();
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}
