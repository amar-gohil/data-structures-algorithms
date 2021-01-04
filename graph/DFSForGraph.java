package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSForGraph {

	private static int V; // No. of vertices
	private static LinkedList<Integer> adj[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	public DFSForGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	private static void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// DFS with Recursive approach
	private static void DFSUtil(int root, boolean[] visited) {
		visited[root] = true;
		System.out.print(root + " ");

		Iterator<Integer> it = adj[root].iterator();
		while (it.hasNext()) {
			int temp = it.next();
			if (!visited[temp]) {
				DFSUtil(temp, visited);
			}
		}
	}

	private void DFS(int root) {
		boolean[] visited = new boolean[V];

		// This will happen by handling a corner case.
		// you can call direct DFSUtil(root, visited)
		// All the vertices may not be reachable from a given vertex as in the
		// case of a Disconnected graph
		for (int i = 0; i < V; ++i)
			if (visited[i] == false)
				DFSUtil(i, visited);
	}

	// DFS with stack DS
	private void DFSWithStackUtil(int root, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			int s = stack.pop();
			if (!visited[s]) {
				System.out.print(s + " ");
				visited[s] = true;
			}
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					stack.add(n);
				}
			}
		}
	}

	private void DFSWithStack(int root) {
		boolean[] visited = new boolean[V];

		// This will happen by handling a corner case.
		// you can call direct DFSUtil(root, visited)
		// All the vertices may not be reachable from a given vertex as in the
		// case of a Disconnected graph
		for (int i = 0; i < V; ++i)
			if (visited[i] == false)
				DFSWithStackUtil(i, visited);
	}

	public static void main(String[] args) {
		DFSForGraph g = new DFSForGraph(4);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);

		System.out.println("Following is deapth First Traversal " + "(starting from vertex 2)");
		g.DFS(2);
		System.out.println();
		System.out.println("Following is deapth First Traversal with STACK DS " + "(starting from vertex 2)");
		g.DFSWithStack(2);
	}
}
