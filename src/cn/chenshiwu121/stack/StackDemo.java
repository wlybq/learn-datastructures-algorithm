package cn.chenshiwu121.stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> st = new ArrayStack<Integer>(true);
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.push(10);
		st.pop();
		st.push(11);
		
//		System.out.println(st);
		
		while (st.size() > 0) {
			System.out.println(st.pop());
		}
	}

}
