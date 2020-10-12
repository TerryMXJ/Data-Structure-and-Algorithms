package graph.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static int[][] graph = {
            {0,1,1,1,0},
            {1,0,1,1,1},
            {1,1,0,1,0},
            {1,1,1,0,1},
            {0,1,0,1,0}
    };

    static boolean[] visited = new boolean[graph.length];

    public static void main(String[] args) {
        // initialize
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
        }
        // traverse all the vertex
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) bfs_traversal(i);
        }
    }

    private static void bfs_traversal(int i) {
        // visit vertex i
        System.out.println("visit " + (i+1));
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            // dequeue and add the adjacent vertex to the queue
            int vex = queue.poll();
            for (int j = 0; j < graph.length; j++) {
                if (graph[vex][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.println("visit " + (j+1));
                }
            }
        }
    }
}
