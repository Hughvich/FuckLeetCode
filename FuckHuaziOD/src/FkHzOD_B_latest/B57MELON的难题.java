package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|57|MELON的难题|动态规划|200|
 *
 * MELON有一堆精美的雨花石(数量为n，重量各异)，准备送给S和W。
 * MELON希望送给俩人的雨花石重量一致，请你设计一个程序帮MELON确认是否能将雨花石平均分配。
 * 输入描述
 * 第1行输入为雨花石个数: n，0 < n < 31.
 * 第2行输入为空格分割的各雨花石重量: m[0] m[1] ..... m[n - 1]， 0 < m[k] < 1001
 * 不需要考虑异常输入的情况。
 * 输出描述
 * 如果可以均分，从当前雨花石中最少拿出几块，可以使两堆的重量相等:如果不能均分，则输出-1。
 * 示例1输入
 * 4
 * 1 1 2 2
 * 输出
 * 2
 * 说明：输入第一行代表共4颗雨花石，第二行代表4颗雨花石重量分别为1、1、2、2。均分时只能分别为1,2，需要拿出重量为1和2的两块雨花石，所以输出2。
 * 示例2输入
 * 10
 * 1 1 1 1 1 9 8 3 7 10
 * 输出
 * 3
 * 说明：输入第一行代表共10颗雨花石，第二行代表4颗雨花石重量分别为1、1、1、1、1、9、8、3、7、10 。均分时可以1,1,1,1,1,9,7和10,8,3，也可以1,1,1,1,9.8和10,7,3,1，或者其他均分方式，但第一种只需要拿出重量为10.8,3的3块雨花石，第二种需要拿出4块，所以输出3(块数最少)。
 *
 * 思路：
 * 01背包问题，n数量的石头，不同的重量w，
 * 平分到两个背包，每个背包承重=数组和/2，
 * dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - w] + 1)
 *
 * */
public class B57MELON的难题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] weights = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(weights).sum();

        // 奇数不能平分直接-1退出
        if (sum % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int[] dp = new int[(sum / 2) + 1];
        // 初始化全为n ? ? ?
        for (int i = 1; i <= sum / 2; i++) {
            dp[i] = n;
        }

        // dp经典结构：外n，内sum / 2 到 weights[i - 1]倒循环
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= weights[i - 1]; j--) {
                dp[j] = Math.min(dp[j], dp[j - weights[i - 1]] + 1);
            }
        }

        System.out.println(Arrays.toString(dp));

        if (dp[sum / 2] == n) // dp[sum / 2]的值没变过，dp失败
            System.out.println(-1);
        else
            System.out.println(dp[sum / 2]);
    }
}
