package FkHzOD_B_old;

import java.util.Scanner;

/**
 * B|38|计算最大乘积|数据结构|100|
 * 给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素长度乘积的最大值，
 * 如果没有符合条件的两个元素，返回0。
 *
 * 输入描述
 * 输入为一个半角逗号分隔的小写字符串的数组，2 <= 数组长度<=100，0 < 字符串长度<= 50。
 * 输出描述
 * 两个没有相同字符的元素 长度乘积的最大值。
 *
 * 示例：
 * 输入
 * qwerty,asd,qwesd,eraffa,qzxca
 * 输出：
 * 18（数组中有5个元素。
 * qwerty与asd无相同的字符，满足条件，qwerty的长度为6，asd的长度为3，乘积为18。
 *
 * 示例2：
 * 输入
 * iwdvpbn,hk,iuop,iikd,kadgpf
 * 输出
 * 14（数组中有5个元素。
 * iwdvpbn 与 hk 无相同的字符，满足条件，iwdvpbn 的长度为7，hk 的长度为2，乘积为14。
 *
 * 思路：
 * 双重遍历直接暴力
 * 其实是两层套两层：外两层是每个单词互相比，内两层是两个单词的每个字母互相比
 *
 */
public class B38计算最大乘积 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ip = in.nextLine().split(",");
        int maxMul = 0;
        for (int i = 0; i < ip.length - 2; i++) {
            for (int j = i + 1; j < Math.min(ip[i+1].length(),ip[i].length()); j++) {
                int mul = ip[i].length() * ip[j].length();
                if (mul > maxMul) {
                    boolean isPublic = false;
                    for (int m = 0; m < ip[i].length(); m++) {
                        for (int n = 0; n < ip[j].length(); n++) {
                            if (ip[i].charAt(m) == ip[j].charAt(n)) {
                                isPublic = true;
                                break;
                            }
                        }
                    }
                    if (!isPublic)
                        maxMul = mul;
                }
            }
        }
        System.out.println(maxMul);
    }
}
