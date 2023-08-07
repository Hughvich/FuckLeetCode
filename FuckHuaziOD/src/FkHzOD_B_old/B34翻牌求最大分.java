package FkHzOD_B_old;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * download.csdn.net/blog/column/12287931/130172992
 * B|34|翻牌求最大分|动态规划|100|
 * 给出n个牌数，在-100到100之间，求最大得分
 * 连续翻牌，如果选当前牌，则总分等于上一次翻牌总得分加上当前牌的数字，
 * 如果当前总得分小于它前三次的总得分的话，那此次不翻牌，并且总得分就等于它前三次的得分
 * 前1到3次翻牌数如果小于0的话就取0
 *
 * 示例：
 * 输入：1,-5,-6,4,7,2,-2
 * 输出：11
 * 过程：1>0,翻牌为1，-5+0不翻为0，-6+0不翻为0，
 * 4+0翻牌为4，7+4翻牌为11，2+11翻牌为13，-2+13翻牌为11，
 * 最大得分为11
 *
 * 思路：
 * 初始化当前分和前三次得分 - 每张牌，计算当前得分和总得分 -
 * 当前牌得分 为 当前得分 加上 当前牌的数字，小于0取0 -
 * 当前总得分 为 当前牌得分 和 前三次得分 中的最大值 -
 * 更新当前得分 和 前三次得分 -
 * 输出最终的当前得分作为最大得分
 */
public class B34翻牌求最大分 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> ip = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        // 初始化当前分和前三次得分
        int curScore = Math.max(ip.get(0), 0);
        int [] preScore = {0, 0, 0};

        // 遍历每张牌，计算得分
        for (int i = 2; i < ip.size(); i++) {
            System.out.println("---------------");
            //计算当前牌得分
            int curCardScore = Math.max(curScore + ip.get(i), 0);
            // 计算当前 总得分
            int curTotalScore = Math.max(curCardScore,
                    preScore[0] + ip.get(i - 2) + ip.get(i - 1) + ip.get(i));
            System.out.println("curCardScore = " + curCardScore);
            System.out.println(preScore[0] + ip.get(i - 2) + ip.get(i - 1) + ip.get(i));
            // 更新当前得分，前三次得分
            curScore = curTotalScore;
            preScore[0] = preScore[1];
            preScore[1] = preScore[2];
            preScore[2] = curTotalScore;
            System.out.println(Arrays.toString(preScore));
        }

        System.out.println(curScore);
    }
}
