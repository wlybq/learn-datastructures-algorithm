package cn.chenshiwu121.graph;

public class GraphTest {
	
	public static void main(String[] args) {
		String[] vertexs = {"A", "B", "C", "D", "E"};
		Graph<String> graph = new Graph<String>(vertexs.length);
		for (String vertex : vertexs) {
			graph.insertVertex(vertex);
		}
		
		graph.inserEdge(0, 1, 1);
		graph.inserEdge(0, 2, 1);
		graph.inserEdge(1, 2, 1);
		graph.inserEdge(1, 3, 1);
		graph.inserEdge(1, 4, 1);
		
		graph.showGraph();
		graph.dfs();
		System.out.println("\n============");
		graph.bfs();
	}
	
}
