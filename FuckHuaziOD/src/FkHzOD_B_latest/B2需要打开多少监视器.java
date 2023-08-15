package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|2|需要打开多少监视器|逻辑分析|100|
 * 长方形停车场，每个车位上都有对应监控器，当且仅当在 当前车位 或者 前后左右四个方向任 意一个车位范围停车时，
 * 监控器才需要打开：给出某一时刻停车场停车分布，请统计最少需要打开多少个监视器
 *
 * 输入：第一行m，n表示长宽，1< m,n <= 20
 * 后面m行，每行n个0或1的整数，表示停车情况，0为空，1已停
 * 输出：最少需要监控器的数量
 *
 * 示例1：
3 3
0 0 0
0 1 0
0 0 0
 * 输出：5
 * 中间1，及其上下左右，共5个监视器
 *
 * 思路：
 * 直接遍历
 *
 */
public class B2需要打开多少监视器 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            lists.add(Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        }

        // 四个方向，下上左右
        int [][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断停车位 上面的
                if (lists.get(i).get(j) == 1) {
                    res++;
                    continue; //必须记得continue，自己是1就不用判断自己是别人的1
                }

                // 四个方向, k = 0 - 4
                for (int k = 0; k < 4; k++) {
                    // 坐标x,y实际上是为1的坐标中心点，ij是偏移后的，看是否在m和n的范围内
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];


                    if (x >= 0 && x < m && y >= 0 && y < n && lists.get(x).get(y) == 1) {
                        res++;
                        break;
                    }
                }

            }
        }

        System.out.println(res);

    }
}
