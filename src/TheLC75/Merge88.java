package TheLC75;

import java.util.Arrays;

/**
 * LC#88.Easy 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * 思路：比较最大的两个元素，放在末尾，
 * 从最后开始遍历，从最后开始放
 *
 * nums1 = [11,12,13,0,0,0,0,0], m = 3, nums2 = [2,5,6,7,9], n = 5
 */
public class Merge88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > -1 && j > -1) {

            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
//            nums1[k] = Math.max(nums1[i], nums2[j]); //不能用max判断

        }
        // 不用管nums1是否遍历完，即使m < n 提前遍历完，顺序也在nums1正确位置上
        while (j > -1)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,0,0,0,0,0};
        merge(nums, 3, new int[] {2,5,6,7,9}, 5);
        System.out.println(Arrays.toString(nums));
    }

}
