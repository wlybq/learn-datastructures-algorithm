package cn.chenshiwu121.tree.avl;

public class AVLTree {
	private Node root;
	
	public AVLTree() {
		super();
	}

	public AVLTree(Node root) {
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
	
	public Node search(int val) {
		if (root == null) return null;
		return root.search(val);
	}
	
	public Node searchParent(int val) {
		if (root == null) return null;
		return root.searchParent(val);
	}
	
	public int findAndDelRightMinNode(Node node) {
		Node target = node;
		while(target.getLeft() != null) {
			target = target.getLeft();
		}
		remove(target.getValue());
		return target.getValue();
	}
	
	public void remove(int val) {
		Node targetNode = search(val);
		if (targetNode != null) {
			// 删除的是根节点且根节点没有子节点
			if (root == targetNode && root.getLeft() == null && root.getRight() == null) {
				root = null;
				return;
			}
			Node parent = searchParent(val);
			// 删除有两个子节点的节点
			if (targetNode.getLeft() != null && targetNode.getRight() != null) {
				targetNode.setValue(findAndDelRightMinNode(targetNode.getRight()));
			// 删除没有子节点的叶子节点
			} else if (targetNode.getLeft() == null && targetNode.getRight() == null) {
				if (parent.getLeft() != null && parent.getLeft().getValue() == val) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			// 删除有一个子节点的节点
			} else {
				if (targetNode.getLeft() != null) {
					if (parent != null) {
						if (parent.getLeft().getValue() == val) {
							parent.setLeft(targetNode.getLeft());
						} else {
							parent.setRight(targetNode.getLeft());
						}
					} else {
						root = targetNode.getLeft();
					}
				} else {
					if (parent != null) {
						if (parent.getLeft().getValue() == val) {
							parent.setLeft(targetNode.getRight());
						} else {
							parent.setRight(targetNode.getRight());
						}
					} else {
						root = targetNode.getRight();
					}
				}
			}
		}
	}
}
