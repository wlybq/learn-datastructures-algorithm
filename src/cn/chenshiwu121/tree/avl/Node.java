package cn.chenshiwu121.tree.avl;

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
	
	public int leftLenght() {
		if (left == null) return 0;
		return left.length();
	}
	
	public int rightLenght() {
		if (right == null) return 0;
		return right.length();
	}
	
	public int length() {
		return Math.max(left == null ? 0 : left.length(), right == null ? 0 : right.length()) + 1;
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
	
	public Node search(int val) {
		if (value == val) return this;
		if (value > val && left != null) return left.search(val);
		if (value < val && right != null) return right.search(val);
		return null;
	}
	
	public Node searchParent(int val) {
		if (left != null) {
			if (left.getValue() == val) {
				return this;
			}
			if (val < value) return left.searchParent(val);
		}
		if (right != null) {
			if (right.getValue() == val) {
				return this;
			}
			if (val > value) return right.searchParent(val);
		}
		return null;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}