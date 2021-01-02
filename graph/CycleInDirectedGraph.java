package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class CycleInDirectedGraph {
	private static int V; // No. of vertices
	private static LinkedList<Integer> adj[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	public CycleInDirectedGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	private static void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private boolean hasCycle(CycleInDirectedGraph g) {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();

		for (int i = 0; i < V; i++)
			whiteSet.add(i);

		while (whiteSet.size() > 0) {
			int current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int current, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet) {
		moveVertex(current, whiteSet, graySet);
		// if in black set means already explored so continue.
		Iterator<Integer> it = adj[current].iterator();
		while (it.hasNext()) {
			int n = it.next();

			if (blackSet.contains(n)) {
				continue;
			}
			// if in gray set then cycle found.
			if (graySet.contains(n)) {
				return true;
			}
			if (dfs(n, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		moveVertex(current, graySet, blackSet);
		return false;
	}

	private void moveVertex(int current, Set<Integer> from, Set<Integer> to) {
		from.remove(current);
		to.add(current);
	}

	public static void main(String[] args) {
		CycleInDirectedGraph g = new CycleInDirectedGraph(7);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);
		addEdge(3, 4);
		addEdge(4, 1);
		addEdge(4, 5);
		addEdge(5, 6);
		addEdge(6, 4);
		System.out.println(g.hasCycle(g));
	}
}
