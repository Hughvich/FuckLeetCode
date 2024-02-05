package Arrays.RemoveElements;

import java.util.Arrays;

public class RemoveElement27 {
    /**
     * LC#27.Easy
     * 《双指针问题》
     *
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     *
     * 元素的【顺序可以改变】。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2,
     * 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     *
     * 数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
     */

    //暴力解法：遇到目标元素直接for整体前移
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j]; // 注意边界溢出问题
                }
                i--;
                n--;
            }
        }
        return n;
    }

    //快慢双指针解法：slow是坑，fast是找萝卜，只把不是目标的萝卜填坑，通过覆盖来删除
    public static int removeElement2Pointers(int[] nums, int val) {
        int slowI = 0;
        for (int fastI = 0; fastI < nums.length; fastI++) {
            if (nums[fastI] != val) { //快指针找到目标值时，跳过判断，快指针进入下一个循环先走一步，慢指针少加一个
                nums[slowI++] = nums[fastI]; //快给慢，相当于数组前挪 / 赋值后++
//                slowI++; //没找到目标值时，慢指针和快指针一起增加
            }
        }
//        return nums; //返回删除但保留目标值的数组
        return slowI; //slowI指向与目标值不同的值的总数，即删除后数组长度
    }


    public static void main(String[] args) {
        int [] nums1 = {0, 1, 2, 3, 3, 0, 4, 2};
        System.out.println(Arrays.toString(nums1));
        int val1 = 2;
        System.out.println(removeElement(nums1,val1));
        System.out.println(removeElement2Pointers(nums1,val1));
//        System.out.println(Arrays.toString(removeElement2Pointers(nums1,2)));

    }

}
