package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge u v, vertex u comes before v in
 * the ordering. Topological Sorting for a graph is not possible if the graph is
 * not a DAG.
 *
 */
public class TopologicalSorting {
	private static int V; // No. of vertices
	private static LinkedList<Integer> adj[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	public TopologicalSorting(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	private static void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// A recursive function used by topologicalSort
	private static void topologicalSortUtil(int i, Stack<Integer> stack, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			int temp = it.next();
			if (!visited[temp])
				topologicalSortUtil(temp, stack, visited);
		}
		stack.push(i);
	}

	// The function to do Topological Sort.
	// It uses recursive topologicalSortUtil()
	private void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];

		// Call the recursive helper
		// function to store
		// Topological Sort starting
		// from all vertices one by one
		for (int i = 0; i < V; i++)
			if (!visited[i])
				topologicalSortUtil(i, stack, visited);

		// Print contents of stack
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	public static void main(String[] args) {
		TopologicalSorting g = new TopologicalSorting(6);
		addEdge(5, 2);
		addEdge(5, 0);
		addEdge(4, 0);
		addEdge(4, 1);
		addEdge(2, 3);
		addEdge(3, 1);
		System.out.println("Following is a Topological sort of the given graph");
		g.topologicalSort();
	}
}
