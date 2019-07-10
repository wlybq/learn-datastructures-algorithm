package cn.chenshiwu121.stack;

public interface Stack<T> {
	
	void push(T o); // 压栈
	
	T pop(); // 出栈
	
	T peek(); // 查看栈顶元素
	
	int size(); // 栈个数
	
	boolean isFull(); // 栈是否满
	
	boolean isEmpty(); // 栈是否为空
}
