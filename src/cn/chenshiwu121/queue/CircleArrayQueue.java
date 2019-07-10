package cn.chenshiwu121.queue;

public class CircleArrayQueue<T> implements Queue<T> {
	
	private T[] arrs;
	private int front;
	private int rear;
	private int maxSize;
	
	public CircleArrayQueue() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public CircleArrayQueue(int size) {
		maxSize = size;
		arrs = (T[])new Object[size];
	}
	
	@Override
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	
	@Override
	public void addQueue(T o) throws RuntimeException {
		if (isFull()) throw new RuntimeException("The queue is full.");
		arrs[rear] = o;
		rear = (rear + 1) % maxSize;
	}
	
	@Override
	public T getQueue() throws RuntimeException {
		if (isEmpty()) throw new RuntimeException("The queue is empty.");
		T o = arrs[front];
		front = (front + 1) % maxSize;
		return o;
	}
	
	@Override
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	@Override
	public T head() throws RuntimeException {
		if (isEmpty()) throw new RuntimeException("The queue is empty.");
		return arrs[front];
	}

	@Override
	public String toString() {
		if (isEmpty()) return "[]";
		StringBuilder sb = new StringBuilder();
		for (int i = front; i < front + size(); i++) {
			int val = i % maxSize;
			sb.append("arr[").append(val).append("]=").append(arrs[val]).append("\n");
		}
		return sb.toString();
	}
}
