package FkHzOD_B_latest;

import java.util.*;
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
        int[][] scoreLists = new int[m][n];
        int[] scoreTotal = new int[n];
        for (int i = 0; i < m; i++) {
            int[] list = Arrays.stream(in.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                scoreLists[i][j] = list[j];
                scoreTotal[j] += list[j];
                if (scoreLists[i][j] < 1 || scoreLists[i][j] > 10) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(Arrays.toString(scoreTotal));

        //添加选手列表，scores是每个人的评分列表，先n.fori后m.forj，转置遍历add(scoreLists[j][i]),将原二维scoreLists抽出给Player对象
        ArrayList<Player> playerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> scores = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                scores.add(scoreLists[j][i]);
            }
            playerList.add(new Player(i, scoreTotal[i], scores));
        }

//        playerList.forEach(System.out::println);

        Collections.sort(playerList, (o1, o2) -> {
            // 比较总分，不等则降序
            if (o1.total != o2.total)
                return o2.total - o1.total;
            else {
                List<Integer> o1Scores = o1.scores;
                List<Integer> o2Scores = o2.scores;
                // 如果总分相同，两个列表进行比较从10到1的分数的个数
                for (int i = 10; i > 0; i--) {
                    int res1 = 0;
                    int res2 = 0;
                    for (int k = 0; k < o1Scores.size(); k++) {
                        if (o1Scores.get(k) == i)
                            res1++;
                        if (o2Scores.get(k) == i)
                            res2++;
                    }
                    if (res1 < res2)
                        return res1 - res2;
                }
            }
            return 0;
        });

        // 最后输出答案
        for (int i = 0; i < 3; i++) {
            if (i == 2)
                System.out.print(playerList.get(i).idx + 1);
            else
                System.out.print(playerList.get(i).idx + 1 + ",");
        }
    }

    public static class Player {
        int idx;
        int total;
        List<Integer> scores;

        public Player(int idx, int total, List<Integer> scores) {
            this.idx = idx;
            this.total = total;
            this.scores = scores;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "idx=" + idx +
                    ", total=" + total +
                    ", scores=" + scores +
                    '}';
        }
    }
}
