package ads.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class AdjMatGraph implements Graph {
	int[][] adjMat;
	int vertexCount;
	boolean[] isVisited;
	boolean isDirected;

	public AdjMatGraph(int n, boolean isDirected) {
		this.isDirected = isDirected;

		vertexCount = n;
		
		isVisited = new boolean [n];
		adjMat = new int[n][];
		for (int i = 0; i < n; ++i) {
			isVisited[i] = false;

			adjMat[i] = new int [n];
			
			for (int j = 0; j < n; ++j) {
				adjMat[i][j] = 0;
			}
		}
	}

	@Override
	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}

	@Override
	public void addEdge(int u, int v, int w) {
		adjMat[u][v] = w;
		
		if (!isDirected) {
			adjMat[v][u] = w;
		}
	}

	@Override
	public void printBFS(int startVertex) {
		for (int i = 0; i < vertexCount; ++i) {
			isVisited[i] = false;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(startVertex);
		
		while (!q.isEmpty()) {
			int vi = q.remove();
			
			if (!isVisited[vi]) {
				isVisited[vi] = true;
				
				System.out.print(vi + " ");
				
				for (int vj = 0; vj < vertexCount; ++vj) {
					if (adjMat[vi][vj] != 0) {
						if (!isVisited[vj]) {
							q.add(vj);
						}
					}
				}
			}
		}
		System.out.println("");
	}

	@Override
	public void printDFS(int startVertex) {
	}

}
