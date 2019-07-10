package cn.chenshiwu121.linkList;

import java.util.Stack;

public class SimpleLinkList<T> implements LinkList<T> {
	
	private LinkListNode<T> first;

	public SimpleLinkList() {
		super();
	}

	public SimpleLinkList(LinkListNode<T> first) {
		super();
		this.first = first;
	}
	
	private LinkListNode<T> getNodeByIndex(int index) {
		int n = 0;
		LinkListNode<T> curr = first;
		while(true) {
			if (curr == null || n == index) break;
			curr = curr.getNext();
			n++;
		}
		if (n != index) {
			return null;
		}
		return curr;
	}
	
	private LinkListNode<T> getLastNode() {
		LinkListNode<T> curr = first;
		while(true) {
			if (curr == null || curr.getNext() == null) break;
			curr = curr.getNext();
		}
		return curr;
	}

	@Override
	public void add(T o) {
		LinkListNode<T> curr = getLastNode();
		if (curr == null) {
			first = new LinkListNode<T>(o);
		} else {
			LinkListNode<T> lastNode = new LinkListNode<T>(o);
			curr.setNext(lastNode);
			lastNode.setPrev(curr);
		}
	}
	
	@Override
	public void add(int index, T o) {
		if(isEmpty()) add(o);
		else {
			LinkListNode<T> node = getNodeByIndex(index);
			if (node != null) {
				LinkListNode<T> newNode = new LinkListNode<T>(o);
				LinkListNode<T> prev = node.getPrev();
				if (prev == null) {
					first = newNode;
					newNode.setNext(node);
				} else {
					prev.setNext(newNode);
					newNode.setPrev(prev);
					newNode.setNext(node);
				}
				node.setPrev(newNode);
			}
		}
	}

	@Override
	public T get() {
		LinkListNode<T> node = getLastNode();
		return node != null ? node.getObj() : null;
	}

	@Override
	public T get(int index) {
		if (isEmpty() || index+1 > size()) return null;
		LinkListNode<T> node = getNodeByIndex(index);
		return node != null ? node.getObj() : null;
	}

	@Override
	public void update(int index, T o) {
		LinkListNode<T> node = getNodeByIndex(index);
		if (node != null) {
			node.setObj(o);
		}
	}

	@Override
	public boolean remove(int index) {
		if (isEmpty() || index >= size()) return false;
		LinkListNode<T> node = getNodeByIndex(index);
		LinkListNode<T> prev = node.getPrev();
		LinkListNode<T> next = node.getNext();
		if (node == first) first = next;
		else {
			if (prev != null) prev.setNext(next);
			if (next != null) next.setPrev(prev);
		}
		node = null;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		int n = 0;
		LinkListNode<T> curr = first;
		if (curr == null) return n;
		while(true) {
			if (curr == null) break;
			curr = curr.getNext();
			n++;
		}
		return n;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "SimpleLinkList [null]";
		StringBuilder sb = new StringBuilder("SimpleLinkList [\n");
		int len = size();
		for (int i = 0; i < len; i++) {
			T o = get(i);
			sb.append("\t").append(o.toString()).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public void reversal() {
		if (isEmpty() || first.getNext() == null) return;
		LinkListNode<T> temp = new LinkListNode<T>();
		temp.setNext(first);
		first.setPrev(temp);
		LinkListNode<T> curr = first.getNext();
		first.setNext(null);
		while(curr != null) {
			LinkListNode<T> node = curr.getNext();
			curr.setNext(temp.getNext());
			temp.getNext().setPrev(curr);
			temp.setNext(curr);
			curr.setPrev(temp);
			curr = node;
		}
		first = temp.getNext();
	}

	@Override
	public T getByLastIndex(int lastIndex) {
		int lenght = size();
		if (lastIndex <= 0 || lastIndex > lenght) return null;
		return get(lenght - lastIndex);
	}

	@Override
	public String reversalPrint() {
		if (isEmpty()) return "SimpleLinkList [null]";
		LinkListNode<T> curr = first;
		Stack<T> st = new Stack<T>();
		StringBuilder sb = new StringBuilder("SimpleLinkList [\n");
		while (curr != null) {
			st.push(curr.getObj());
			curr = curr.getNext();
		}
		while (st.size() > 0) {
			sb.append("\t").append(st.pop().toString()).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

}
