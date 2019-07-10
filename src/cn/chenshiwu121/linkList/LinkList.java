package cn.chenshiwu121.linkList;

public interface LinkList<T> {

	void add(T o); // 链表添加方法
	
	void add(int index, T o); // 指定链表下标添加节点
	
	T get(); // 或者链表最后一个节点
	
	T get(int index); // 指定链表下标获取节点
	
	T getByLastIndex(int lastIndex); // 获取倒数第k个节点
	
	void update(int index, T o); // 根据下标修改节点 
	
	boolean remove(int index); // 指定链表下标删除节点
	
	boolean isEmpty(); // 判断链表是否为空
	
	int size(); // 获取链表长度
	
	void reversal(); // 链表反转
	
	String reversalPrint(); // 链表逆序打印
}
