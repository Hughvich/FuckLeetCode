package Arrays.BinarySearch;

import java.util.Arrays;

public class SearchInsert35 {
/**
 * LC#35.Easy
 * 《二分搜索问题》
 *
 * 实现一个简单的二分查找，给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 解题思路：
 * 本质上在玩边界问题，
 * 四种情况：插在首位，插在末尾，插在中间，要插入的元素存在
 */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int a = 13;
        System.out.println(searchInsert(nums, a));

    }
    public static int searchInsert (int[] nums, int target) {
        //先二分查找
        int lo = 0;
        int hi = nums.length - 1;
        int[] numsInsert = new int[nums.length + 1];
        System.out.println(Arrays.toString(numsInsert));
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] < target) {
                lo = m + 1;
            } else if (nums[m] > target) {
                hi = m - 1;
            } else return m;
        }
        //循环完后lo为目标索引位置
        System.out.println("lo, hi = " + lo + ", " + hi);
        //复制数组numsInsert <- nums
        for (int j = 0; j < nums.length; j++) {
            numsInsert[j] = nums[j];
        }
        //插入目标值，倒序遍历数组，整体向后移
        for (int i = numsInsert.length - 2; i >= lo; i--) {
            numsInsert[i + 1] = numsInsert[i];
        }
        numsInsert[lo] = target;

        System.out.println(Arrays.toString(numsInsert));

        return lo; //即hi + 1
    }
}
