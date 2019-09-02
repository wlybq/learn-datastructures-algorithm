package cn.chenshiwu121.tree.huffmanCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	
	private HuffmanCode() throws Exception {
		throw new Exception("can't call constructor method.");
	}
	
	// 根据byte数组生成node列表
	public static List<Node> getNodes(byte[] arr) {
		List<Node> nodes = new ArrayList<Node>();
		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		int temp;
		for (Byte b : arr) {
			if (counts.containsKey(b)) {
				temp = counts.get(b) + 1;
			} else {
				temp = 1;
			}
			counts.put(b, temp);
		}
		for(Map.Entry<Byte, Integer> entry: counts.entrySet())
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		return nodes;
	}
	
	// 根据node列表生成霍夫曼树
	public static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size() > 1) {
			Collections.sort(nodes);
			Node left = nodes.get(0);
			Node right = nodes.get(1);
			Node parent = new Node();
			parent.setWeight(left.getWeight() + right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	// 生成霍夫曼编码code装饰方法
	public static Map<Byte, String> createHuffmanCodeMap(Node huffmanTreeRootNode) {
		if (huffmanTreeRootNode == null) return null;
		Map<Byte, String> huffmanCodeMap = new HashMap<Byte, String>();
		createHuffmanCodeByNode(huffmanTreeRootNode, huffmanCodeMap, "");
		return huffmanCodeMap;
	}
	
	// 生成霍夫曼编码code核心方法
	private static void createHuffmanCodeByNode(Node node, Map<Byte, String> map, String code) {
		if (node != null) {
			if (node.getData() == null) {
				createHuffmanCodeByNode(node.getLeft(), map, code + "0");
				createHuffmanCodeByNode(node.getRight(), map, code + "1");
			} else {
				map.put(node.getData(), code);
			}
		}
	}
	
	// 压缩
	public static byte[] zip(byte[] src, Map<Byte, String> huffmanCodeMap) {
		StringBuilder builder = new StringBuilder();
		byte[] huffmanCodeBytes;
		int len;
		for (byte b : src) {
			builder.append(huffmanCodeMap.get(b));
		}
		len = builder.length();
		huffmanCodeBytes = new byte[(int) Math.ceil(len / 8.0)];
		for (int i = 0; i < huffmanCodeBytes.length; i++) {
			int index = i * 8;
			int divVal = index + 8;
			if (divVal > len) {
				divVal = len;
			}
			String temp = builder.substring(index, divVal);
			huffmanCodeBytes[i] = (byte) Integer.parseInt(temp, 2);
		}
		return huffmanCodeBytes;
	}

	// 压缩，简单调用
	public static byte[] huffmanZip(byte[] src) {
		List<Node> nodes = getNodes(src);
		Node huffmanTreeRootNode = createHuffmanTree(nodes);
		Map<Byte, String> codeMap = createHuffmanCodeMap(huffmanTreeRootNode);
		return zip(src, codeMap);
	}
	
	// 前序打印
	public void preOrder(Node root) {
		if (root == null) {
			System.out.println("[]");
		} else {
			root.preOrder();
		}
	}
}
