package TheLC75;

import java.util.Arrays;

/**
 * LC#1679.Med K和数对的最大数目 【双指针】
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 * 思路：排序后双指针，
 * 首尾求和，小移left首，大移right尾，相等则都移，并记数
 *
 */
public class MaxOperations1679 {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int opsNum = 0;
        while (left < right) {
            if (nums[left] + nums[right] > k)
                right--;
            else if (nums[left] + nums[right] < k)
                left++;
            else {
                opsNum++;
                right--;
                left++;
            }
        }
        return opsNum;
    }

    public static void main(String[] args) {
//        int[] nums = {3,1,3,4,3};
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(maxOperations(nums, 16));
    }
}
