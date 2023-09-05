package TheLC75;

/**
 * LC#11.Med 盛最多水的容器 【双指针】
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 思路：
 * 左右指针指向左右端，此时底最大，
 * 左右指针往中间移都会缩小底，所以要尽量保留较高的一边
 *
 */
public class MaxArea11 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            System.out.println(maxArea);
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {0,3,0,2};
        System.out.println(maxArea(height));
    }
}
