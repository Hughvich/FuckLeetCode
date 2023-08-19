package FkHzOD_B_latest;

import java.util.*;

/**
 * B|20|阿里巴巴找黄金宝箱II|数据结构|100|
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗的藏宝地，有编号0-N的箱子，每个箱子上贴有箱子中藏有金币的数量；
 * 从金币数量中选出一个数字集合，并销毁贴有这些数字的每个箱子，如果能销毁一半以上（含）的箱子，则返回这个数字集合的最小大小；
 * 输入描述
 * 一个数字字串，逗号分隔，共有偶数个，1<=个数<=100000
 * 输出：这个数字集合的大小
 * 示例1：
 * 1,1,1,1,3,3,3,6,6,8
 * 输出：2
 * 说明：选择集合{1,8}，销毁后数组为[3,3,3,6,6]，长度为5，原先长度10的一半；
 *      还可选择集合{1,3}, {1,6}, {3,6}
 * 示例2：
 * 2,2,2,2
 * 输出：1
 * 选择集合{2}，销毁后数组为空
 *
 * 思路：
 * 排序，相同数字集合从最多排到最少，
 * 先按照数量最多的销毁，如果满足条件，找下一个，
 */
public class B20阿里巴巴找黄金宝箱II {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        // map，k是出现的数字，v是出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i], ++count);
            if (nums[i + 1] != nums[i] )
                count = 0;
        }
        // 最后一个遍历不到，手动加
        map.put(nums[nums.length - 1], ++count);
        // 用list给entrySet排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        // total是累计的出现总数，从大到小遍历，超过总量一半时输出
        int total = list.get(0).getValue();
        if (list.size() == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            if (total >= nums.length / 2) {
                System.out.println(i);
                return;
            } else total += list.get(1).getValue();
        }
    }
}
