package graph.minimal_spanning_tree;

public class Prim {

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

        prim(graph, 0);

    }

    private static void prim(int[][] graph, int i) {
        boolean[] visited = new boolean[graph.length];
        // 记录最小生成树每个顶点的邻接顶点
        int[] adj_vex = new int[graph.length];

        // initialize
        for (int j = 0; j < graph.length; j++) {
            visited[j] = false;
            adj_vex[j] = -1;
        }
        visited[i] = true;

        int min = Integer.MAX_VALUE;
        int v1 = -1, v2 = -1;
        int sum = 0;

        // loop n-1 times to add n-1 edge
        for (int j = 1; j < graph.length; j++) {
            // find edge which has minimal weight and one end-point visited, another unvisited
            for (int m = 0; m < graph.length; m++) {
                for (int n = 0; n < graph.length; n++) {
                    if (visited[m] && !visited[n] && graph[m][n] < min) {
                        min = graph[m][n];
                        v1 = m;
                        v2 = n;
                    }
                }
            }
            // add edge
            sum += min;
            System.out.println("add edge <" + v1 + "," + v2 + ">");
            visited[v2] = true;
            min = Integer.MAX_VALUE;
        }
        System.out.println("weight of MST: " + sum);
    }

}
