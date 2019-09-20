package cn.chenshiwu121.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int[] arr = {13, 7, 8, 3, 29, 6, 1};
		Node rootNode = createHuffmanTree(arr);
		preOrder(rootNode);
	}
	
	public static void preOrder(Node rootNode) {
		if (rootNode == null) {
			System.out.println("[]");
		} else {
			rootNode.preOrder();
		}
	}
	
	public static Node createHuffmanTree(int[] arr) {
		List<Node> list = new ArrayList<Node>();
		for (int val: arr) {
			list.add(new Node(val));
		}
		while(list.size() > 1) {			
			Collections.sort(list);
			Node left = list.get(0);
			Node right = list.get(1);
			Node parent = new Node(left.getValue() + right.getValue());
			parent.setLeft(left);
			parent.setRight(right);
			list.remove(left);
			list.remove(right);
			list.add(parent);
		}
		return list.get(0);
	}

}
