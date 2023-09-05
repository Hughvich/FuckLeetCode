package TheLC75;

import java.util.Arrays;

/**
 * LC#283.Easy 移动零 【双指针】【做过】
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 解题思路；
 *  *  双指针，索引fast的值与0比较，只要不等于0，fast的值就赋给slow，slow++
 *  *  标志位slow，记录等于0的次数，倒数n个赋值0
 *  *  有几个0就向前移几位
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0)
                nums[slow++] = nums[fast];
        }
        System.out.println(slow);
        for (int i = slow; i < nums.length; i++)
                nums[i] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
