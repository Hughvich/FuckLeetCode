package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|7|代表团坐车|动态规划|100|
 * 某组织举行会议，来了多个代表团同时到达，接待处只有一辆汽车，可以同时接待多个代表团，
 * 为了提高车辆利用率，请帮接待员计算可以坐满车的接待方案，输出方案数量。
 *
 * 约束:
 * 1.一个团只能上一辆车，并且代表团人数(代表团数量小于30，每人代表团人数小于30)小于汽车容量(汽车容量小于100)
 * 2.需要将车辆坐满
 *
 * 输入描述
 * 第一行 代表团人数，英文逗号隔开，代表团数量小于30，每个代表团人数小于30
 * 第二行 汽车载客量，汽车容量小于100
 * 输出描述：坐满汽车的 方案数量，如果无解输出0
 *
 * 示例1：
 * 输入：
 * 5,4,2,3,2,4,9
 * 10
 * 输出：4
 * 说明
 * 以下几种方式都可以坐满车，[2,3 5]、[2,4,4]、[2,3,5]、[2,4,4]
 *
 * 力扣原题，
 * 思路：
 * 动态规划，
 * 直接递归算法，
 * nums数组中选取若干元素，使其和等于neg，计算选取元素的方案数，
 * 二维数组dp，dp[i][j] 表示在nums数组前i个数中选取元素，使元素之和等于j的方案数，
 * nums长度为n，（neg，j为车容量？）
 * 没有任何元素可选时，元素和为0，i = 0，方案数为1，边界条件为
 * dp[0][j] = 1, j=0;
 *            0, j>=1
 *
 * 当1 <= i <= n。数组nums中第i个元素num，遍历 0 <= j <= neg，计算dp[i][j]：
 * j < num，不能选num，dp[i][j] = dp[i-1][j];
 * j >= num, 如果不选num，方案数dp[i-1][j]，如果选num，方案数dp[i-1][j-num]
 *
 * dp[i][j] = dp[i-1][j]， j < num；
 *            dp[i-1][j] + dp[i-1][j-num]，j >= num；
 *
 * 最终得到dp[n][neg]为答案
 *
 *
 */

public class B7代表团坐车 {

    // *******一定要注意全局变量count
    public static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int capacity = in.nextInt();

        System.out.println(dp(nums, capacity, 0, 0));

    }


    public static int dp (int[] nums, int capacity, int index, int sum) {

        if (index == nums.length) {
            if (sum == capacity) {
                count++;
                System.out.println(count);
            }
        } else {
            dp(nums, capacity, index + 1, sum);
            dp(nums, capacity, index + 1, sum + nums[index]);
        }

        return count;
    }
}
