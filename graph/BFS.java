package com.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfsTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Node,Boolean> visited= new HashMap<Node, Boolean>();
        visited.put(root,true);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
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
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node root = graph.getGraph();
        bfsTraversal(root);
    }
}
