package HJ;

/**
 * HJ2 - Easy
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围：
 * 1≤n≤1000
 *
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 输出：
 * 2
 *
 * 思路：
 * 挨个遍历比对，忽略大小写equalsIgnoreCase()
 *
 */

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()) {
            String str = in.nextLine().toLowerCase();
            String target = in.nextLine().toLowerCase();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == target.charAt(0)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
