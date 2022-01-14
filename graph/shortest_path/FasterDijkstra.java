package graph.shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FasterDijkstra {

    public static void main(String[] args) {
        int[][] graph = {
                {Integer.MAX_VALUE,10,Integer.MAX_VALUE,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE,2},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
                {7,Integer.MAX_VALUE,6,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,3,9,2,Integer.MAX_VALUE}
        };

        fasterDijkstra(graph, 0);
    }

    private static void fasterDijkstra(int[][] graph, int i) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        int[] path = new int[graph.length];

        // initialize
        Arrays.fill(path, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[i] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{i, dist[i]});
        // loop and update dist[]
        while (pq.size()!=0) {
            // visit node with shortest distance from src node
            int[] tmp = pq.poll();
            if (visited[tmp[0]]) continue;
            visited[tmp[0]] = true;
            //update dist and path
            for (int k = 0; k < graph.length; k++) {
                if (graph[tmp[0]][k]!=Integer.MAX_VALUE && dist[k] > dist[tmp[0]]+graph[tmp[0]][k]) {
                    dist[k] = dist[tmp[0]] + graph[tmp[0]][k];
                    path[k] = tmp[0];
                    pq.offer(new int[]{k, dist[k]});
                }
            }
            System.out.println("distance: " + Arrays.toString(dist));
        }
    }

}
