package topological_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用DFS遍历各节点,并记录遍历到各节点的时间,将时间从大到小排序的结果即为拓扑排序
 * 
 * @author Terry Meng
 * @since 04/17/2020
 */

public class Solution_2 {
	
	static int time;  // 记录时间
	static boolean[] visited;  // 辅助数组记录各节点是否访问过
	static int[] finish_time;  //辅助数组记录各节点结束时间
	
	public static List<Integer> topological_sort(int vertices_num, int[][] graph) {
		/*
		 * @param vertices_num: the number of vertices
		 * @param graph: adjacent matrix
		 */
		// initialize values
		time = 0;
		visited = new boolean[vertices_num];
		finish_time = new int[vertices_num];
		List<Integer> result = new ArrayList<Integer>();
		// iterate all the vertices with DFS
		for (int i = 0; i < vertices_num; i++) {
			if (!visited[i]) DFS(graph, i, vertices_num);
		}
		// 拓扑序列即为将finish_time[]从大到小排序的结果
		for (int i = vertices_num; i > 0; i--) {
			for (int j = 0; j < vertices_num; j++) {
				if (finish_time[j] == i) result.add(j);
			}
		}
		return result;
	}
	
	private static void DFS(int[][] graph, int vertice, int vertices_num) {
		visited[vertice] = true;
		for (int i = 0; i < vertices_num; i++) {
			if (graph[vertice][i] == 1 && !visited[i])
				DFS(graph, i, vertices_num);
		}
		finish_time[vertice] = ++time;
	}
	
	// 通过有向边生成邻接矩阵
		private static int[][] edges_to_graph(int vertices_num, int[][] edges) {
			int[][] graph = new int[vertices_num][vertices_num];
			for (int i = 0; i < vertices_num; i++) {
				graph[edges[i][0]][edges[i][1]] = 1;
			}
			return graph;
		}

		public static void main(String[] args) {
			int[][] graph = edges_to_graph(4, new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
			List<Integer> result = topological_sort(4, graph);
			System.out.println("result: " + result);
			
			graph = edges_to_graph(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
			result = topological_sort(5, graph);
			System.out.println("result: " + result);

			graph = edges_to_graph(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
					new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
			result = topological_sort(7, graph);
			System.out.println("result: " + result);
		}

}
