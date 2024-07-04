package ads.com.graph;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
	int[][] adjMat;
	int vertexCount;

	public DirectedGraph(int n) {
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
	}

	private Integer getVertexWithSmallestDistance(List<Integer> vertexList, int[] currentDistance) {
		Integer result = vertexList.get(0);
		Iterator<Integer> it = vertexList.iterator();

		while (it.hasNext()) {
			int current = it.next();
			if (currentDistance[current] < currentDistance[result]) {
				result = current;
			}
		}

		return result;
	}
	public int dijkstraShortestPath(int startVertex, int endVertex, List<Integer> path) {
		int[] predecessor = new int [vertexCount];
		int[] currentDistance = new int [vertexCount];
		List<Integer> vertexList = new LinkedList<>();
		for (int i = 0; i < vertexCount; ++i) {
			predecessor[i] = -1;
			currentDistance[i] = Integer.MAX_VALUE;
			vertexList.add(i);
		}
		currentDistance[startVertex] = 0;

		while (!vertexList.isEmpty()) {
			Integer u = getVertexWithSmallestDistance(vertexList, currentDistance);
			vertexList.remove(u);

			for (int v = 0; v < vertexCount; ++v) {
				if (adjMat[u][v] != 0) {
					int distanceToVviaU = currentDistance[u] + adjMat[u][v];
					
					if (distanceToVviaU < currentDistance[v]) {
						currentDistance[v] = distanceToVviaU;
						predecessor[v] = u;
					}
				}
			}
		}

		int current = endVertex;
		path.add(endVertex);
		while (current != startVertex) {
			path.add(predecessor[current]);
			current = predecessor[current];
		}
		Collections.reverse(path);

		return currentDistance[endVertex];
	}
}
