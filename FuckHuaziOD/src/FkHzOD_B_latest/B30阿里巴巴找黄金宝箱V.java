package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|30|阿里巴巴找黄金宝箱V|滑动窗口|100|
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，
 * 藏宝地有编号从 0-N 的箱子，每个箱子上面贴有一个数字. 阿里巴巴念出一个咒语数字 k(k<N)，
 * 找出连续 k 个宝箱数字和的最大值，并输出该最大值。
 * 输入 第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5。
 * 1≤ 字串中数字的个数 ≤100000 -10000≤ 每个数字 ≤10000
 * 第二行输入咒语数字，例如: 4，咒语数字大小小于宝箱的个数
 * 输出 连续 k 个宝箱数字和的最大值，例如: 39
 * 示例1：
 * 2,10,-3,-8,40,5
 * 输出：39
 * 示例2：
 * 输入：
 * 8
 * 1
 * 输出：
 * 8
 *
 * 思路：
 * 滑动窗口，参考：
 * LC#2461.长度为K子数组中的最大和
 * 连续k个宝箱数字和的最大值
 *
 */
public class B30阿里巴巴找黄金宝箱V {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = in.nextInt();

        int max = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];

            }
            System.out.println("sum: " + sum);
            if (sum > max)
                max = sum;
        }

        System.out.println("max: " + max);

    }
}
