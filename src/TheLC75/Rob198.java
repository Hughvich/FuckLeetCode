package TheLC75;

import java.util.Arrays;

/**
 * LC#198.Med 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 和邻座问题一样，每三个一组，前后任一如果偷了就不能偷，否则可以偷
 * 1. dp数组，即拿到的最大价值，
 * 2. 偷第i间，意味着dp[i] = dp[i - 2] + nums[i]，前面的第 i - 2间的加上当前的金额
 * 偷i - 1间，dp[i] = dp[i - 1]
 * 以上两者取其大，
 * dp[i] = max((dp[i - 2] + nums[i]), dp[i - 1])
 * 3. 初始化：dp[0]就是nums[0]，dp[1]是max(nums[0], nums[1])
 * 4. 遍历顺序：从前往后，
 * 5.
 */
public class Rob198 {
    public static int rob(int[] nums) {
        if (nums.length <= 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] n = {2,7,9,3,1};
        System.out.println(rob(n));
    }
}
