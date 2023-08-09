package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|41|数组拼接|数据结构|100|
 * 多组整数数组，需要合并成一个新的数组，
 * 从每个数组中里按顺序取出固定长度的内容 合并到新的数组中，取完的内容会删除掉，
 * 如果该行 不足固定长度 或已经为空，直接取出剩余部分的内容放到新的数组中，继续下一行
 *
 * 输入：第一行：每次读取的固定长度，0<<10
 * 第二行：整数数组的数目，0<<1000
 * 第三到第n行：需要合并的数组，不同数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素
 *
 * 输出：一个新的数组，逗号分隔
 *
 * 示例：
 * 3
 * 2
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 * 输出：
 * 2,5,6,1,7,4,7,9,5,3,4,7
 *
 * 思路：
 * 数组套数组，
 *
 * 【【2,5,6,7,9,5,7】，【1,7,4,3,4】】
 */
public class B41数组拼接 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int itv = in.nextInt(); // 每次读取的固定长度：间隔
        int N = in.nextInt();
        in.nextLine();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        }

        List<Integer> ans = new ArrayList<>();
        int totalNum = 0;
        for (int i = 0; i < N; i++) {
            totalNum += list.get(i).size();
        }
        // 遍历所有数组，以下为核心部分
        while (ans.size() != totalNum ) {
            for (List<Integer> nums : list) {
                if (nums.size() == 0) continue;
                // 读取次数，取 间隔 和 剩余长度 较小值
                int read = Math.min(nums.size(), itv);
                for (int j = 0; j < read; j++) {
                    ans.add(nums.remove(0));
                }
            }
        }

        for (int i = 0; i < totalNum; i++) {
            if (i == totalNum - 1) {
                System.out.print(ans.get(i));
            } else {
                System.out.print(ans.get(i) + ",");
            }
        }
    }
}
