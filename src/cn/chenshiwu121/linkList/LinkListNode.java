package cn.chenshiwu121.linkList;

public class LinkListNode<T> {
	
	private LinkListNode<T> prev;
	private T obj;
	private LinkListNode<T> next;
	
	public LinkListNode() {
		super();
	}
	
	public LinkListNode(T obj) {
		super();
		this.obj = obj;
	}

	public LinkListNode(LinkListNode<T> prev, T obj, LinkListNode<T> next) {
		super();
		this.prev = prev;
		this.obj = obj;
		this.next = next;
	}

	public LinkListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(LinkListNode<T> prev) {
		this.prev = prev;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public LinkListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return obj.toString();
	}
}
