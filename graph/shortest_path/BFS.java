package graph.shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        int[][] graph = {
            {0,1,1,1,0},
            {1,0,1,1,1},
            {1,1,0,1,0},
            {1,1,1,0,1},
            {0,1,0,1,0}
        };

        bfs(graph, 0);

    }

    private static void bfs(int[][] graph, int i) {
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // initialize
        for (int j = 0; j < graph.length; j++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // add origin vertex to queue
        visited[i] = true;
        dist[i] = 0;
        queue.offer(i);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 0; j < graph.length; j++) {
                if (graph[temp][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    // update dist[] and visited[]
                    dist[j] = dist[temp] + 1;
                    visited[j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

}
