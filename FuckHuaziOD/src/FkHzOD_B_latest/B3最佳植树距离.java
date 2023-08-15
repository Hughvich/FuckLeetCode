package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|3|最佳植树距离|逻辑分析|100|
 * 可中枢坑位数量和位置，多少棵；
 * 树苗最小间距 最多是多少？
 *
 * 输入：
 * 第一行：坑位数
 * 第二行：空格数组，坑位位置
 * 第三行：需要棵数量
 * 输出：
 * 树苗最小间距
 * 输入：
 * 7
 * 1 3 6 7 8 11 13
 * 3
 * 输出：
 * 6
 * 三树苗分别在1，7，13位置，保证最小间距为6
 *
 * 力扣LC原题
 * 思路：
 * 在[l,r]区间查找，每次取mid为l和r平均值，
 * 如果当前mid合法，令ans=mid，区间缩小为[mid+1,r]，不合法则缩小为[l,mid-1]
 * 合法的含义：
 * 最小间距和数量的关系：间距越大，数量越小，
 * 间距往小里取，数量越来愈大，大到超过m时，这时的间距是最大的
 *
 */
public class B3最佳植树距离 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
        }
        int m = in.nextInt();
        Arrays.sort(pos);

        int len = pos.length;
        int l = 1;
        //
        int r = (pos[len - 1] - pos[0]) / (m - 1);
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // 相邻两点间距离>=mid的个数cnt，第一个位置种一棵
            int cnt = 1;
            // 选第一个位置为目前位置
            int last = pos[0];
            for (int i = 0; i < n; i++) {
                // 如果遍历到的位置和目前位置的距离大于等于平均距离，就种树++
                if (pos[i] - last >= mid) {
                    last = pos[i];
                    cnt++;
                }
            }

            if (cnt >= m)
                // 最优解在右半区间
                l = mid;
            // 否则在左半区间
            else r = mid - 1;

        }
        System.out.println(l);

    }
}
