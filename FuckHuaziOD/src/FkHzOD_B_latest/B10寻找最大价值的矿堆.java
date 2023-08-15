package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|10|寻找最大价值的矿堆|DFS|100|
 * 由0空地，1银矿，2金矿，组成的地图，矿堆只能由上下左右相邻的金矿或银矿连接形成，超出地图范围的是空地
 * 假设银矿价值1，金矿价值2，输出地图中最大的矿堆价值
 * 示例1输入：范围最大300*300，地图元素0-2个
22220
00000
00000
11111
 * 输出：8
 *
 * 示例2：
20000
00020
00000
00111
 * 输出：3
 *
 * 示例3：
22220
00020
00010
01111
 * 输出：15
 * 思路：
 * 经典的图DFS问题，需要确定输入行数列数
 * 和LCR.105岛屿最大面积相似，将面积换成最大价值
 *
 */
public class B10寻找最大价值的矿堆 {
    // 四个方向
    public static int[][] dir = { {-1,0}, {1,0}, {0,1}, {0,-1} };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] mat = new int[300][300];

        int i = 0;
        while (in.hasNextLine()) {
            String ip = in.nextLine();
            if (ip.isEmpty()) break;
            for (int j = 0; j < ip.length(); j++) {
                mat[i][j] = Integer.parseInt(String.valueOf(ip.charAt(j)));
            }
            i++;

        }

        int maxVal = 0;
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                maxVal = Math.max(maxVal, dfs(0, x, y, mat));
            }
        }
        System.out.println(maxVal);
    }

    // 广度优先寻找最大值
    public static int dfs (int maxVal, int x, int y, int[][] mat) {
        if (mat[x][y] == 0)
            return maxVal;

        maxVal += mat[x][y];
        mat[x][y] = 0;

        // 四个方向
        for (int i = 0; i < 4; i++) {
            int X = x + dir[i][0];
            int Y = y + dir[i][1];

            if (X >= 0 && X < 300 && Y >= 0 && Y < 300 && mat[X][Y] > 0)
                maxVal = dfs(maxVal, X, Y, mat);
        }
        return maxVal;
    }
}
