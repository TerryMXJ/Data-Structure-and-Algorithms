package graph.topological_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * topological sort implementation method 1:使用辅助数组indegree[]记录每个顶点的入度, 辅助栈stack记录所有入度为0的顶点
 * 
 * @author Terry Meng
 * @since 04/17/2020
 */

public class Solution_1 {
	
	public static List<Integer> topological_sort(int vertices_num, int[][] graph) {
		/*
		 * @param vertices_num: the number of vertices
		 * @param graph: adjacent matrix
		 */
		List<Integer> result = new ArrayList<Integer>();
		int[] indegree = new int[vertices_num];
		Stack<Integer> stack = new Stack<Integer>();
		// update indgree[]
		for (int i = 0; i < vertices_num; i++) {
			for (int j = 0; j < vertices_num; j++) {
				if (graph[i][j] == 1) indegree[j]++;
			}
		}
		// add vertices which indegree is 0 to stack
		for (int i = 0; i < vertices_num; i++) {
			if (indegree[i] == 0) stack.add(i);
		}
		// using cnt to count the number of vertices which have been processed
		// if cnt < vertices_num, that means the graph contains cycle
		int cnt = 0;
		while (!stack.isEmpty()) {
			// add vertice to the result
			int temp = stack.pop();
			result.add(temp);
			cnt++;
			// update indegree[], if indegree[i] changes to 0, add it to stack
			for (int i = 0; i < vertices_num; i++) {
				if (graph[temp][i] == 1) {
					indegree[i]--;
					if (indegree[i] == 0) {
						stack.add(i);
					}
				}
			}
		}
		if (cnt != vertices_num) {
			System.out.println("contains loop in the graph");
			return null;
		}
		return result;
	}
	
	// generate adjacent matrix
	private static int[][] edges_to_graph(int vertices_num, int[][] edges) {
		int[][] graph = new int[vertices_num][vertices_num];
		for (int i = 0; i < vertices_num; i++) {
			graph[edges[i][0]][edges[i][1]] = 1;
		}
		return graph;
	}

	public static void main(String[] args) {
		List<Integer> result = topological_sort(4,
				edges_to_graph(4, new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } }));
		System.out.println(result);

		result = topological_sort(5, 
				edges_to_graph(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } }));
		System.out.println(result);

		result = topological_sort(7, 
				edges_to_graph(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } }));
		System.out.println(result);
	}

}
