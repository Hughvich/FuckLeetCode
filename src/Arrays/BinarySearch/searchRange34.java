package Arrays.BinarySearch;

import java.util.Arrays;

public class searchRange34 {
    /**
     * 给你一个按照 非递减顺序 排列的整数数组 nums，和一个目标值 target。
     * 请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     *
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * 思路：
     * 左边界，右边界先分别两次二分查找实现
     * 关键：
     *      找右边界，如果target落入mid右闭区间，则右边界在mid右侧
     *      找左边界，如果target落入mid左闭区间，则左边界在mid左侧
     *
     */


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};
        int high = getHigh(nums, target);
        int low = getLow(nums, target);
//        System.out.println("high = " + high);
//        System.out.println("low = " + low);
        if (high - low > 1)
            return new int[] {low + 1, high - 1};

        return new int[] {-1, -1};
    }

    private static int getHigh(int[] nums, int target) {
        int high = -1; //右边界
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) { //target在mid左侧，右边界不在mid左侧
                right = mid -1;
            } else { //target >= nums[mid]，target在mid右侧，则右边界在left右侧
                left = mid + 1;
                high = left;
            }
        }
        return high;
    }

    private static int getLow(int[] nums, int target) {
        int low = -1; //左边界
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) { // target在mid左侧，左边界在mid左侧
                right = mid -1;
                low = right;
            } else{ // target > nums[mid]，
                left = mid + 1;
            }
        }
        return low;
    }

    //第二种方法，左右两个指针，循环移动
    public static int[] searchRange2(int[] nums, int target) {
        int found = BinarySearch704.binarySearch(nums,target);
        if (found == -1) return new int[] {-1, -1};
        int l = found;
        int r = found;
        while ((l - 1) >= 0 && nums[l - 1] == nums[found])
            l--;
        while ((r + 1) < nums.length && nums[r + 1] == nums[found])
            r++;
        return new int[] {l, r};
    }



    public static void main(String[] args) {
        int[] nums = {5,7,7,7,8,8,8,10};
        int[] nums1 = {};
        int[] nums2 = {0};
        System.out.println(Arrays.toString(searchRange(nums,6)));
        System.out.println(Arrays.toString(searchRange(nums1,1)));
        System.out.println(Arrays.toString(searchRange(nums2,0)));

        System.out.println(Arrays.toString(searchRange2(nums2,0)));
    }
}
