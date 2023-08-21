package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|36|跳格子2|逻辑分析|100|
 * 小明和朋友玩跳格子游戏，有n个连续格子组成的圆圈，每个各自有不同的分数，小朋友可以选择从任意的格子起跳，
 * 但是不能跳连续的格子，不能回头跳，也不能超过一圈
 * 给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数
 * 输入描述，给定一个数列，第一格和最后一格首尾相连，
 * 输出描述，得到的最高分
 *
 * 示例1：
 * 2 3 2
 * 输出
 * 3
 * 示例2：
 * 1 2 3 1
 * 输出
 * 4
 *
 * LC#213 打家劫舍II
 * 保证首尾两间不同时被偷窃：
 * 拆成两个队列，0到n-1，以及1到n，返回两个队列结果最大的
 *
 *
 */
public class B36跳格子2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //随便用例: 2 4 7 4 7 1 9 3
        List<Integer> a1 = list.subList(0, list.size() - 1);
        List<Integer> a2 = list.subList(1, list.size());

//        System.out.println(a1);
//        System.out.println(a2);

        if (list.size() == 3) {
            list.sort(Comparator.comparingInt(o -> o));
            System.out.println(list.get(list.size() - 1));
            return;
        }
        if (list.size() == 2) {
            System.out.println(Math.max(list.get(0), list.get(1)));
            return;
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }

        int sumA11 = 0; //a1从1开始
        int sumA21 = 0; //a1从1开始
        int sumA10 = 0; //a2从0开始
        int sumA20 = 0; //a2从0开始
        for (int i = 1; i < a1.size(); i+=2) {
            sumA11 += a1.get(i);
            sumA10 += a1.get(i - 1);
            sumA21 += a2.get(i);
            sumA20 += a2.get(i - 1);
        }
        sumA10 += a1.get(a1.size() - 1);
        sumA20 += a2.get(a2.size() - 1);
        int sumA1 = Math.max(sumA10, sumA11);
        int sumA2 = Math.max(sumA21, sumA20);

        int max = Math.max(sumA1, sumA2);
        System.out.println(max);
    }
}
