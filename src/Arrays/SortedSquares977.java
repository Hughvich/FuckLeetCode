package Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * LC#977.Easy
 * 《有序数组的平方》
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，
 * 要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 */
public class SortedSquares977 {
    //暴力解法：每个数平方后，排序
    public static int[] sortedSquaresForce (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
//        return bubbleSort(nums);
        Arrays.sort(nums); //可以用库里的.sort()
        return nums;
    }

    private static int[] bubbleSort(int[] nums) {
        boolean isSorted = true;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) { //后length - i位已经排好序
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false; //优化：如果if条件所有后比前大，标志位isSorted为true
                }
            }
            if (isSorted) break;
        }
        return nums;
    }

    //双指针解法: 从两边到中间一定是绝对值在减小，
    // 从左右两指针平方后反复比较放在新数组里，一直到中部两指针相等
    public static int[] sortedSquares2Pointers(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[nums.length];
        for (int k = nums.length - 1; k >= 0; k--) {
            if((nums[l] * nums[l]) > (nums[r] * nums[r])) {
                result[k] = nums[l] * nums[l];
                l++;
            } else {
                result[k] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //nums2为随机数组
        Random r = new Random();
        int[] nums2 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            int r1 = r.nextInt(100000);
            nums2[i] = r1;
        }
        Arrays.sort(nums2);
        int[] nums1 = {-4,-1,0,3,10};
        int[] nums3 = {-7,-3,2,3,11};

        long start = System.currentTimeMillis();
        System.out.println("original: " + Arrays.toString(nums2));
//        sortedSquaresForce(nums2); //暴力解法，n^2
        System.out.println("sorted: " + Arrays.toString(sortedSquares2Pointers(nums2)));
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start));
    }
}
