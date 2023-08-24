package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * B|44|跳房子I|数据结构|100|
 * 跳房子，步数组合，两个回合跳到最后一格，
 * 输入：
 * 第一行：每回合可能的连续眺的步数（5000以内的数组，每步长1亿），
 * 第二行：房子总格数count（1000以内），
 * 输出：
 * 返回 索引和 最小的步数组合
 * 示例1：
 * 输入：
 * [1,4,5,2,2]
 * 7
 * i =3, nums[i] = 2, target- nums[i] = 5, return [5,2]
 * 输出：
 * [5,2]
 * 示例2：
 * 输入：
 * [-1,2,4,9,6]
 * 8
 * 输出：
 * [-1,9]
 * -1和9的索引0和3，相加3，或者2和6的索引1和4，相加5，不是最小
 *
 * 思路：
 * 相当于LC#1 两数之和，用HashMap
 * 数组nums[i]作为key，nums的i作为value
 * 遍历nums，在map中找到target - nums[i]，且target - nums[i]的值 ！= i，
 * 返回排序后的{nums[i], nums[target-nums[i]]}
 */
public class B44跳房子I {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().replaceAll("\\[","")
                .replaceAll("]","").split(",")).mapToInt(Integer::parseInt).toArray();
        int target = in.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                int sum = i + map.get(target - nums[i]);
                if (min > sum) {
                    min = sum;
                    idx = i;
                }
            }
        }
        int[] res = {idx, map.get(target - nums[idx])};
        Arrays.sort(res);
        System.out.println("[" + nums[res[0]] + ", " + nums[res[1]] + "]");
    }
}
