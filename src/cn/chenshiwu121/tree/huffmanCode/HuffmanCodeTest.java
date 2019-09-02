package cn.chenshiwu121.tree.huffmanCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {

	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		HuffmanCode huffmanCode = new HuffmanCode();
		byte[] bytes = str.getBytes();
		
		List<Node> nodes = huffmanCode.getNodes(bytes);
		Node huffmanTreeRootNode = huffmanCode.createHuffmanTree(nodes);
		Map<Byte, String> codeMap = huffmanCode.createHuffmanCodeMap(huffmanTreeRootNode);
		byte[] code = huffmanCode.zip(bytes, codeMap);
		System.out.println(Arrays.toString(code));
		
	}

}
