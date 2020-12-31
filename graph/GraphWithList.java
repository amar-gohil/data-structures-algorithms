package graph;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class GraphWithList {
	private int V;
	private LinkedList<Integer> adj[];

	// it will create graph with v using list
	GraphWithList(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// A utility function to print the adjacency list
	// representation of graph
	void printGraph(LinkedList<Integer>[] adj2) {
		for (int i = 0; i < adj2.length; i++) {
			System.out.println("\nAdjacency list of vertex" + i);
			System.out.print("head");
			while (!adj2[i].isEmpty()) {
				System.out.print(" -> " + adj2[i].poll());
			}
		}
	}

	public static void main(String[] args) {
		GraphWithList graph = new GraphWithList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph(graph.adj);
	}
}
