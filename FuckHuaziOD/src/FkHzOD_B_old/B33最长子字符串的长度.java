package FkHzOD_B_old;

import java.util.Scanner;

/**
 * B|33|最长子字符串的长度|逻辑模拟|100|
 * 给一个字符串s，字符串s首尾相连成一个环形，在环中找出‘o’字符出现了偶数次最长子字符串的长度
 * 输入：一串小写字母组成的字符串
 * 输出：一个整数
 * 示例1：
 * 输入：alolobo
 * 输出：6（alolob包含两个o）
 * 示例2：
 * 输入：looxdolx
 * 输出：7（oxdolxl包含两个o）
 * 示例3：
 * 输入：bcbcbc
 * 输出：6（本身就是最长，包含0个o）
 *
 * 思路：
 * 环形字符串，从哪开始都行，
 * 如果o出现次数为奇数，就直接以其中一个o的下一个字符为起点，字符串长度length - 1 即为所求；
 * 如果o出现偶数次或0次，整个字符串length为所求；
 */
public class B33最长子字符串的长度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        int numO = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == 'o') numO++;
        }
        if (numO % 2 == 0) System.out.println(ip.length());
        else System.out.println(ip.length() - 1);
    }
}
