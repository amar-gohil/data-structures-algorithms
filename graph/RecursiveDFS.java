
package com.datastructure.graph;

import java.util.HashMap;

public class RecursiveDFS {
    static HashMap<Node,Boolean> visited= new HashMap<Node, Boolean>();

    static void recursiveDfsTraversal(Node root){
        visited.put(root,true);
        System.out.print(root.val + " | ");
        for (Node neighbor: root.neighbors) {
            if(visited.get(neighbor) == null){
                recursiveDfsTraversal(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node root = graph.getGraph();
        recursiveDfsTraversal(root);
    }
}
