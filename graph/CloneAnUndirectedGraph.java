package com.datastructure.graph;

import java.util.*;

public class CloneAnUndirectedGraph {
    public static void bfs(Node source) {
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        HashMap<Node, Boolean> visit =
                new HashMap<Node, Boolean>();
        visit.put(source, true);
        while (!q.isEmpty()) {
            Node u = q.poll();
            System.out.print(u.val + " ");
            System.out.print(u + " | ");
            if (u.neighbors != null) {
                for (Node n : u.neighbors) {
                    if (!visit.containsKey(n)) {
                        q.add(n);
                        visit.put(n, true);
                    }
                }
            }
        }
    }

    public static Node graphClone(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Map<Node, Node> hm = new HashMap();
        hm.put(root, new Node(root.val));
        while (!q.isEmpty()) {
            Node temp = q.poll();
            Node cloneNodeU = hm.get(temp);
            if (temp.neighbors != null) {
                for (Node nNode : temp.neighbors) {
                    Node cloneNodeG = hm.get(nNode);
                    if (cloneNodeG == null) {
                        q.add(nNode);
                        cloneNodeG = new Node(nNode.val);
                        hm.put(nNode, cloneNodeG);
                    }
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }
        return hm.get(root);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> v = new ArrayList();
        v.add(node2);
        v.add(node4);
        node1.neighbors = v;
        v = new ArrayList();
        v.add(node1);
        v.add(node3);
        node2.neighbors = v;
        v = new ArrayList<Node>();
        v.add(node2);
        v.add(node4);
        node3.neighbors = v;
        v = new ArrayList<Node>();
        v.add(node3);
        v.add(node1);
        node4.neighbors = v;
        bfs(node1);
        graphClone(node1);
        System.out.println();
        bfs(graphClone(node1));
    }
}
