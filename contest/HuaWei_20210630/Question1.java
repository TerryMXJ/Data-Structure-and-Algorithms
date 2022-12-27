package contest.HuaWei_20210630;

/**
 * 对于两个单调递增整数序列s1, s2, 在其中可能存在这样的子序列ss1, ss2, 对于任意元素ss1[i+1]-ss1[i]= ss2[i+1]-ss2[i], 请找出这样子序列中
 * 元素个数最多的子序列。
 * 子序列定义：对于长度为N的子序列S, 从其中删除n个元素后得到一个子序列SS
 *
 * 给定两个单调递增序列，单个元素取值范围 -10^9 < ss[i] < 10^9
 * 如果能找到子序列，则第一行输出子序列长度，第二三行输出子序列
 * 如果有多个满足条件的子序列，输出元素最小子序列
 * 如果找不到子序列，输出0即可
 * 输入：
 * 1 2 3 4 5
 * 2 4 6 8
 * 输出：
 * 3
 * 1 3 5
 * 2 4 6
 */

public class Question1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{2,4,6,8};
//        solution(arr1, arr2);
    }

//    private static void solution(int[] arr1, int[] arr2) {
//
//
//        for (int i : arr1) {
//            for (int j : arr2) {
//                map.computeIfAbsent(i-j, k->new ArrayList<>()).add(new int[]{i, j});
//            }
//        }
//        for (int i : map.keySet()) {
//            System.out.println(i);
//            for (int[] j : map.get(i))
//                System.out.println(Arrays.toString(j));
//            break;
//        }
//    }

}
