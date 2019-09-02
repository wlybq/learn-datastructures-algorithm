package cn.chenshiwu121.tree.huffmanCode;

public class Node implements Comparable<Node> {
	private Byte data; // 存放数据本身
	private int weight; // 权值
	private Node left;
	private Node right;
	
	public Node() {
		super();
	}

	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	public Byte getData() {
		return data;
	}

	public void setData(Byte data) {
		this.data = data;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
		return weight - o.getWeight();
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
}
