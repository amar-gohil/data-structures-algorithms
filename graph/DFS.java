package com.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void dfsTraversal(Node root){
        Stack<Node> queue = new Stack<>();
        queue.add(root);
        HashMap<Node,Boolean> visited= new HashMap<Node, Boolean>();
        visited.put(root,true);
        while (!queue.isEmpty()){
            Node temp = queue.pop();
            System.out.print(temp.val + " | ");
            if (temp.neighbors != null) {
                for (Node neighbor: temp.neighbors) {
                    if(!visited.containsKey(neighbor)) {
                        queue.add(neighbor);
                        visited.put(neighbor,true);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node root = graph.getGraph();
        dfsTraversal(root);
    }
}
