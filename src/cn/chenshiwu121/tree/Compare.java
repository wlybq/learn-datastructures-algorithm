package cn.chenshiwu121.tree;

public interface Compare<T> {
	default boolean judge(T obj) {
		return false;
	}
}
