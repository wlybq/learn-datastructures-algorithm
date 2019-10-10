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
	
	private void leftRotate() {
		// 以当前节点value创建新节点
		Node newNode = new Node(value);
		// 将新节点的左子树设置为当前节点的左子树
		newNode.setLeft(left);
		// 将新结点的右子树设置为当前节点的右子树的左子树
		newNode.setRight(right.getLeft());
		// 将当前接节点的值设置为当前节点的右子树的值
		value = right.getValue();
		// 将当前节点的右子树设置为当前接节点的右子树的右子树
		right = right.getRight();
		// 当前节点的左子树设置为新的节点
		left = newNode;
	}
	
	private void rightRotate() {
		// 以当前节点的value创建新节点
		Node newNode = new Node(value);
		// 将新结点的右子树设置为当前节点的右子树
		newNode.setRight(right);
		// 将新结点的左子树设置为当前节点的左子树的右子树
		newNode.setLeft(left.getRight());
		// 设置当前节点的值为当前节点的左子树的值
		value = left.getValue();
		// 设置当前节点的左子树为当前节点的左子树的左子树
		left = left.getLeft();
		// 设置当前节点的右子树为新节点
		right = newNode;
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
		// 如果右子树高度比左子树高度大1
		if (rightLenght() - leftLenght() > 1) {
			// 如果右子树的左子树高度比右子树的右子树高度大，那么，右子树需要右旋转一次  
			if (right.leftLenght() - right.rightLenght() > 0) {
				right.rightRotate();
			}
			// 左旋转
			leftRotate();
		}
		if (leftLenght() - rightLenght() > 1) {
			if (left.rightLenght() - left.leftLenght() > 0) {
				left.leftRotate();
			}
			rightRotate();
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
