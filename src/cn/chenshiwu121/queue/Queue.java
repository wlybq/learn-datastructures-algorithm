package cn.chenshiwu121.queue;

public interface Queue<T> {
	
	boolean isFull(); // 判断队列是否为满
	
	boolean isEmpty(); // 判断队列是否为空
	
	void addQueue(T o) throws RuntimeException; // 添加元素
	
	T getQueue() throws RuntimeException; // 获取元素
	
	int size(); // 获取有效元素
	
	T head() throws RuntimeException; // 获取头元素

}
