package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|47|求最小步数|逻辑分析|100|
 * 求从坐标零点到坐标点n的最小步数，一次只能沿横坐标向左或向右移动2或3，途径坐标点可为负数
 * 输入：坐标点n，
 * 输出：最小步数
 *
 * 示例输入：4
 * 输出：2
 *
 * 思路；
 * 数字的最小步数组成中存在2，则n + 1将2变为3，仍然最小的步数为两步
 * 如果不存在2，则n + 1就是最小步数-1，如6=3+3，7=3+2+2
 * n > 4时，dp[n] = dp[n - 4] / 3 + 2
 *
 */
public class B47求最小步数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int[] nums = {6,7,8,9,10,11,12,13,14,15};


//        Arrays.stream(nums).forEach(n -> {

        int x, y = 0;
        // 奇数n里肯定有一个步数3，
        // x计算多少个步数2，
        // y计算多少个步数3，
        if (n % 2 != 0) {
            n = n - 3;
            y = 1;
        }
        x = n % 6 / 2;
        y = y + n / 6 * 2;
        System.out.println(x);
        System.out.println(y);
        System.out.println(Math.abs(x) + Math.abs(y));
//        });

    }
}
