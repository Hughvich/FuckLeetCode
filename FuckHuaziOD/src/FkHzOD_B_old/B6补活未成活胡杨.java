package FkHzOD_B_old;

import java.util.Scanner;

/**
 * B|6|补活未成活胡杨|滑动窗口|100|
 * 沙漠新种植胡杨N棵，编号1 - N，排成一排，一个月后，有M棵未能成活；
 * 现可补种胡杨K棵，怎样补可以得到最多的连续胡杨树？
 *
 * 输入：
 * N 总种植量 1 <= N <= 100000
 * M 未成活量 1 <= M <= N
 * M个空格分隔的数，编号从小到大排列
 * K 最多可以补种的数量 0 <= K <= M
 *
 * 输出：
 * 最多的连续棵数
 *
 * 示例1
 * 输入：
 * 5
 * 2
 * 2 4
 * 1
 *
 * 输出：
 * 3
 *
 * 示例2：
 * 输入：
 * 10
 * 3
 * 2 4 7
 * 1
 * 输出：
 * 6
 *
 * 思路：
 * 滑动窗口法，设定好左边界右边界，保证中间有K棵树可以补种，求左边界和右边界最大差值
 */
public class B6补活未成活胡杨 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /* N 总种植量 1 <= N <= 100000
        * M 未成活量 1 <= M <= N
        * 数列m - M个空格分隔的数，编号从小到大排列
        * K 最多可以补种的数量 0 <= K <= M
         */
        int N = in.nextInt();
        int M = in.nextInt();
        int[] m = new int[M];
        for (int i = 0; i < M; i++) {
            m[i] = in.nextInt();
        }
        int K = in.nextInt();

        /*
        N=10, M=3, m=[2,4,7], K=1
        共种5，死了3，分别在2，4，7，补种1，
        1,(2),3,(4),5，6,(7),8,9,10种在7，左右差（10-5+1）是6
        0-2的3次循环：l=0,r=3; l=2,r=6; l=4,r=10

        N=5，M=2，m=[2,4]，K=1
        共种5，死了2，分别在2，4，补种1，
        1,(2),3,(4),5，
        0-1的2次循环：l=0，r=3，l=2，r=5
         */

        // 滑动窗口
        int max = 0;
        // M - K ：种完K棵后还有多少死树坑？
        // 左开右闭区间(left, right]
        for (int i = 0; i <= M - K; i++) {
            int left = 0;
            int right = N;

            if (i>0) {
                // left往左每次一格走
                left = m[i-1];
//                System.out.println("if1");
            }

            // i + K：种了K棵后的死树坑，-1坑左边一格就是右边界
            if (i + K < M) {
                right = m[i + K] - 1;
//                System.out.println("if2");
            }

            int temp = right - left;
            if (temp > max) {
                max = temp;
            }
            System.out.println("right= " + right);
            System.out.println("left= " + left);
        }
        System.out.println(max);

    }
}
