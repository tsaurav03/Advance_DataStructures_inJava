package ads.com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UndirectedGraph {
	int[][] adjMat;
	int vertexCount;

	public UndirectedGraph(int n) {
		vertexCount = n;
		
		adjMat = new int[vertexCount][];
		for (int i = 0; i < vertexCount; ++i) {
			adjMat[i] = new int[vertexCount];
			
			for (int j = 0; j < vertexCount; ++j) {
				adjMat[i][j] = 0;
			}
		}
	}

	public void addEdge(int u, int v, int w) {
		adjMat[u][v] = w;
		adjMat[v][u] = w;
	}

	class EdgeInfo implements Comparable<EdgeInfo> {
		int u;
		int v;
		int w;

		EdgeInfo(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(EdgeInfo o) {
			return w - o.w;
		}
	}

	class QuickFind {
		private int[] ids;

		public QuickFind(int n) {
			ids = new int [n];
			for (int i = 0; i < n; ++i) {
				ids[i] = i;
			}
		}

		public void union(int p, int q) {
			if (isConnected(p, q)) {
				return;
			}

			int pid = ids[p];
			int qid = ids[q];
			// Make all p id's to q id's
			for (int i = 0; i < ids.length; ++i) {
				if (ids[i] == pid) {
					ids[i] = qid;
				}
			}
		}

		public boolean isConnected(int p, int q) {
			return ids[p] == ids[q];
		}
	}

	private List<EdgeInfo> getAllEdges() {
		List<EdgeInfo> edges = new ArrayList<>();

		for (int i = 0; i < vertexCount; ++i) {
			/*
			 * j = i + 1 => Ignores values in lower triangle of adjacency matrix.
			 * In adjacency matrix for undirected graph, lower triangle is mirror
			 * image of upper triangle.
			 */
			for (int j = i + 1; j < vertexCount; ++j) {
				if (adjMat[i][j] != 0) {
					edges.add(new EdgeInfo(i, j, adjMat[i][j]));
				}
			}
		}

		return edges;
	}

	public int kruskalMST(List<EdgeInfo> spanningTreeEdges) {
		List<EdgeInfo> edges = getAllEdges();
		Collections.sort(edges);

		int spanningTreeWeight = 0;
		QuickFind qf = new QuickFind(vertexCount);

		for (int count = 0, i = 0; count != (vertexCount - 1); ++i) {
			int u = edges.get(i).u;
			int v = edges.get(i).v;

			if (!qf.isConnected(u, v)) {
				qf.union(u, v);
				spanningTreeEdges.add(edges.get(i));
				System.out.println("Added " + (char)(u + 'a') + " - " + (char)(v + 'a'));
				++count;
				spanningTreeWeight += edges.get(i).w;
			} else {
				System.out.println("Cycle due to " + (char)(u + 'a') + " - " + (char)(v + 'a'));
			}
		}
		
		return spanningTreeWeight;
	}
}
