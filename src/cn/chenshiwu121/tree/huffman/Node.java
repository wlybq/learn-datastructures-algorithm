package cn.chenshiwu121.tree.huffman;

public class Node implements Comparable<Node> {

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
	
	public void preOrder() {
		System.out.println(this);
		if (left != null) left.preOrder();
		if (right != null) right.preOrder();
	}

	@Override
	public int compareTo(Node o) {
		return value - o.getValue();
	}


	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	

}
