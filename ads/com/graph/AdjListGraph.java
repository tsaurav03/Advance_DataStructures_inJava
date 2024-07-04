package ads.com.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph implements Graph {
	class EdgeInfo {
		int adjVertex;
		int weight;
		
		public EdgeInfo(int v, int w) {
			adjVertex = v;
			weight = w;
		}
	}

	List<List<EdgeInfo>> adjList;
	int vertexCount;
	boolean isDirected;
	boolean[] isVisited;

	public AdjListGraph(int n, boolean isDirected) {
		this.isDirected = isDirected;
		
		vertexCount = n;
		
		adjList = new ArrayList<>(n);
		isVisited = new boolean [n];
		
		for (int i = 0; i < n; ++i) {
			isVisited[i] = false;

			adjList.add(new ArrayList<>());
		}
	}
	@Override
	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}

	@Override
	public void addEdge(int u, int v, int w) {
		adjList.get(u).add(new EdgeInfo(v, w));

		if (!isDirected) {
			adjList.get(v).add(new EdgeInfo(u, w));
		}
	}


	@Override
	public void printBFS(int startVertex) {
	}

	private void dfsHelper(int startVertex) {
		if (isVisited[startVertex]) {
			return;
		}
		
		isVisited[startVertex] = true;
		System.out.print(startVertex + " ");
		
		for (EdgeInfo edgeInfo : adjList.get(startVertex)) {
			if (!isVisited[edgeInfo.adjVertex]) {
				dfsHelper(edgeInfo.adjVertex);
			}
		}
	}
	@Override
	public void printDFS(int startVertex) {
		for (int i = 0; i < vertexCount; ++i) {
			isVisited[i] = false;
		}
		
		dfsHelper(startVertex);
		System.out.println("");
	}

}
