package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|17|稀疏矩阵|逻辑分析|100|
 * 给定一个矩阵，现需逐行逐列扫描矩阵，如果某一行或某一列内，
 * 存在连续出现的0的个数超过了行宽或者列宽的一半W/2整除，则认为该行/列是稀疏的
 * 扫描给定矩阵，输出稀疏的行数和列数
 *
 * 输入描述：第一行M,N为矩阵大小M*N，<=100
 * 后面M行是矩阵成员，每行N个成员，都是有符号整数，范围-32768到32767
 * 输出描述：
 * 第一行：稀疏行数，第二行：稀疏列数
 *
 * 示例1:
3 3
1 0 0
0 1 0
0 0 1
 * 输出：
 * 3
 * 3
 *
 * 实例2：
5 3
-1 0 1
0 0 0
-1 0 0
0 -1 0
0 0 0
 * 输出：
 * 5
 * 3
 * 思路：
 * 简单
 */
public class B17稀疏矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        int[][] mat = new int[M][N];
        // numsLine，numsCol分别记录每行，每列有多少个0
        int[] numsLine = new int[M];
        int[] numsCol = new int[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    numsLine[i]++;
                    numsCol[j]++;
                }
            }
        }

        int numLine = 0;
        int numCol = 0;
        for (int num : numsLine) {
            if (num >= N / 2)
                numLine++;
        }
        for (int num:numsCol) {
            if (num >= M / 2)
                numCol++;
        }

        System.out.println(Arrays.toString(numsLine));
        System.out.println(Arrays.toString(numsCol));

        System.out.println(numLine);
        System.out.println(numCol);

    }
}
