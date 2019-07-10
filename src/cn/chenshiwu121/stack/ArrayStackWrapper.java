package cn.chenshiwu121.stack;

import java.util.HashMap;
import java.util.Map;

public class ArrayStackWrapper<T> implements Stack<T> {
	
	private ArrayStack<T> stack;
	private static final Map<Character, Integer> priority = new HashMap<Character, Integer>();
	
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}

	public ArrayStackWrapper() {
		super();
		stack = new ArrayStack<T>();
	}

	public ArrayStackWrapper(ArrayStack<T> stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void push(T o) {
		stack.push(o);
	}

	@Override
	public T pop() {
		return stack.pop();
	}

	@Override
	public T peek() {
		return stack.peek();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isFull() {
		return stack.isFull();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int getPriority(char oper) {
		return priority.get(oper);
	}
	
	public boolean isOper(char oper) {
		return priority.containsKey(oper);
	}
	
	public int calc(int n, int m, char oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = n + m;
			break;
		case '-':
			res = n - m;
			break;
		case '*':
			res = n * m;
			break;
		case '/':
			res = n / m;
			break;
		}
		return res;
	}

	@Override
	public String toString() {
		return stack.toString();
	}
	
	
	
}
