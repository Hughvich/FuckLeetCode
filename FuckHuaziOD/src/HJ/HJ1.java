package HJ;

import java.util.Scanner;

/**
 *
 * HJ1 - Easy
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入：
 * hello nowcoder
 * 输出：
 * 8
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 *
 * 思路：
 * 用charAt和空格比较，如果是空格就到了头，否则就++记数
 * 要注意只有一个字符串的边界情况
 *
 */

public class HJ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = 0;
        while (in.hasNext()) {
            String a = in.nextLine().trim(); //切除首尾空格
            int l = a.length() - 1;
            for (int i = l; i >= 0; i--) {
//                System.out.println("l = " + l);
                if (a.charAt(i) != ' ') {
                    len++;
//                    System.out.println("len= " + len);
                    // 边界情况：如果只有一个字符串（没有空格）
                    if (len == a.length()) {
                        System.out.println(len);
                        len = 0;
                        break;
                    }
                } else if (len > 0) {
                    System.out.println(len);
                    len = 0;
                    break;
                }
            }
        }
    }
}
