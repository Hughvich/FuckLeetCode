package FkHzOD_B_old;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B|87|观看文艺汇演问题/计算最多能看几场演出|区间问题|100|
 * 多场文艺表演，很多都是同时进行，一个人只能同时观看一场演出，不能迟到早退，
 * 演出分布在不同演出场地，连续观看的演出至少有15分钟的时间间隔；
 * 小明想尽可能看多的演出，给出演出时间表，计算他最多能看几场演出
 *
 * 输入描述：第一行：一个数N，表示演出场数，1<=N<=1000，接下来N行，每行有被空格分割的两个整数
 * 第一个整数T表示演出开始的时间，第二个整数L表示演出的持续时间，T和L单位为分钟，0<=T<=1440 0<L<=100？
 *
 * 输出：
 * 最多能观看的演出场数
 *
 * 示例：
 * 输入：
 * 2
 * 720 120
 * 840 120
 * 输出：
 * 1
 *
 * 思路：
 * 前一场开始时间T + L + 15 <= 后一场开始时间T
 * 用一个嵌套List，一个循环算出来
 */
public class B87观看文艺汇演问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            lists.add(Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        in.close();

        int sum = 1;
        for (int i = 0; i < n - 1; i++) {
            if (lists.get(i).get(0) + lists.get(i).get(1) + 15 <= lists.get(i + 1).get(0)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
