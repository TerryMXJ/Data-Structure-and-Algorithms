package string_processing.subsequence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * website: https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/
 */

public class Leetcode1713 {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> arr_convert = new LinkedList<>();
        for (int i : arr) {
            if (map.containsKey(i)) arr_convert.add(map.get(i));
        }
        int[] target_convert = new int[target.length];
        for (int i = 0; i < target_convert.length; i++) {
            target_convert[i] = i;
        }
        int[][] dp = new int[target_convert.length][arr_convert.size()];
        for (int i = 0; i < dp[0].length; i++) {
            if (target_convert[0]==arr_convert.get(i)) dp[0][i] = 1;
        }
        int temp = 0;
        for (int i = 0; i < dp.length; i++) {
            if (arr_convert.get(0)==target_convert[i]) temp=1;
            dp[i][0] = 1&temp;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr_convert.get(j)==target_convert[i]) dp[i][j] = Math.max(dp[i][j-1]+1, dp[i-1][j]);
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i][arr_convert.size()-1], res);
        }
        return target_convert.length-res;
    }
}
