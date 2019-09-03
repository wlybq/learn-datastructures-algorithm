package cn.chenshiwu121.utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
	public static void close(Closeable ...args) {
		for (Closeable c : args) {
			if (c != null) {
				try {
					c.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
