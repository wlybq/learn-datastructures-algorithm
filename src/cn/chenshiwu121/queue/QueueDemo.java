package cn.chenshiwu121.queue;

public class QueueDemo {
	
	public static void main(String[] args) {
		Queue<String> que = new CircleArrayQueue<String>(4);
		que.addQueue("陈十五");
		que.addQueue("陈十六");
		que.addQueue("陈十七");
		que.getQueue();
		que.addQueue("陈十八");
//		que.getQueue();
//		que.getQueue();
		System.out.println(que + ", lenght:" + que.size());
	}
	
}
