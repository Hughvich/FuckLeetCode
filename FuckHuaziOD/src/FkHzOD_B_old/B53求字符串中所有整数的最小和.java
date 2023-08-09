package FkHzOD_B_old;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|53|求字符串中所有整数的最小和|逻辑模拟|100|
 * 输入字符串s，输出s中包含所有整数的最小和
 * 字符串包含a-z A-Z 以及合法整数
 * 合法整数，正整数，一个或多个0-9组成，如 0 2 3 002 102
 * 负整数，负号 - 开头
 *
 * 示例
 * 输入：bb1234aa
 * 输出：10 (=1+2+3+4)
 *
 * 示例2：
 * 输入：bb12-34aa
 * 输出：-31 (=1+2-34)
 *
 * 思路：
 * 负数取最大，正数取最小
 * 负数：从前往后遍历一直到非数字
 * 正数：直接取个位数，打断和后面的数字连接
 *
 */
public class B53求字符串中所有整数的最小和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        StringBuilder negative = new StringBuilder();
        int[] postive = new int[1024];
        negative.append("-");
        int idx = 0;
        int ngtv = 0;
        for (int i = 1; i < ip.length(); i++) {
            System.out.println("i: " + i);
            if (ip.charAt(i - 1) == '-') {
                for (int j = i + 1; j < ip.length(); j++) {
                    System.out.println("j: " + j);
                    if (ip.charAt(j) >= '0' && ip.charAt(j) <= '9') {
                        negative.append(ip.charAt(j - 1));
                        System.out.println("neg: " + negative);
                    }
                        if (ip.charAt(j) < '0' || ip.charAt(j) > '9') {
                            ngtv = Integer.parseInt(negative.toString());
                            negative.delete(0, negative.length());
                            idx = j - 1;
                            break;
                        }
                }
            } else if (ip.charAt(i) >= '0' && ip.charAt(i) <= '9' && i > idx) {
                postive[i - 1] = Integer.parseInt(ip.substring(i, i + 1));
                System.out.println("pos: " + postive[i - 1]);
            }
        }
        int sum = Arrays.stream(postive).sum();
        System.out.println(sum + ngtv);
    }
}
