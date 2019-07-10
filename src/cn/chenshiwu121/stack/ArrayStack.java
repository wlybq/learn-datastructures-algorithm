package cn.chenshiwu121.stack;

public class ArrayStack<T> implements Stack<T> {
	
	private T[] stackArr;
//	private int bottom;
	private int top;
	private int capacity = 10;
	private boolean lenghtLimit = false; // 栈长度是否做限制
	
	public ArrayStack() {
		this(10);
	}
	
	public ArrayStack(boolean lenghtLimit) {
		this(10);
		this.lenghtLimit = lenghtLimit;
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		this.stackArr = (T[])new Object[size];
		top = -1;
	}

	@Override
	public void push(T o) {
		if (!lenghtLimit) ensureCapacity();
		else {
			if (isFull()) throw new RuntimeException("Stack overflow.");
		}
		stackArr[++top] = o;
	}

	@Override
	public T pop() {
		if (isEmpty()) throw new RuntimeException("Stack empty.");
		return stackArr[top--];
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new RuntimeException("Stack empty.");
		return stackArr[top];
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity() {
		if (top >= stackArr.length - 1) {
			T[] newStackArr = (T[])new Object[stackArr.length + capacity];
			System.arraycopy(stackArr, 0, newStackArr, 0, stackArr.length);
			stackArr = newStackArr;
		}
	}

	@Override
	public int size() {
		return top+1;
	}
	
	@Override
	public boolean isFull() {
		if (!lenghtLimit) return false;
		return top == stackArr.length - 1;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "ArrayStack [null]";
		StringBuilder sb = new StringBuilder("ArrayStack [");
		for (int i = top; i >= 0; i--) {
			if (i != 0) {
				sb.append(stackArr[i]).append(", ");
			} else {
				sb.append(stackArr[i]).append("]");
			}
		}
		return sb.toString();
	}

}
