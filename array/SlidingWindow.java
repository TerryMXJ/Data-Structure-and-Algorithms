package array;

/**
 * 滑动窗口模板
 */

public class SlidingWindow {

    private int slidingWindow(int[] nums, int target) {
        // 创建头指针, 状态变量信息
        int i = 0, sum = 0, res = 0;
        // 移动尾指针
        for (int j = 0; j < nums.length; j++) {
            // 更新状态信息
            sum += nums[j];
            // 移动尾指针
            while (sum > target) {
                // 判断情况, 情况合适更新res
            }
        }
        return res;
    }

}
