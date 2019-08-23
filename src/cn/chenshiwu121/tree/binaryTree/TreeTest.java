package cn.chenshiwu121.tree.binaryTree;

import cn.chenshiwu121.tree.Hero;
import cn.chenshiwu121.tree.Compare;

public class TreeTest {
	public static void main(String[] args) {
		BinaryTree<Hero> binaryTree = new BinaryTree<Hero>();
		Hero hero1 = new Hero(1, "宋江");
		Hero hero2 = new Hero(2, "吴用");
		Hero hero3 = new Hero(3, "卢俊义");
		Hero hero4 = new Hero(4, "林冲");
		Hero hero5 = new Hero(5, "关胜");
		
		TreeNode<Hero> root = new TreeNode<Hero>(hero1);
		TreeNode<Hero> node2 = new TreeNode<Hero>(hero2);
		TreeNode<Hero> node3 = new TreeNode<Hero>(hero3);
		TreeNode<Hero> node4 = new TreeNode<Hero>(hero4);
		TreeNode<Hero> node5 = new TreeNode<Hero>(hero5);
		
		root.setLeft(node2);
		root.setRight(node3);
		node3.setLeft(node5);
		node3.setRight(node4);
		
		binaryTree.setRoot(root);
		
//		binaryTree.preOrder();
//		System.out.println("======================");
//		binaryTree.midOrder();
//		System.out.println("======================");
//		binaryTree.rearOrder();
		
//		Hero temp;
//		temp = binaryTree.preSearch(new Compare<Hero>() {
//			@Override
//			public boolean judge(Hero obj) {
//				return obj.getNo() == 3;
//			}
//		});
//		System.out.println(temp);
//		temp = binaryTree.midSearch(new Compare<Hero>() {
//			@Override
//			public boolean judge(Hero obj) {
//				return obj.getNo() == 1;
//			}
//		});
//		System.out.println(temp);
//		temp = binaryTree.rearSearch(new Compare<Hero>() {
//			@Override
//			public boolean judge(Hero obj) {
//				return obj.getNo() == 2;
//			}
//		});
//		System.out.println(temp);
		
		binaryTree.preOrder();
		binaryTree.delNode(new Compare<Hero>() {
			@Override
			public boolean judge(Hero obj) {
				return obj.getNo() == 3;
			}
		});
		System.out.println("===========");
		binaryTree.preOrder();
	}
}
