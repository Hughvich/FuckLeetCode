package TheLC75;

import java.util.Arrays;

/**
 * LC238.Medium 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 *
 * {4,3,2,1} - {6,8,12,24}
 *
 * 思路：
 * 左右累乘，当前乘积 = 它左边的累乘积 * 它右边的累乘积
 * 两个循环，左存答案，左累乘，右累乘答案，右累乘
 */
public class ProductExceptSelf238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        /*
        int productSum = 1;
        int idxZero = 0;
        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                productSum *= nums[i];
            }
            else {
                idxZero = i;
                numZero++;
            }
        }
        // 如果数组中有且仅有1个0，res中它为总乘积，
        // 如果有2个以上的0，全为0
        if (numZero >= 2)
            return res;
        else if (numZero == 1) {
            res[idxZero] = productSum;
            return res;
        } else {

         */
            int left = 1;
            int right = 1;
            for (int i = 0; i < nums.length; i++) {
                // 这里的顺序很重要
                res[i] = left;
                left *= nums[i];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                // 这里的顺序很重要
                res[j] *= right;
                right *= nums[j];
            }
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
