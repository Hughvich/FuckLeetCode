package TheLC75;

import java.util.Arrays;

/**
 * LC#746.Easy 使用最小花费爬楼梯 【dp动态规划】
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 *
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * dp数组：一维，就是花费数组。i就是位置，
 * 从2到n，
 * dp[i - 1] 和 dp[i - 2]作比较，谁小就选谁
 * 初始化：
 * 遍历：左到右
 * dp[0],dp[1]的花费都是0，
 * dp[i] = min((dp[i - 1] + cost[i - 1]),(dp[i - 2] + cost[i - 2]))
 *
 */
public class MinCostClimbingStairs746 {
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1]; //长度+1，最后还有一步成本
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min((dp[i - 1] + cost[i - 1]),(dp[i - 2] + cost[i - 2]));
        }

        System.out.println(Arrays.toString(dp));

        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
//        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
