package graph.shortest_path;

import java.util.Arrays;

public class Floyd {

    public static void main(String[] args) {
        int[][] graph = {
                {Integer.MAX_VALUE,10,Integer.MAX_VALUE,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE,2},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
                {7,Integer.MAX_VALUE,6,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,3,9,2,Integer.MAX_VALUE}
        };

        floyd(graph);
    }

    private static void floyd(int[][] graph) {
        int len = graph.length;
        int[][] dist = new int[len][len];
        // initialize the solution matrix
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        // add all the vertices one by one to the set of intermediate vertices
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j] && dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(dist));
    }

}
