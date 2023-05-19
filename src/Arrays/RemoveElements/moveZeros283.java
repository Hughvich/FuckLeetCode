package Arrays.RemoveElements;

import java.util.Arrays;

public class moveZeros283 {
    /**
     * LC#283.Easy
     * 《双指针问题》
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意，必须在【不复制数组】的情况下原地对数组进行操作。
     *
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     *
     * 解题思路；
     *  双指针，s与0比较，只要等于0，f就赋给s，s++
     *  标志位n，记录等于0的次数，倒数n个赋值0
     */

    public static void moveZeros (int[] nums) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != 0) {
                nums[s++] = nums[f];
            }
        }
        //以下循环用于把0搬到末尾
        //可以用s为现数组的长度到nums.length原数组的长度遍历
        for (int i = s; i < nums.length; i++) nums[i] = 0;

        /*
        int n = nums.length;
        for (int zeros = n - numZeros; zeros < n; zeros++) {
            nums[zeros] = 0;
        }
        以上为最初的方法：numZeros标志位多此一举，因为s就相当于标志位
        * */

    }

    public static void main(String[] args) {
        int [] nums1 = {0,1,0,3,12}; //output [1,3,12,0,0]
        moveZeros(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,1}; //output [1,0]
        moveZeros(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
