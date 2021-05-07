package com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public Node getGraph(){
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
        return node1;
    }
}
