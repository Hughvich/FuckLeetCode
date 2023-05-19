package Arrays.RemoveElements;

import java.util.Arrays;

/**
 * LC#26.Easy
 * 《双指针问题》
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * 解题思路：
 * 和双指针删除目标元素一样，最主要不同的是目标元素索引在快指针上，
 * 只要前后元素不同，f元素就赋给s + 1元素，同时s向前挪动一位
 * 最后返回的s，要+1才是数组长度，因为是0-base
 */
//********排序数组，所有的重复项肯定都在一起，不可能分布在数组各个角落********
public class removeDuplicates26 {
    public static int removeDup(int[] nums) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != nums[s]) {
                nums[s + 1] = nums[f]; //s后一个为要覆盖的第一个元素
                s++;
            }
        }
        return s+1;
    }

    public static int removeDupWhile(int[] nums) {
        int s = 0;
        int f = 0;
        while (f < nums.length) {
            if (nums[f] != nums[s]) {
                nums[s + 1] = nums[f];
                s++;
            }
            f++;
        }
        return s + 1;
    }

    public static void main(String[] args) {
        int [] nums1 = {0, 0, 1, 2, 3, 3, 4}; //returns [0, 1, 2, 3, 4]
        int [] nums2 = {0,0,1,1,1,2,2,3,3,4}; //returns [0, 1, 2, 3, 4]
        int [] nums3 = {0,0,0,2,5,5,6,7,11,22,22,56,56}; //returns [0, 2, 5, 6, 7, 11, 22, 56]
        System.out.println(removeDup(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(removeDup(nums2));
        System.out.println(Arrays.toString(nums2));
        //test removeDup - While loop
        System.out.println(removeDupWhile(nums3));
        System.out.println(Arrays.toString(nums3));
    }
}
