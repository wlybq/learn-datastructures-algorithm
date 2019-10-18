package cn.chenshiwu121.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph<T> {
	private ArrayList<T> vertexList;
	private int[][] edges;
	private int numOfEdges;
	private boolean[] isVisited;
	
	public Graph(int n) {
		vertexList = new ArrayList<T>(n);
		edges = new int[n][n];
	}
	
	public void insertVertex(T o) {
		vertexList.add(o);
	}
	
	public void inserEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	public int getLengthOfVertex() {
		return vertexList.size();
	}
	
	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	
	public T getVertex(int n) {
		return vertexList.get(n);
	}
	
	public void showGraph() {
		for (int[] is : edges) {
			System.out.println(Arrays.toString(is));
		}
	}
	
	// 取第一个邻接节点的下标W
	// 有就返回第一个邻接节点的下标
	// 没有就返回-1
	public int getFirstNeighbor(int index) {
		int len = getLengthOfVertex();
		for (int i = 0; i < len; i++) {
			if (edges[index][i] > 0) return i;
		}
		return -1;
	}
	
	// 取某一行的指定下标开始后的一下个邻接节点的下标
	// 有就返回下一个邻接节点的下标
	// 没有就返回-1
	public int getNextNeighbor(int v1, int v2) {
		int len = getLengthOfVertex();
		for (int i = v2 + 1; i < len; i++) {
			if (edges[v1][i] > 0) return i;
		}
		return -1;
	}
	
	// 深度优先遍历图
	// 依次遍历每一行
	public void dfs() {
		int len = getLengthOfVertex();
		isVisited = new boolean[len];
		for (int i = 0; i < len; i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);	
			}
		}
	}
	
	// 遍历一行内未被访问过的节点
	protected void dfs(boolean[] isVisited, int i) {
		System.out.print(getVertex(i) + "->");
		isVisited[i] = true;
		int rowFirstNodeIndex = getFirstNeighbor(i);
		while (rowFirstNodeIndex != -1) {
			if (!isVisited[rowFirstNodeIndex]) {
				dfs(isVisited, rowFirstNodeIndex);
			}
			rowFirstNodeIndex = getNextNeighbor(i, rowFirstNodeIndex);
		}
	}
	
	// 广度优先遍历图
	// 依次遍历每一行
	public void bfs() {
		int len = getLengthOfVertex();
		isVisited = new boolean[len];
		for (int i = 0; i < len; i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
	
	// 遍历一行内未被访问过的节点
	public void bfs(boolean[] isVisited, int i) {
		int u, m;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		System.out.print(getVertex(i) + "->");
		isVisited[i] = true;
		queue.addLast(i);
		while(!queue.isEmpty()) {
			u = queue.removeFirst();
			m = getFirstNeighbor(u);
			while(m != -1) {
				if (!isVisited[m]) {
					System.out.print(getVertex(m) + "->");
					isVisited[m] = true;
					queue.addLast(m);
				}
				m = getNextNeighbor(u, m);
			}
		}
	}
}
