package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 一条长 l 的街道有 n 个路灯，街道起点0，终点l，第i个路灯坐标a[i]，每盏灯最远覆盖距离 d ，
 * 所有灯光覆盖整条街，为了省电使d最小，求最小d；
 *
 * 输入：
 * 第一行两个整数n 和 l，0 <= n <= 1000，0 <= l <= 1,000,000,000
 * 第二行 n 个整数（均大于等于0小于等于l）为每盏灯的坐标，***多个路灯可以在同一点***
 * 输出：
 * 最小的d，保留两位小数
 *
 * 示例1
 * 输入
 * 7 15
 * 15 5 3 7 9 14 0
 *
 * 思路：
 * 灯光覆盖距离d，则两灯之间距离取一半的距离使其最大，即最小的d
 * 特殊情况：第一个和最后一个路灯距离不能减半
 * 保留小数的方法两种：
 * String.format("%.2f",f);
 * DecimalFormat df = new DecimalFormat("#.00");
 * df.format(f);
 */
public class B5路灯照明 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }

        a.sort(Comparator.comparingInt(o -> o));
        // 首尾灯距离街道头尾的距离
        int d0 = a.get(0);
        int dl = l - a.get(n -1);
        double d = Math.max(d0, dl);

        for (int i = 1; i < n; i++) {
            double distance = (a.get(i) - a.get(i-1)) / 2.00;
            d = Math.max(d, distance);
        }
        System.out.println(String.format("%.2f",d));
    }
}
