package cn.chenshiwu121.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import cn.chenshiwu121.utils.CalcUtils;

public class PolandNotation {

	public static void main(String[] args) {
//		String expression = "1+((2+3)*4)-5";
//		String expression = "(30+4)*5-6";
		String expression = "10+5-(2-6)*7";
		List<String> expressList = toStringList(expression);
//		System.out.println(expressList);
		List<String> suffixExpressList = toSuffixExpression(expressList);
//		System.out.println(suffixExpressList);
		System.out.printf("%s=%d\n", expression, calcSuffixExpression(suffixExpressList));
	}
	
	public static List<String> toStringList(String str) {
		if (str == null || str.equals("")) return null;
		List<String> list = new ArrayList<String>();
		int len = str.length();
		int index = 0;
		String sbuf = "";
		char ch;
		
		while (index < len) {
			ch = str.charAt(index++);
			sbuf += ch;
			if (CalcUtils.isOper(sbuf)) {
				list.add(sbuf);
				sbuf = "";
			} else if (index >= len || CalcUtils.isOper(str.charAt(index))) {
				list.add(sbuf);
				sbuf = "";
			}
		}
		return list;
	}
	
	/**
	 * 	中缀表达式转后缀表达式：
	 * 
	 * 	1.初始化两个栈：运算符栈（operStack）和存储中间结果的栈（midResultStack）；
	 *	2.从左至右扫描中缀表达式；
	 *	3.遇到操作数时，将其压入midResultStack；
	 *	4.遇到运算符时，比较器与operStack栈定运算符的优先级：
	 *		1).如果operStack为空，或栈顶运算符为左括号"("，将直接将此运算符入栈；
	 *		2).否则，若优先级比栈顶运算符的高，也记那个运算符压入operStack；
	 *		3).否则，将operStack栈的运算符弹出压入midResultStack中，再次转到(4-1)与operStack中新的栈顶运算符相比较；
	 *	5.遇到括号时：
	 *		1).如果是左括号"("，则直接压入operStack；
	 *		2).如果是右括号")"，则依次弹出operStack栈顶的运算符，并压入midResultStack，直到遇到左括号为止，此时将这一对括号丢弃；
	 *	6.重复步骤2至5，直到表达式的最右边
	 *	7.将operStack中剩余的运算符依次弹出并压入midResultStack
	 *	8.依次弹出midResultStack中的元素并输出，结果的逆序几位中缀表达式对应的后缀表达式
	 * @param List<String> list
	 * @return List<String>
	 */
	public static List<String> toSuffixExpression(List<String> list) {
		
		Stack<String> operStack = new Stack<String>();
		Stack<String> numberStack = new Stack<String>();
		
		for (String str : list) {
			if (!CalcUtils.isOper(str)) { // 不是操作符
				numberStack.push(str);
			} else {  // 是操作符
				if (operStack.empty()) { // 符号栈为空
					operStack.push(str);
				} else if (CalcUtils.isGroupOper(str)) { // 如果是分组操作符
					if (CalcUtils.groupOperDirect(str) == -1) { // 如果是左边分组操作符
						operStack.push(str);
					} else {
						while (true) {
							String oper = operStack.pop();
							if (CalcUtils.inGroupOperDirect(str).equals(oper)) break;
							numberStack.push(oper);
						}
					}
				} else { // 不是分组操作符
					while (true) {
						if (operStack.empty() || CalcUtils.getPriority(str) >= CalcUtils.getPriority(operStack.peek())) {
							operStack.push(str);
							break;
						} else {
							numberStack.push(operStack.pop());
						}
					}
				}
			}
		}
		
		while (operStack.size() > 0) {
			numberStack.push(operStack.pop());
		}
		return numberStack.subList(0, numberStack.size());
	}
	
	/**
	 * 	计算后缀（逆波兰）表达式
	 * 	
	 * 	1.初始化一个栈，用于存放操作数
	 * 	2.从左至右扫描中缀表达式
	 * 	3.遇到操作数时，将其压入栈
	 * 	4.遇到运算符时，弹出两个数，栈次顶的数与栈顶数来同运算符做运算，将结果再次压入栈中
	 * 	5.重复2至4直到表达式循环完成
	 * 	6.输出
	 * @param List<String> list
	 * @return Integer
	 */
	public static int calcSuffixExpression(List<String> list) {
		Stack<Integer> stack = new Stack<Integer>();
		int n, m, res;
		for (String str : list) {
			if (CalcUtils.isOper(str)) {
				m = stack.pop();
				n = stack.pop();
				res = CalcUtils.calc(n, m, str);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		if (stack.size() > 1) throw new RuntimeException("Calc Error: expression invalid.");
		return stack.pop();
	}
	
}
