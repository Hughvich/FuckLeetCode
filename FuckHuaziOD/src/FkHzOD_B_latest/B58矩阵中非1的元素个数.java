package FkHzOD_B_latest;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * B|58|矩阵中非1的元素个数|BFS|200|
 * 存在一个m*n的二维数组，其成员取值范围为0，1，2。
 * 其中值为1的元素具备同化特性，每经过1S，将上下左右值为0的元素同化为1。
 * 而值为2的元素，免疫同化。将数组所有成员随机初始化为0或2，再将矩阵的[0,0]元素修改成1，
 * 在经过足够长的时间后求矩阵中有多少个元素是0或2(即0和2数量之和）
 * 输入描述
 * 输入的前两个数字是矩阵大小。后面是数字矩阵内容
 * 输出描述
 * 返回矩阵中非1的元素个数
 * 示例1：
 * 输入
4 4
0 0 0 0
0 2 2 2
0 2 0 0
0 2 0 0
 * 输出
 * 9
 * 说明
 * 输入数字前两个数字是矩阵大小。后面的数字是矩阵内容。
 * 起始位置(0,0)被修改为1后，最终只能同化矩阵为:
 * 1 1 1 1
 * 1 2 2 2
 * 1 2 0 0
 * 1 2 0 0
 * 所以矩阵中非1的元素个数为9
 *
 * 思路：BFS算法，
 * 用queue实现，四个方向if，
 *
 */
public class B58矩阵中非1的元素个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        mat[0][0] = 1;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0,0}); // add方法容量满时会抛出异常，offer返false
        int res = 1;

        while (!deque.isEmpty()) {
            int[] node = deque.poll();
            int x = node[0];
            int y = node[1];
            if (x + 1 < m && mat[x + 1][y] == 0) {
                mat[x + 1][y] = mat[x][y] + 1;
                res++;
                deque.offer(new int[] {x + 1, y});
            }
            if (x - 1 >= 0 && mat[x - 1][y] == 0) {
                mat[x - 1][y] = mat[x][y] + 1;
                res++;
                deque.offer(new int[] {x - 1, y});
            }
            if (y + 1 < n && mat[x][y + 1] == 0) {
                mat[x][y + 1] = mat[x][y] + 1;
                res++;
                deque.offer(new int[] {x, y + 1});
            }
            if (y - 1 >= 0 && mat[x][y - 1] == 0) {
                mat[x][y - 1] = mat[x][y] + 1;
                res++;
                deque.offer(new int[] {x, y - 1});
            }
        }
        System.out.println(m * n - res);
    }
}
