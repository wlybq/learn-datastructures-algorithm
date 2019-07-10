package cn.chenshiwu121.linkList;

public class Josephu {

	public static void main(String[] args) {
		LinkList<Hero> list = new CircleSingleLinkList<Hero>();
		LinkList<Hero> exList = new SimpleLinkList<Hero>();
		
		list.add(new Hero("宋江", 34, "总督兵马大元帅"));
		list.add(new Hero("卢俊义", 29, "总督兵马副元帅"));
		list.add(new Hero("吴用", 28, "掌管机密正军师"));
		list.add(new Hero("鲁智深", 27, "步军十麒麟之首兼步军大都督领南山二关守尉主将"));
		list.add(new Hero("李逵", 32, "歩军十麒麟之五兼横冲营指挥领北山关隘守御副将"));
		list.add(new Hero("林冲", 32, "豹子头"));
		
		// 宋江 卢俊义 吴用 鲁智深 李逵 林冲
		// 林冲 宋江 卢俊义 吴用 鲁智深 
		// 林冲 宋江 卢俊义 吴用
		// 宋江 卢俊义 吴用
		// 吴用 宋江
		// 宋江
		
		int i = 0;
		while(list.size() > 1) {
			i = 0;
			while (true) {
				i++;
				if (i == 5) {
					int n = i % list.size();
					((CircleSingleLinkList<Hero>)list).setFirstByIndex(n);
					exList.add(list.get(-1));
					list.remove(-1);
					break;
				}
			}
		}
		
		System.out.println(list.get(0));
		System.out.println(exList);

	}

}
