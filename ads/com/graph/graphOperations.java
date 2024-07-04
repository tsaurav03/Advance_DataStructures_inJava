package ads.com.graph;

import java.util.ArrayList;
import java.util.List;

import ads.com.graph.UndirectedGraph.EdgeInfo;



public class graphOperations {

	public static void addEdgesToGraph(Graph g) {
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
	}

	public static void testKruskal01() {
		UndirectedGraph g1 = new UndirectedGraph(9);

		g1.addEdge('a' - 'a', 'b' - 'a', 4);
		g1.addEdge('a' - 'a', 'h' - 'a', 8);
		g1.addEdge('b' - 'a', 'c' - 'a', 8);
		g1.addEdge('b' - 'a', 'h' - 'a', 11);
		g1.addEdge('c' - 'a', 'd' - 'a', 7);
		g1.addEdge('c' - 'a', 'f' - 'a', 4);
		g1.addEdge('c' - 'a', 'i' - 'a', 2);
		g1.addEdge('d' - 'a', 'e' - 'a', 9);
		g1.addEdge('d' - 'a', 'f' - 'a', 14);
		g1.addEdge('e' - 'a', 'f' - 'a', 10);
		g1.addEdge('f' - 'a', 'g' - 'a', 2);
		g1.addEdge('g' - 'a', 'h' - 'a', 1);
		g1.addEdge('g' - 'a', 'i' - 'a', 6);
		g1.addEdge('h' - 'a', 'i' - 'a', 7);

		List<EdgeInfo> spanningTreeEdges = new ArrayList<>();
		int minWeight = g1.kruskalMST(spanningTreeEdges);

		System.out.println("Edges in Kruskal's min spanning tree with weight " + minWeight);
		for (EdgeInfo edge : spanningTreeEdges) {
			System.out.println((char)(edge.u + 'a') + " - " + (char)(edge.v + 'a') + " (weight = " + edge.w + ")");
		}
	}

	public static void testKruskal02() {
		UndirectedGraph g1 = new UndirectedGraph(6);

		g1.addEdge('a' - 'a', 'b' - 'a', 1);
		g1.addEdge('a' - 'a', 'd' - 'a', 4);
		g1.addEdge('a' - 'a', 'e' - 'a', 3);
		g1.addEdge('b' - 'a', 'd' - 'a', 4);
		g1.addEdge('b' - 'a', 'e' - 'a', 2);
		g1.addEdge('c' - 'a', 'e' - 'a', 4);
		g1.addEdge('c' - 'a', 'f' - 'a', 5);
		g1.addEdge('d' - 'a', 'e' - 'a', 4);
		g1.addEdge('e' - 'a', 'f' - 'a', 7);

		List<EdgeInfo> spanningTreeEdges = new ArrayList<>();
		int minWeight = g1.kruskalMST(spanningTreeEdges);

		System.out.println("Edges in Kruskal's min spanning tree with weight " + minWeight);
		for (EdgeInfo edge : spanningTreeEdges) {
			System.out.println((char)(edge.u + 'a') + " - " + (char)(edge.v + 'a') + " (weight = " + edge.w + ")");
		}
	}

	public static void testDijkstra01() {
		DirectedGraph g1 = new DirectedGraph(6);

		g1.addEdge(5, 'a' - 'a', 1); // 5 = 's'
		g1.addEdge(5, 'c' - 'a', 2);
		g1.addEdge('a' - 'a', 'b' - 'a', 6);
		g1.addEdge('b' - 'a', 'd' - 'a', 1);
		g1.addEdge('b' - 'a', 'e' - 'a', 2);
		g1.addEdge('c' - 'a', 'a' - 'a', 4);
		g1.addEdge('c' - 'a', 'd' - 'a', 3);
		g1.addEdge('d' - 'a', 'e' - 'a', 1);

		List<Integer> path = new ArrayList<>();
		int pathDistance = g1.dijkstraShortestPath(5, 'e' - 'a', path);

		System.out.println("Shortes path from s to a with distnace " + pathDistance + " is ");
		boolean isFirst = true;
		for (int u : path) {
			if (isFirst) {
				if (u == 5) {
					System.out.print('s');
				} else {
					System.out.print((char)(u + 'a'));
				}
				isFirst = false;
			} else {
				if (u == 5) {
					System.out.print(" -> " + 's');
				} else {
					System.out.print(" -> " + (char)(u + 'a'));
				}
			}
		}
		System.out.println("");
	}

	public static void testDijkstra02() {
		DirectedGraph g1 = new DirectedGraph(7);

		g1.addEdge('a' - 'a', 'b' - 'a', 8);
		g1.addEdge('a' - 'a', 'c' - 'a', 6);
		g1.addEdge('b' - 'a', 'd' - 'a', 10);
		g1.addEdge('c' - 'a', 'd' - 'a', 15);
		g1.addEdge('c' - 'a', 'e' - 'a', 9);
		g1.addEdge('d' - 'a', 'e' - 'a', 14);
		g1.addEdge('d' - 'a', 'f' - 'a', 4);
		g1.addEdge('e' - 'a', 'f' - 'a', 13);
		g1.addEdge('e' - 'a', 'g' - 'a', 17);
		g1.addEdge('f' - 'a', 'g' - 'a', 7);

		List<Integer> path = new ArrayList<>();
		int pathDistance = g1.dijkstraShortestPath('a' - 'a', 'g' - 'a', path);

		System.out.println("Shortes path from s to a with distnace " + pathDistance + " is ");
		boolean isFirst = true;
		for (int u : path) {
			if (isFirst) {
				System.out.print((char)(u + 'a'));
				isFirst = false;
			} else {
				System.out.print(" -> " + (char)(u + 'a'));
			}
		}
		System.out.println("");
	}

	public static void testTraversals() {
		//Graph g = new AdjMatGraph(4, false);
		Graph g = new AdjListGraph(4, false);
		
		addEdgesToGraph(g);
		
		System.out.println("BFS ...");
		g.printBFS(0);

		System.out.println("DFS ...");
		g.printDFS(0);
	}

	public static void main(String[] args) {
		//testKruskal02();
		testDijkstra02();
	}

}
