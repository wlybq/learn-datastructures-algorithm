package cn.chenshiwu121.utils;

import java.util.Arrays;
import java.util.List;

public final class CalcUtils {
	
	private static List<String> groupOper = Arrays.asList(new String[]{"(", "[", "{", "}", "]", ")"});
	private static List<String> opers = Arrays.asList(new String[]{"+", "-", "*", "/"});

	private CalcUtils() {
	}
	
	public static boolean isOper(char oper) {
		return isOper(oper + "");
	}
	
	public static boolean isOper(String oper) {
		if (oper == null || oper.equals("")) return false;
		return opers.contains(oper) || groupOper.contains(oper);
	}
	
	public static boolean isGroupOper(char oper) {
		return isGroupOper(oper + "");
	}
	
	public static boolean isGroupOper(String oper) {
		if (oper == null || oper.equals("")) return false;
		return groupOper.contains(oper);
	}
	
	public static int groupOperDirect(char oper) {
		return groupOperDirect(oper + "");
	}
	
	public static int groupOperDirect(String oper) {
		if (oper == null || oper.equals("")) return 0;
		return groupOper.indexOf(oper) < (groupOper.size() / 2) ? -1 : 1;
	}
	
	public static String inGroupOperDirect(char oper) {
		return inGroupOperDirect(oper + "");
	}
	
	public static String inGroupOperDirect(String oper) {
		if (oper == null || oper.equals("")) return null;
		int inDirectIndex = groupOper.size() - 1 - groupOper.indexOf(oper);
		return groupOper.get(inDirectIndex);
	}

	public static int calc(int n, int m, char oper) {
		return calc(n, m, oper + "");
	}
	
	public static int calc(int n, int m, String oper) {
		int res = 0;
		switch (oper) {
		case "+":
			res = n + m;
			break;
		case "-":
			res = n - m;
			break;
		case "*":
			res = n * m;
			break;
		case "/":
			res = n / m;
			break;
		}
		return res;
	}
	
	public static int getPriority(char oper) {
		return getPriority(oper + "");
	}
	
	public static int getPriority(String oper) {
		int index = opers.indexOf(oper);
		if (index == 0 || index == 1) return 1;
		else if (index == 2 || index == 3) return 2;
		return 0;
	}
}
