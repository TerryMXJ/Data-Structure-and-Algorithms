package graph.minimal_spanning_tree;

import java.util.Comparator;
import java.util.PriorityQueue;

class Edge{
    int weight;
    int start, end;
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge e1, Edge e2) {
        return e1.weight-e2.weight;
    }
}

public class Kruskal {

    public static void main(String[] args) {
        int[][] graph = {
                {Integer.MAX_VALUE,5,7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,2},
                {5,Integer.MAX_VALUE,Integer.MAX_VALUE,9,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
                {7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,8,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,9,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,8,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,5,4},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,5,Integer.MAX_VALUE,6},
                {2,3,Integer.MAX_VALUE,Integer.MAX_VALUE,4,6,Integer.MAX_VALUE}
        };

        kruskal(graph);
    }

    private static void kruskal(int[][] graph) {
        // build heap tree
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != Integer.MAX_VALUE) {
                    Edge e = new Edge(i, j, graph[i][j]);
                    pq.offer(e);
                }
            }
        }
        // using disjoint-set to add edge
        int sum = 0;
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            parent[i] = -1;
        }
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int start_root = find(parent, e.start);
            int end_root = find(parent, e.end);
            if (start_root != end_root) {
                System.out.println("add edge <" + e.start + "," + e.end + ">");
                union(parent, e.start, e.end);
                sum += e.weight;
            }
        }
        System.out.println("weight of MST: " + sum);
    }

    private static int find(int[] parent, int i) {
        while (parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }

    private static void union(int[] parent, int p, int q) {
        int p_root = find(parent, p);
        int q_root = find(parent, q);
        if (p_root == q_root) return;
        else {
            parent[q_root] = p_root;
        }
    }



}
