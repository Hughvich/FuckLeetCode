package TheLC75;

/**
 * LC#1137.Easy 第 N 个泰波那契数 【就是数学技巧】
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 *
 */
public class Tribonacci1137 {
    public static int tribonacci(int n) {
        int[] nums = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            nums[i % 3] = nums[0] + nums[1] + nums[2];
        }
        return nums[n % 3];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
