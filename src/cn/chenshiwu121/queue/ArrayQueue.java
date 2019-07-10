package cn.chenshiwu121.queue;

public class ArrayQueue<T> implements Queue<T> {
	
	private T[] arrs;
	private int front = -1;
	private int rear = -1;
	private static int capacitySize = 10;
	
	public ArrayQueue() {
		this(capacitySize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		capacitySize = size;
		arrs = (T[])new Object[size];
	}
	
	private void ensureCapacity() {
		if (rear == arrs.length - 1) {
			int effectiveSize = size();
			@SuppressWarnings("unchecked")
			T[] newArrs = (T[])new Object[effectiveSize + capacitySize];
			System.arraycopy(arrs, 0, newArrs, 0, effectiveSize);
			front = -1;
			arrs = newArrs;
		}
	}
	
	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void addQueue(T o) throws RuntimeException {
		ensureCapacity();
		arrs[++rear] = o;
	}

	@Override
	public T getQueue() throws RuntimeException {
		if (isEmpty()) return null;
		return arrs[++front];
	}

	@Override
	public int size() {
		return rear - front;
	}

	@Override
	public T head() throws RuntimeException {
		return arrs[front];
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = front + 1; i <= rear; i++) {
				if (i != rear) {
					sb.append((i % arrs.length)+"="+arrs[i]+", ");
				} else {
					sb.append((i % arrs.length)+"="+arrs[i]+"]");
				}
			}
			return sb.toString();
		}
	}
}


