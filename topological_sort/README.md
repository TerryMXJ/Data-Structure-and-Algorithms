# Topological Sort

## Definition

[Topological Sort](https://en.wikipedia.org/wiki/Topological_sorting) is used to find a linear ordering of elements that have dependencies on each other. For example, if event ‘B’ is dependent on event ‘A’, ‘A’ comes before ‘B’ in topological ordering.

## Solution

- [Solution_1](./Solution_1.java): 使用辅助数组indegree记录每个顶点的入度， 使用stack(list, queue)记录所有入度为0的顶点
- [Solution_2](./Solution_2.java): 使用DFS遍历各节点，同时记录下各节点结束遍历的时间， 将结束时间从大到小排序即可得到拓扑排序

## 可以解决的问题：

- 拓扑排序相关问题：
  - Question Type 1: There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
  - Question Type 2: There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to find the ordering of tasks we should pick to finish all tasks.
  - [Question Type 3](./Question_Type_3_Solution.java): There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites. (Hint: Using recursive approach + backtracking)
- 检查有向图是否含有环： 如果拓扑遍历结束没有遍历完全部节点则说明该有向图含有环

