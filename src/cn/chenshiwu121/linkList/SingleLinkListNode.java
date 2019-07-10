package cn.chenshiwu121.linkList;

public class SingleLinkListNode<T> {
	
	private T obj;
	private SingleLinkListNode<T> next;
	
	public SingleLinkListNode() {
		super();
	}
	
	public SingleLinkListNode(T obj) {
		super();
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public SingleLinkListNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return obj.toString();
	}
	
}
