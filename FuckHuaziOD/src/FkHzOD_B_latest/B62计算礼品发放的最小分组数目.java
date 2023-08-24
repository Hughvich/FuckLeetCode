package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|62|计算礼品发放的最小分组数目|双指针|100|
 * 发放礼品，根据价格分组，每组最多两件礼品，每组价格不超过上限，找到分组数目最少的方案
 * 输入：
 * 第一行：分组礼品价格之和的上限
 * 第二行：每个礼品的价格，空格隔开，单个礼品价格不超过 分组和的上限
 * 示例：
 * 5
 * 1 2 5
 * 输出：
 * 2
 *
 * 思路：
 * 排序后双指针，
 * 分别向中间靠拢，如果之和超过上限，左指针左移一个，
 */
public class B62计算礼品发放的最小分组数目 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        // 双指针：p1 - i指头，p2 - j指尾，分别向中间靠拢，
        // p1和p2和 如果超过了上限target，p1减小一个，
        // 循环结束：p1接触到了p2
        int j = nums.length - 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[j] > target)
                i--;
            j--;
            count++;
            if (i >= j)
                break;
        }
        System.out.println(count);

    }
}
