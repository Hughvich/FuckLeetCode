package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * B|21|阿里巴巴找黄金宝箱III|数据结构|100|
 *  一贫如洗的樵夫....blahblah，
 *  是否存在两个不同的箱子，这两个箱子的数字相同，其编号之差（按顺序0-N） 绝对值 小于等于 咒语数字，
 *  如果存在这一对箱子，返回最先找到的那对箱子左边箱子的编号，不存在返-1
 *  输入：第一行数字字串逗号分隔，个数1-100000
 *       第二行输入咒语数字，范围也是1-100000
 *  输出：如上
 *  示例：
 *  6,3,1,6
 *  3
 *  输出
 *  0
 *  示例2：
 *  5,6,7,5,6,7
 *  2
 *  输出：
 *  -1
 *
 *  思路：用map记录数字-k和索引-v，遇到数字直接作差
 *
 *
 */
public class B21阿里巴巴找黄金宝箱III {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int target = in.nextInt();

        Map<Integer, Integer>  map = new HashMap<>();
        int abs = 0;
        int idx = 0;

        //
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else if (Math.abs(i - map.get(nums[i])) <= target && map.containsKey(nums[i])) {
                abs = Math.abs(i - map.get(nums[i]));
                idx = i - abs;
                System.out.println("abs: " + abs);
                System.out.println("i: " + i);
            }
        }
//
        //以下无bug
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                if (i - map.get(nums[i]) <= target) {
//                    System.out.println(map.get(nums[i]));
//                    return;
//                } else map.put(nums[i], i);
//            } else map.put(nums[i], i);
//        }



        if (target >= abs)
            System.out.println(idx);
        else
            System.out.println(-1);
    }
}
