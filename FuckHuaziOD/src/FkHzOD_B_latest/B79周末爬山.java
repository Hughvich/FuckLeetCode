package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * B|79|周末爬山|BFS|200|
 * 周末小明准备去爬山，0代表平地，山的高度1到9表示，
 * 小明每次爬山或下山高度只能相差k及k以内，每次只能上下左右一个方向移动一格，
 * 从（0，0）左上角位置出发，
 * 输入：第一行m n k空格分隔，代表m*n二维山，k为每次爬上山或下山高度差的最大值，
 * 接下来m行n列为二维山；m,n<= 500, 0 < k < 5
 * 输出：小明能爬到的最高峰的高度，以及最短步数，空格分隔
 * 示例1
5 4 1
0 1 2 0
1 0 0 0
1 0 1 2
1 3 1 0
0 0 0 9
 * 输出：2 2
 * 说明：能爬到的最高峰在（0，2），高度为2，
 *      最短路径(0,0) - (0,1) - (0,2)，最短步数2
 * 示例2
5 4 3
0 0 0 0
0 0 0 0
0 9 0 0
0 0 0 0
0 0 0 9
 * 输出：0 0
 * 说明：每次爬山距离3，无法爬到山上
5 4 1
0 1 1 3
1 1 4 0
4 9 0 0
0 0 0 0
0 0 0 9
 *
 * 思路：
 * BFS，图遍历，二叉树的 ”层序遍历“：一层一层遍历，需要《队列》数据结构；
 * 科普链接：https://zhuanlan.zhihu.com/p/136183284
 * k值，为当前位置和下一个位置的差值最大值，如果差值超过k，走不过去
 *
 */
public class B79周末爬山 {
    // ？？？的count
    public static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();

        int[][] mountains = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mountains[i][j] = in.nextInt();
            }
        }
        // 用于？？？的map，key是山高度，value是
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(mountains[0][0], 0);
        // 用于？？？的stack
        ArrayList<int[]> stack = new ArrayList<>();
        stack.add(new int[] {0, 0});
        // 用于当前/访问记录
        int[][] visited = new int[m][n];
        visited[0][0] = 1;

        while (stack.size() > 0) {
            // emptyStack有什么用？？？
            ArrayList<int[]> emptyStack = new ArrayList<>();
            count++;
            for (int i = 0; i < stack.size(); i++) {
                int x = stack.get(i)[0];
                int y = stack.get(i)[1];
                int lastHeight = mountains[x][y];

                // 四个代码块，代表？？？
                // x始终要在[0, m)范围，没有访问过的，和当前距离<=k的，访问记录则置1，将(x + 1, y)的记录
                if (x + 1 < m) {
                    if (visited[x + 1][y] == 0) {
                        if (Math.abs(mountains[x + 1][y] - mountains[x][y]) <= k) {
                            visited[x + 1][y] = 1;
                            if (!map.containsKey(mountains[x + 1][y]) || map.get(mountains[x + 1][y]) > count)
                                map.put(mountains[x + 1][y], count);
                            emptyStack.add(new int[] {x + 1, y});
                        }
                    }
                }

                if (x - 1 >= 0) {
                    if (visited[x - 1][y] == 0) {
                        if (Math.abs(mountains[x - 1][y] - mountains[x][y]) <= k) {
                            visited[x - 1][y] = 1;
                            if (!map.containsKey(mountains[x - 1][y]) || map.get(mountains[x - 1][y]) > count)
                                map.put(mountains[x - 1][y], count);
                            emptyStack.add(new int[] {x - 1, y});
                        }
                    }
                }

                if (y - 1 >= 0) {
                    if (visited[x][y - 1] == 0) {
                        if (Math.abs(mountains[x][y - 1] - mountains[x][y]) <= k) {
                            visited[x][y - 1] = 1;
                            if (!map.containsKey(mountains[x][y - 1]) || map.get(mountains[x][y - 1]) > count)
                                map.put(mountains[x][y - 1], count);
                            emptyStack.add(new int[] {x, y - 1});
                        }
                    }
                }

                if (y + 1 < n) {
                    if (visited[x][y + 1] == 0) {
                        if (Math.abs(mountains[x][y + 1] - mountains[x][y]) <= k) {
                            visited[x][y + 1] = 1;
                            if (!map.containsKey(mountains[x][y + 1]) || map.get(mountains[x][y + 1]) > count)
                                map.put(mountains[x][y + 1], count);
                            emptyStack.add(new int[] {x, y + 1});
                        }
                    }
                }
                System.out.println("map: " + map);
                System.out.println("visited: " + Arrays.deepToString(visited));
                System.out.println("------stack:----------");
                stack.forEach(o -> System.out.println(Arrays.toString(o)));
                System.out.println("------emptyStack:----------");
                emptyStack.forEach(o -> System.out.println(Arrays.toString(o)));
            }

            stack = emptyStack;
        }

        int maxHeight = 0;
        for (Integer key : map.keySet()) {
            maxHeight = Math.max(maxHeight, key);
        }
        System.out.println(maxHeight + " " + map.get(maxHeight));
    }
}
