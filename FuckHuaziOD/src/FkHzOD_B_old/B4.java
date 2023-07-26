package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|4|事件推送|数据结构|100|
 * 同一个数轴 `X` 上有两个点的集合 `A={A1, A2, …, Am}` 和 `B={B1, B2, …, Bn}`，
 * `Ai` 和 `Bj` 均为正整数，`A`、`B` 已经按照从小到大排好序，`A`、`B` 均不为空，
 * 给定一个距离 `R` (正整数)，
 * 列出同时满足如下条件的所有（`Ai, Bj`）数对：
 *
 *
 * 1. `Ai <= Bj`
 * 2. `Ai`, `Bj` 之间的距离小于等于 `R`
 * 3. 在满足 `1`,`2` 的情况下，每个 `Ai` 只需输出距离最近的 `Bj`
 * 4. 输出结果按 `Ai` 从小到大的顺序排序
 *
 *
 * ## 输入
 * 第一行三个正整数 `m`，`n`，`R`
 * 第二行 `m` 个正整数，表示集合 `A`
 * 第三行 `n` 个正整数，表示集合 `B`
 * 输入限制：
 * `1 <= R <= 100000`，`1 <= n,m <= 100000`，`1 <= Ai,Bj <= 1000000000`
 *
 * ## 输出
 * 每组数对输出一行 `Ai` 和 `Bj`，以空格隔开
 *
 *
 * ## 示例一
 *
 * ### 输入
 *
 * ```plaintext
 * 4 5 5
 * 1 5 5 10
 * 1 3 8 8 20
 * ```
 *
 * ### 输出
 *
 * ```plaintext
 * 1 1
 * 5 8
 * 5 8
 * ```
 *
 * 思路：循环遍历两个数组判定以上4个条件（第4个已经满足
 */
public class B4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int R = in.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            A.add(in.nextInt());

        }
        for (int i = 0; i < n; i++) {
            B.add(in.nextInt());
        }

        for (int i = 0; i < A.size(); i++) {
            // min记最短距离
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < B.size(); j++) {
                int d = B.get(j) - A.get(i);
                if (A.get(i) <= B.get(j) && (d <= R)) {
                    if (min > d) {
                        min = d;
                        System.out.println(""+A.get(i)+" "+B.get(j));
                    }
                }
            }
        }
    }
}
