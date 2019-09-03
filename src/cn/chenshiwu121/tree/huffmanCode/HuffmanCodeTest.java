package cn.chenshiwu121.tree.huffmanCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import cn.chenshiwu121.utils.CloseUtils;

public class HuffmanCodeTest {

	public static void main(String[] args) {
//		String str = "i like like like java do you like a java";
//		byte[] bytes = str.getBytes();
//		byte[] bitCode = HuffmanCode.huffmanZip(bytes);
//		byte[] strBytes = HuffmanCode.decode(bitCode);
//		System.out.println(str);
//		System.out.println(new String(strBytes));
		
		zipFile("C:/Users/csw/Desktop/1.bmp",
				"C:/Users/csw/Desktop/1.myz");
//		unzipFile("C:/Users/csw/Desktop/环境说明.myz",
//				"C:/Users/csw/Desktop/环境说明2.txt");
	}
	
	public static void zipFile(String srcFile, String distFile) {
		InputStream is = null;
		ObjectOutputStream os = null;
		try {
			is = new FileInputStream(new File(srcFile));
			os = new ObjectOutputStream(new FileOutputStream(new File(distFile)));
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			byte[] bitCode = HuffmanCode.huffmanZip(bytes);
			Map<Byte, String> codeMap = HuffmanCode.getCodeMap();
			os.writeObject(bitCode);
			os.writeObject(codeMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			CloseUtils.close(is);
			CloseUtils.close(os);
		}
	}
	
	public static void unzipFile(String srcFile, String distFile) {
		ObjectInputStream is = null;
		OutputStream os = null;
		try {
			is = new ObjectInputStream(new FileInputStream(new File(srcFile)));
			os = new FileOutputStream(new File(distFile));
			byte[] bytes = (byte[]) is.readObject();
			Map<Byte, String> codeMap = (Map<Byte, String>) is.readObject();
			byte[] bitCode = HuffmanCode.decode(codeMap, bytes);
			os.write(bitCode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			CloseUtils.close(is);
			CloseUtils.close(os);
		}
	}
}
