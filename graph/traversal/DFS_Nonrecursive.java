package graph.traversal;

import java.util.Stack;

public class DFS_Nonrecursive {

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
        dfs_nonrecursive(0);

    }

    private static void dfs_nonrecursive(int i) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        visited[i] = true;
        System.out.println("visit " + (i+1));
        while(!stack.isEmpty()) {
            int p = stack.pop();
            for (int j = 0 ; j < graph.length; j++) {
                if (graph[p][j] == 1 && !visited[j]) {
                    System.out.println("visit " + (j+1));
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }
}
