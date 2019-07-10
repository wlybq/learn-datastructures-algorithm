package cn.chenshiwu121.linkList;

import java.util.Stack;

public class CircleSingleLinkList<T> implements LinkList<T> {
	
	private SingleLinkListNode<T> first;
	private int count;

	public CircleSingleLinkList() {
		super();
	}
	
	public CircleSingleLinkList(SingleLinkListNode<T> first) {
		super();
		setFirst(first);
	}
	
	private void setFirst(SingleLinkListNode<T> first) {
		this.first = first;
		first.setNext(first);
		count++;
	}
	
	private boolean checkIndexEffic(int index) {
		return 	isEmpty() ? false : 
				index + 1 > count ? true : false; 
	}
	
	private SingleLinkListNode<T> getNodeByIndex(int index) {
		if (index < 0) index += count;
		int n = 0;
		SingleLinkListNode<T> curr = first;
		while(n < count) {
			if (curr == null || n == index) break;
			curr = curr.getNext();
			n++;
		}
		return curr;
	}
	
	private SingleLinkListNode<T> getLastNode() {
		if (isEmpty()) return null;
		SingleLinkListNode<T> curr = first;
		int n = 0;
		while(n++ < count-1) {
			curr = curr.getNext();
		}
		return curr;
	}

	@Override
	public void add(T o) {
		SingleLinkListNode<T> node = getLastNode();
		if (node == null) {
			setFirst(new SingleLinkListNode<T>(o));
		} else {
			SingleLinkListNode<T> newNode = new SingleLinkListNode<T>(o);
			newNode.setNext(first);
			node.setNext(newNode);
			count++;
		}
	}

	@Override
	public void add(int index, T o) {
		if (isEmpty()) add(o);
		else {
			SingleLinkListNode<T> node;
			SingleLinkListNode<T> newNode = new SingleLinkListNode<T>(o);
			if (index <= 0) {
				node = getLastNode();
				newNode.setNext(first);
				node.setNext(newNode);
				first = newNode;
			} else {
				node = getNodeByIndex(index-1);
				newNode.setNext(node.getNext());
				node.setNext(newNode);
			}
			count++;
		}
	}

	@Override
	public T get() {
		SingleLinkListNode<T> node = getLastNode();
		return node != null ? node.getObj() : null;
	}

	@Override
	public T get(int index) {
		if (checkIndexEffic(index)) return null;
		SingleLinkListNode<T> node = getNodeByIndex(index);
		return node != null ? node.getObj() : null;
	}

	@Override
	public T getByLastIndex(int lastIndex) {
		if (checkIndexEffic(lastIndex-1)) return null;
		SingleLinkListNode<T> node = getNodeByIndex(count - lastIndex);
		return node != null ? node.getObj() : null;
	}

	@Override
	public void update(int index, T o) {
		if (checkIndexEffic(index)) return;
		SingleLinkListNode<T> node = getNodeByIndex(index);
		node.setObj(o);
	}

	@Override
	public boolean remove(int index) {
		if (checkIndexEffic(index)) return false;
		SingleLinkListNode<T> node = getNodeByIndex(index-1);
		if (index == 0) {
			first = node.getNext().getNext();
		}
		node.setNext(node.getNext().getNext());
		count--;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void reversal() {
		if (count < 2) return;
		SingleLinkListNode<T> temp = new SingleLinkListNode<T>();
		temp.setNext(first);
		SingleLinkListNode<T> curr = first.getNext();
		int n = 0;
		while (n++ < count-1) {
			SingleLinkListNode<T> node = curr.getNext();
			curr.setNext(temp.getNext());
			temp.setNext(curr);
			curr = node;
		}
		first.setNext(temp.getNext());
		first = temp.getNext();
	}

	@Override
	public String reversalPrint() {
		if (isEmpty()) return "SimpleLinkList [null]";
		SingleLinkListNode<T> curr = first;
		Stack<T> st = new Stack<T>();
		StringBuilder sb = new StringBuilder("SimpleLinkList [\n");
		int n = 0;
		while (n++ < count) {
			st.push(curr.getObj());
			curr = curr.getNext();
		}
		while (st.size() > 0) {
			sb.append("\t").append(st.pop().toString()).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		if (isEmpty()) return "CircleSingleLinkList [null]";
		StringBuilder sb = new StringBuilder("SimpleLinkList [\n");
		SingleLinkListNode<T> curr = first;
		int n = 0;
		while(n++ < count) {
			sb.append("\t").append(curr.getObj().toString()).append("\n");
			curr = curr.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	
	// 设置下标index的节点为头节点
	public void setFirstByIndex(int index) {
		if (checkIndexEffic(index)) return;
		first = getNodeByIndex(index);
	}
	
}
