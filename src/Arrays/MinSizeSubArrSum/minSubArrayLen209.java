package Arrays.MinSizeSubArrSum;

/**
 * LC#209.Medium
 * 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足 各项和 大于等于 target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：4+3 = 7，子数组[4,3]是长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1，[4]即长度最小的子数组
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0，无法满足
 *
 * 思路：比如nums = [2,3,1,2,4,3]，
 * 从第[0]到第[5]个作为开始：
 * 从第[0]开始，子序列包括，[2],[2,3],[2,3,1],...,[全部]
 * 从第[1]开始，子序列包括，[3],[3,1],[3,1,2],...,[3,1,2,4,3]
 * 从第。。。开始，。。。
 * 从第[5]开始，子序列包括，[3]
 *
 * 暴力解法：两层循环嵌套，挨个计算sum，一旦大于等于target就记下来长度，取长度最短的那个
 *
 * 滑动窗口法（双指针的变体）：不断调整子序列的起始位置和终止位置；
 * 窗口内是什么？当前子数组
 * 如何移动窗口的起始位置？
 * 如何移动窗口的结束位置？
 * --> 结束位用for索引，起始位置用判断：当窗口值sum大于target长度，起始位向前移（缩小窗口）
 */

public class minSubArrayLen209 {
    // 暴力解法
    public static int minSubArrLen1(int[] nums, int target) {
        int sum = 0;
        int subArrLen = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0; // 每次从下一个角标开始时，和清零
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subArrLen = j - i + 1;
                    result = Math.min(result, subArrLen);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //滑动窗口法
    //复杂度：O(n)，每个元素在窗口滑动后进来操作一次，出去操作一次，2n次操作
    public static int minSubArrLen2(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subArrLen = 0;

        int i = 0;
        // 结束位用for索引j
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j]; //从开始0，每次循环就是终止位后移，加到j总和
            // 起始位置i用判断：当窗口总值sum大于target，起始位向前移（缩小窗口）
            while (sum >= target) {
                subArrLen = j - i + 1;
                result = Math.min(result, subArrLen);
                sum -= nums[i]; //缩小窗口：即把sum里最前一个元素删掉
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrLen1(nums,8));
        System.out.println(minSubArrLen2(nums,8));
    }
}
