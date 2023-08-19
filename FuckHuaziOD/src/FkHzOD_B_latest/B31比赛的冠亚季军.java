package FkHzOD_B_latest;

import java.util.*;

/**
 * B|31|比赛的冠亚季军|排序算法|100|
 * 有N ∈[3,10000)个运动员，他们的id为0到N-1，他们的 实力 由一组整数表示。他们之间进行比赛，需要决出冠亚季军。
 * 比赛规则是，0号和1号比赛，依次类推，相邻的运动员比赛，获胜的进入下轮；
 * 实力值大的获胜，实力值相等的情况，id小的获胜；轮空的 直接进入下一轮；
 * 输入描述：一行，N个数字表示N个运动员的实力值 ∈ [0,10000000000]
 * 输出描述：冠亚季军的id，空格隔开
 * 示例1：
 * 2 3 4 5
 * 输出：
 * 3 1 2
 * 说明：2和3比赛，3胜出，4和5比赛，5胜出；
 * 5就是冠军，3亚军，2和4比赛，4胜出为季军，按id就是3 1 2
 *
 * 示例2：
 * 34 85 28 48 22 28 48 39 1
 *
 * 思路：
 * 第一步按照条件对胜者组和败者组进行分类
 * 对各组内的运动员进行自定义排序
 * 实现：
 * 定义运动员类athlete实现comparable接口
 * 定义胜者列表，败者列表
 * 递归了。！
 *
 *          10
 *         8  10                 9
 *      4   8   10              7 9
 *    2  4  6  8  10          3  7  9
 * 1 2 3 4 5 6 7 8 9 10    1  3  5  7  9
 */
public class B31比赛的冠亚季军 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Athlete> athletes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Athlete athlt = new Athlete(i, nums[i]);
            athletes.add(athlt);
        }

        List<Athlete> win = new ArrayList<>();
        List<Athlete> lose = new ArrayList<>();
        // 递归比赛
        compete(athletes, win, lose);
        Collections.sort(win);
        Collections.sort(lose);

        System.out.println(win.get(0).id + " " + win.get(1).id + " " + lose.get(0).id);

    }

    // 核心方法，递归地比赛
    public static void compete(List<Athlete> athletes, List<Athlete> win, List<Athlete> lose) {
        // 等待下一轮比赛的列表result
        List<Athlete> result = new ArrayList<>();
        int len = athletes.size();
        // 两两比赛
        for (int i = 0; i < len; i+=2) {
            Athlete a1 = athletes.get(i);
            // 如果赛到最后一个人，直接晋级
            if (i == len - 1) {
                result.add(a1);
                // 如果3人比赛，最后一人直接胜出
                if (len == 3)
                    win.add(a1);
                break;
            }
            Athlete a2 = athletes.get(i + 1);
            // 取出相邻两人比赛
            if (a1.score >= a2.score) {
                result.add(a1);
                if (len <= 4) {
                    win.add(a1);
                    lose.add(a2);
                }
            } else {
                result.add(a2);
                if (len <= 4) {
                    win.add(a2);
                    lose.add(a1);
                }
            }
        }
        // 递归比赛，直到只剩两个
        if(result.size() >= 3)
            compete(result, win, lose);
    }

    public static class Athlete implements Comparable<Athlete> {
        int id;
        int score;

        public Athlete(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Athlete athlete) {
            // 如果分数相同，按id升序，如果不同，按分数降序
            if (this.score == athlete.score)
                return this.id - athlete.id;

            return athlete.score - this.score;
        }
    }
}

