package cn.chenshiwu121.stack;

import cn.chenshiwu121.utils.CalcUtils;

public class Calculator {

	public static void main(String[] args) {
		String expression = "7000+2*6-200";
		Stack<Integer> numberStack = new ArrayStackWrapper<Integer>();
		Stack<Character> operStack = new ArrayStackWrapper<Character>();
		int index = 0, 
			len = expression.length(), 
			n, m, res;
		char oper, ch;
		String sbuf = "";
		
		while (true) {
			ch = expression.charAt(index++);
			if (CalcUtils.isOper(ch)) {
				if (!operStack.isEmpty()) {
					if (CalcUtils.getPriority(ch) <= CalcUtils.getPriority(operStack.peek())) {
						m = numberStack.pop();
						n = numberStack.pop();
						oper = operStack.pop();
						res = CalcUtils.calc(n, m, oper);
						numberStack.push(res);
					}
				}
				operStack.push(ch);
			} else {
				sbuf += ch;
				if (index >= len || CalcUtils.isOper(expression.charAt(index))) {					
					numberStack.push(Integer.parseInt(sbuf));
					sbuf = "";
				}
			}
			if (index >= len) break;
		}
		
		while (true) {
			if (operStack.isEmpty()) break;
			m = numberStack.pop();
			n = numberStack.pop();
			oper = operStack.pop();
			res = CalcUtils.calc(n, m, oper);
			numberStack.push(res);
		}
		System.out.printf("%s=%s", expression, numberStack.pop());
	}

}
