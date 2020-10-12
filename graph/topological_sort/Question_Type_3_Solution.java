package graph.topological_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem Statements: There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task
 * can have some prerequisite tasks which need to be completed before it can be
 * scheduled. Given the number of tasks and a list of prerequisite pairs, write
 * a method to print all possible ordering of tasks meeting all prerequisites.
 * 
 * Example 1: 
 * Input: 
 * Tasks=3, Prerequisites=[0, 1], [1, 2] 
 * Output: 
 * [0, 1, 2]
 * Explanation: There is only possible ordering of the tasks.
 * 
 * Example 2: 
 * Input: 
 * Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output: 
 * 1) [3, 2, 0, 1] 
 * 2) [3, 2, 1, 0] 
 * Explanation: There are two possible orderings of the tasks meeting all prerequisites.
 * 
 * Example 3: 
 * Input: 
 * Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3] 
 * Output: 
 * 1) [0, 1, 4, 3, 2, 5] 
 * 2) [0, 1, 3, 4, 2, 5] 
 * 3) [0, 1, 3, 2, 4, 5] 
 * 4) [0, 1, 3, 2, 5, 4] 
 * 5) [1, 0, 3, 4, 2, 5] 
 * 6) [1, 0, 3, 2, 4, 5] 
 * 7) [1, 0, 3, 2, 5, 4] 
 * 8) [1, 0, 4, 3, 2, 5] 
 * 9) [1, 3, 0, 2, 4, 5] 
 * 10) [1, 3, 0, 2, 5, 4] 
 * 11) [1, 3, 0, 4, 2, 5] 
 * 12) [1, 3, 2, 0, 5, 4] 
 * 13) [1, 3, 2, 0, 4, 5]
 * 
 * @author terry
 * @since 04/17/2020
 */

public class Question_Type_3_Solution {

	public static void printOrders(int tasks, int[][] prerequisites) {
		List<Integer> result = new LinkedList<Integer>();
		//initialize indegree and list
		int[] indegree = new int[tasks];
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < tasks; i++) {
			for (int j = 0; j < tasks; j++) {
				if (prerequisites[i][j] == 1) indegree[j]++;
			}
		}
		//add the vertices to list which indegree is 0
		for (int i = 0; i < tasks; i++) {
			if (indegree[i] == 0) {
				list.add(i);
			}
		}
		recursive_find_order(prerequisites, tasks, result, indegree, list);
	}

	private static void recursive_find_order(int[][] prerequisites, int tasks, List<Integer> result, int[] indegree,
			List<Integer> list) {
		for (int i : list) {
			result.add(i);
			// 复制一个新list用于下次遍历, 新的list需要remove掉现在visit的元素, 并且添加新的入度为0的节点
			List<Integer> list_for_next_recursive = deepCopy(list);
			list_for_next_recursive.remove(new Integer(i));
			// update indegree
			for (int j = 0; j < tasks; j++) {
				if (prerequisites[i][j] == 1) {
					indegree[j]--;
					if (indegree[j] == 0) {
						list_for_next_recursive.add(j);
					}
				}
			}
			recursive_find_order(prerequisites, tasks, result, indegree, list_for_next_recursive);
			// backtracking
			result.remove(new Integer(i));
			for (int j = 0; j < tasks; j++) {
				if (prerequisites[i][j] == 1) indegree[j]++;
			}
		}
		if (result.size() == tasks) {
			System.out.println(result);
		}
		
	}

	private static List<Integer> deepCopy(List<Integer> list) {
		List<Integer> copy = new LinkedList<Integer>();
		for (int i: list) copy.add(i);
		return copy;
	}

	// 通过有向边生成邻接矩阵
	private static int[][] edges_to_graph(int vertices_num, int[][] edges) {
		int[][] graph = new int[vertices_num][vertices_num];
		for (int i = 0; i < edges.length; i++) {
			graph[edges[i][0]][edges[i][1]] = 1;
		}
		return graph;
	}

	public static void main(String[] args) {
		int[][] graph = edges_to_graph(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println("first case solution: ");
		printOrders(3, graph);
		System.out.println();

		graph = edges_to_graph(4, new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println("second case solution: ");
		printOrders(4, graph);
		System.out.println();

		graph = edges_to_graph(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
				new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println("third case solution: ");
		printOrders(6, graph);
		System.out.println();
	}

}
