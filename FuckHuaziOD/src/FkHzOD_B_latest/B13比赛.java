package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|13|比赛|数据结构|100|
 * 一个有N个选手参加比赛，选手编号为1~N(3<=N<=100)，有M(3<=M<=10)个评委对选手进行打分
 * 打分规则为每个评委对选手打分，最高分10分，最低分1分。
 * 请计算得分最多的前3位选手的编号。
 * 如果得分相同，则得分高分值最多的选手排名靠前，
 * 10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
 *
 * 输入描述
 * 第一行为半角逗号分割的两个正整数M,N，第一个数字表示M(3<=M<=10)个评委，第二个数字表示N(3<=N<=100)个选手
 * 第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推.
 * 输出描述
 * 选手前3名的编号
 * 注:若输入为异常，输出-1，如M、N、打分不在范围内。
 *
 * 示例1
4,5
10,6,9,7,6
9,10,6,7,5
8,10,6,5,10
9,10,8,4,9
 * 输出：
 * 2,1,5
 * 说明：4个评委，5个选手，分数矩阵4*5，
 * 竖着看一列是每一选手的评分，每一行代表一个评委对选手的打分排序，
 * 2号选手得36排第一，1号36分，但是2号的10分有3个，
 *
 * 示例2
4,2
8,5
5,6
10,4
8,9
 * 输出：
 * -1
 * 只有两名选手参加，要求至少3名
 *
 * 示例3
2,5
7,3,5,4,2
8,5,4,4,3
 * 输出 -1，要求至少3个评委
 *
 * 示例4
4,5
11,6,9,7,8
9,10,6,7,8
8,10,6,9,7
9,10,8,6,7
 * 输出：
 * -1
 * 评委打分11，分数无效
 *
 *
 */
public class B13比赛 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] mn = in.nextLine().split(",");
        // m个评委，m行，n个选手，n列
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        if (m < 3 || n < 3) {
            System.out.println(-1);
            return;
        }
        List<List<Integer>> lists = new ArrayList<>();
        int[] score = new int[n];
        int[] player = new int[n];
        for (int i = 0; i < m; i++) {
            List<Integer> list = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            list.forEach(integer -> {
                if (integer < 1 || integer > 10){
                    System.out.println(-1);
                    return;
                }
            });
            for (int j = 0; j < n; j++) {
                score[j] += list.get(j);

            }
            lists.add(list);
        }

        System.out.println(Arrays.toString(player));
        Arrays.sort(score);
        int first = score[score.length - 1];
        int second = score[score.length - 2];
        int third = score[score.length - 3];
    }
}
