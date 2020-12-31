package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSForGraph {
	private static int V; // No. of vertices
	private static LinkedList<Integer> adj[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	public BFSForGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	private static void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private void BFS(int root) {
		boolean[] visited = new boolean[V];
		visited[root] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	};

	public static void main(String[] args) {
		BFSForGraph g = new BFSForGraph(4);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);
	}
}
