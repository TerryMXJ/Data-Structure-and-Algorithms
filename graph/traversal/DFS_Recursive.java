package graph.traversal;

public class DFS_Recursive {

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
        // traverse each vertex
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) dfs(i);
        }
    }

    private static void dfs(int i) {
        // visit vertex i
        System.out.println("visit " + (i+1));
        visited[i] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && !visited[j]) dfs(j);
        }
    }
}
