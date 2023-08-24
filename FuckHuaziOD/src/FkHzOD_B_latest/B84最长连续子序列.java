package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * B|84|最长连续子序列|滑动窗口|100|
 * N个正整数组成的序列，给定整数sum，求长度最长的连续 子序列，使和等于sum，返回子序列长度，如无返-1
 * 输入：第一行N个正整数组成一个序列 第二行sum
 * 输出：最长子序列长度
 * 示例1：
 * 1,2,3,4,2
 * 6
 * 输出：
 * 3
 * 示例2：
 * 1,2,3,4,2
 * 20
 * 输出：
 * -1
 *
 * 思路：滑动窗口，起始左右都在0，右逐渐右移，
 * 如果窗口大于target，左指针右移，
 * 小于target，右指针继续右移
 *
 */
public class B84最长连续子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(in.nextLine());

        int sum = 0;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        // 左指针i，
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            // 窗口大于target，左指针右移
            if (sum > target)
                continue;
            else if (sum == target)
                max = 1;
            // 右指针j，遍历过的数字个数count
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count++;
                // 窗口大于target，停止，
                if (sum > target)
                    break;
                else if (sum == target) {
                    max = Math.max(max, count);
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
