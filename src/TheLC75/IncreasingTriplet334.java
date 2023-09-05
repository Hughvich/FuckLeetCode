package TheLC75;

import java.util.*;

/**
 * LC#334.Medium 递增的三元序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 */
public class IncreasingTriplet334 {
    public static boolean increasingTriplet(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        Arrays.stream(nums).forEach(numList::add);
        System.out.println("numList: " + numList);

        for (int i = 1; i < nums.length - 1; i++) {

            List<Integer> leftList = numList.subList(0, i);
            List<Integer> rightList = numList.subList(i + 1, numList.size());

            leftList.sort(Comparator.comparingInt(o -> o));
            rightList.sort((o1, o2) -> o2 - o1);

            System.out.println("nums" + i + ": " + nums[i]);
            System.out.println("leftList：" + leftList);
            System.out.println("rightList: " + rightList);

            if (nums[i] > leftList.get(i - 1) && nums[i] < rightList.get(i + 1))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
//        int [] nums = {2,1,5,0,4,6};
//        int [] nums = {6,5,4,3,2,1};
//        int [] nums = {1,2,3,4,5};
        int [] nums = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }
}
