package FkHzOD_B_old;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|40|符合要求的结对方式|逻辑模拟|100|
 * 用一个数组A代表程序员的工作能力，公司想通过 结对编程 的方式提高员工的能力，
 * 假设结对后的能力为两个员工能力之和，求一共有多少种结对方式使结对后能力为N
 *
 * 输入：第一行：员工总数，范围1~1000
 * 第二行：数组A的元素，范围同上
 * 第三行：N的值，范围同上
 *
 * 输出：满足结对后能力为N的 结对方式 总数
 * 示例：
 * 5
 * 1 2 2 2 3
 * 4
 * 输出：
 * 4
 * 满足要求的结对方式为A[0]和4，1和2，1和3，2和3
 *
 * 思路 只有一个：诉诸暴力
 */
public class B40符合要求的结对方式 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int N = in.nextInt();
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] + A[j] == N)
                    sum++;
            }
        }
        System.out.println(sum);
    }
}
