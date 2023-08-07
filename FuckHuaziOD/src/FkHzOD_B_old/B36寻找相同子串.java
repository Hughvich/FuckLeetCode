package FkHzOD_B_old;

import java.util.Scanner;

/**
 * https://blog.csdn.net/flyf___/article/details/131506884
 * B|36|寻找相同子串|字符串|100|
 * 给两个字符串t、p，要求从t中找到一个和p相同的连续子串，并输出该字符串在t的第一个字符的下标。
 *
 * 输入：
 * 两行，字符串t、p，且t的长度不小于p。
 * 输出：
 * 若能从t中找到一个和p相等的连续子串，则输出该子串第一个字符在t中的下标（从左到右依次为1，2，3，...）；
 * 若不能则输出‘NO’；若含多个，则选第一个。
 *
 * 实例：
 * 输入
 * AVERDXIVYERDIAN
 * RDXI
 * 输出
 * 4
 *
 * 思路
 * 可以用KMP算法
 *
 * 也可以如下直接str.startsWith()
 *
 */
public class B36寻找相同子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        String p = in.nextLine();
        boolean same = false;
        for (int i = 0; i < t.length(); i++) {
            if (t.startsWith(p, i)) {
                same = true;
                System.out.println(i + 1);
                break;
            }
        }
        if (!same)
            System.out.println("NO");
    }
}
