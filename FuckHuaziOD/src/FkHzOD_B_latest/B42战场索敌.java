package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|42|战场索敌|DFS|200|
 * 有一个大小是N*M的战场地图，被墙壁 '#' 分隔成大小不同的区域，
 * 上下左右四个方向相邻的空地 '.'，属于同一个区域，只有空地上可能存在敌人'E'，
 * 请求出地图上总共有多少区域里的敌人数小于K。
 * 输入描述
 * * 第一行输入为N.M.K;
 * N表示地图的行数，M表示地图的列数，K表示目标敌人数量
 * N，M<=100
 * 之后为一个NxM大小的字符数组
 * 输出描述
 * 敌人数小于K的区域数量
 * 示例1：输入
3 5 2
..#EE
E.#E.
###..
 * 输出
 * 1
 * 说明:地图被墙壁分为两个区域，左边区域有1个敌人，右边区域有3个敌人，符合条件的区域数量是1
 *
 * DFS用于图的遍历：可以遍历整个图，找到所有的连通分量。
 * BFS最短路径问题：BFS可以用来求解无权图的最短路径问题。
 */
public class B42战场索敌 {
    public static int[][] visited;
    public static int[][] dir = { {-1,0}, {1,0}, {0,1}, {0,-1} };
    public static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        visited = new int[n][m];
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < m; j++) {
                mat[i][j] = line.charAt(j);
            }
        }

        int res = 0;
        // 核心逻辑：
        // 双循环n*m，如果碰到#则跳下一个循环；
        // dfs算法：visited置1，碰到E，count++，
        // 上下左右四个方向加上dir，如果在nm界限内，visited为0，且不是#，就递归
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '#' || visited[i][j] == 1)
                    continue;
                count = 0;
                dfs(i, j, n, m, mat);
                // 如果满足小于k的Enemy，满足区域+1
                if (count < k)
                    res++;
            }
        }

        System.out.println(res);

    }

    private static void dfs(int i, int j, int n, int m, char[][] mat) {
        visited[i][j] = 1;

        if (mat[i][j] == 'E')
            count++;

        for (int k = 0; k < 4; k++) {
            int X = i + dir[k][0];
            int Y = j + dir[k][1];

            if (X >= 0 && X < n && Y >= 0 && Y < m && mat[X][Y] != '#' && visited[X][Y] == 0)
                dfs(X, Y, n, m, mat);
        }
    }

}
