package Arrays;

import java.util.Arrays;

/**
 * LC#59.Medium
 * 螺旋矩阵II
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，
 * 且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 * 图示见generateMatrix59.jpg
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 过程：模拟顺时针画矩阵的过程，一圈：上行→ 右列↓ 下行← 左列↑
 *  建一个二维数组，开始坐标（0,0）
 *  嵌套循环：for n/2 圈（for 每圈 上下左右 向前赋值，左闭右开）
 *  每走一圈，开始位置(+1,+1) , 上下左右范围 -1
 *  n为奇数，需要单独处理中心值，n为偶数不需要
 */
public class GenerateMatrix59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int x0 = 0;
        int y0 = 0;
        int mid = n / 2; //中心坐标
        int offset = 1;

        // 循环一圈，一共要循环 (int) n / 2圈
        for (int i = 0; i < n / 2; i++) {
            // x, y坐标
            int x;
            int y;
            // 上行→，移动y，x坐标在最上行/初始
            for (y = y0; y < n - offset; y++) {
                matrix[x0][y] = count++;
            }
            // 右列↓，移动x，y坐标已经移到最右列
            for (x = x0; x < n - offset; x++) {
                matrix[x][y] = count++;
            }
            // 下行←，移动y，x坐标已经移到最下行
            for (; y > y0; y--) {
                matrix[x][y] = count++;
            }
            // 左列↑，移动x，y坐标已经移到最左列
            for (; x > x0; x--) {
                matrix[x][y] = count++;
            }
            // 起始xy坐标 +1
            x0++;
            y0++;
            // 向内移一格
            offset++;
        }
        // n为奇数，需要单独处理中心值，n为偶数不需要
        if (n % 2 == 1) {
            matrix[mid][mid] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(25);
        for ( int[] m:
        matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
