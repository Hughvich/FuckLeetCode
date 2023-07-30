package FkHzOD_B_old;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|16|太阳能板最大面积|双指针|100|
 * 给航天器一侧加装长方形或正方形的太阳能板（图见imgOfB16.png）,
 * 需要先安装两个支柱（黑色竖条），再在支柱中间部分固定太阳能板，
 * 但是支柱长度不同，太阳能板安装面积受限于最短一侧那根支柱长度；
 * 现提供一组整型数组的支柱高度数据，假设每根支柱距离相等且为1个单位长度，
 * 计算如何选择两根支柱使太阳能板面积最大。
 *
 * 输入：支柱至少2根，最多10000根，能支持的高度范围1~10^9整数，
 * ***注意：支柱高度排列无序***
 * 输出：可以支持的最大太阳能板面积
 *
 * 示例：
 * 输入：10,9,8,7,6,5,4,3,2,1
 * 输出：25（10米柱和5米柱之间，5*5 = 25）
 *
 * 思路：
 * 两种方法：
 *      暴力法：两轮遍历，求每个柱子间的面积
 *      双指针：初始数组两端，循环将短板向内移一格，更新面积最大值，两指针相遇时跳出
 */
public class B16太阳能板最大面积 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        List<Integer> ip = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        // 暴力法
        int square;
        int max = 0;
        /*
        for (int i = 0; i < ip.size(); i++) {
            for (int j = 1; j < ip.size(); j++) {
                square = Math.min(ip.get(i),ip.get(j)) * Math.abs(ip.get(i) - ip.get(j));
                if (square > max) {
                    max = square;
                }
            }
        }

         */

        // 双指针法
        int left = 0;
        int right = ip.size() - 1;
        while(left != right) {
            int shorter = Math.min(ip.get(left), ip.get(right));
            square = shorter * Math.abs(ip.get(left) - ip.get(right));
            max = Math.max(max, square);
            if (shorter == ip.get(left)) {
                left++;
            } else right--;
        }
        // 也可以用三目运算
//        while (left < right) {
//            int x = right - left;
//            int y = ip.get(left) < ip.get(right) ? ip.get(left++) : ip.get(right--);
//            max = Math.max(max, x * y);
//        }
        System.out.println(max);
    }
}
