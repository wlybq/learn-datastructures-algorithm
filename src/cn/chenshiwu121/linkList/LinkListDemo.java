package cn.chenshiwu121.linkList;

public class LinkListDemo {

	public static void main(String[] args) {
		LinkList<Hero> list = new CircleSingleLinkList<>();
		
		list.add(new Hero("宋江", 34, "总督兵马大元帅"));
		list.add(new Hero("吴用", 28, "掌管机密正军师"));
		list.add(new Hero("鲁智深", 27, "步军十麒麟之首兼步军大都督领南山二关守尉主将"));
		list.add(new Hero("李逵", 32, "歩军十麒麟之五兼横冲营指挥领北山关隘守御副将"));
		list.add(3, new Hero("卢俊义", 29, "总督兵马副元帅"));
		
		

//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		list.remove(1);
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.isEmpty());
//		list.remove(0);
//		System.out.println(list.get());
//		System.out.println(list);
//		list.update(1, new Hero("卢小俊", 18, "总督兵马副元帅~~"));
//		System.out.println(list.size());
//		System.out.println(list.getByLastIndex(2));
		System.out.println(list);
		list.reversal();
		System.out.println(list);
//		System.out.println(list.reversalPrint());
	}

}
