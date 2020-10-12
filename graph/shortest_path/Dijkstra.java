package graph.shortest_path;

import java.util.Arrays;

public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph = {
                {Integer.MAX_VALUE,10,Integer.MAX_VALUE,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE,2},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
                {7,Integer.MAX_VALUE,6,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,3,9,2,Integer.MAX_VALUE}
        };

        dijkstra(graph, 0);
    }

    private static void dijkstra(int[][] graph, int i) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        int[] path = new int[graph.length];

        // initialize
        for (int j = 0; j < graph.length; j++) {
            visited[j] = false;
            dist[j] = graph[i][j];
            path[j] = -1;
        }
        visited[i] = true;
        dist[i] = 0;
        // loop n-1 times
        for (int j = 1; j < graph.length; j++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            // find min edge
            for (int k = 0; k < graph.length; k++) {
                if (min > dist[k] && !visited[k]) {
                    min = dist[k];
                    index = k;
                }
            }

            System.out.println("min: " + min + " index: " + index);
            System.out.println("distance: " + Arrays.toString(dist));

            visited[index] = true;


            //update dist and path
            for (int k = 0; k < graph.length; k++) {
                if ((dist[index] + graph[index][k]) > 0 && dist[index] + graph[index][k] < dist[k]) {
                    dist[k] = dist[index] + graph[index][k];
                    path[k] = index;
                }
            }


            System.out.println("distance: " + Arrays.toString(dist));
        }
        System.out.println("distance: " + Arrays.toString(dist));
    }

}
