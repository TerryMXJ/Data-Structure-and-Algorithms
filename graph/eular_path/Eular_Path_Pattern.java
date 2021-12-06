package graph.eular_path;

/*
在连通图中寻找欧拉路径的算法:
1. 从起点出发，进行深度优先搜索。

2. 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。

3. 如果没有可移动的路径，则将所在节点加入到栈中，并返回。

 */

import java.util.Stack;

public class Eular_Path_Pattern {

//    public static void main(String[] args) {
//        Stack<Integer> res = new Stack<>();
//        Integer src = 0;
//        dfs(src, res, graph);
//    }
//
//    private static void dfs(Integer src, Stack<Integer> res, graph) {
//        for (Integer neighbour : getNeighbour(src, graph)) {
//            delete_path_from_src_to_neighbour
//            dfs (neighbour, res, graph);
//        }
//        res.push(src);
//    }

}
