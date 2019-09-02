package cn.chenshiwu121.tree.huffmanCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {

	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] bytes = str.getBytes();
		byte[] code = HuffmanCode.huffmanZip(bytes);
		System.out.println(Arrays.toString(code));
		
	}

}
