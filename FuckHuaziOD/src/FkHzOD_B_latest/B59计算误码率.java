package FkHzOD_B_latest;

import java.util.Scanner;

/**
 * B|59|计算误码率|逻辑分析|200|
 * 误码率是最常用的数据通信传输质量指标。它可以理解为“在多少位数据中出现一位差错”。
 * 移动通信 网络中的误码率主要是指比特误码率，其计算公式如下:比特误码率=错误比特数/传输总比特数。
 * 为了简单，我们使用字符串来标识通信的信息，一个字符错误了，就认为出现了一个误码输入一个标准的字符串，
 * 和一个传输后的字符串，计算误码率字符串会被压缩。
 * 例:“2A3B4D5X1Z”表示"AABBBDDDDXXXXXZ"
 * 用例会保证两个输入字符串解压后长度一致，解压前的长度不一定一致每个生成后的字符串长度<100000000.
 * 输入描述
 * 两行，分别为两种字符串的压缩形式。
 * 每行字符串(压缩后的) 长度<100000
 * 输出描述
 * 一行，错误的字数量/展开后的总长度
 * 注意: 展开后的字符串不含数字
 * 示例1输入
 * 3A3B
 * 2A4B
 * 输出
 * 1/6
 *
 * 示例2输入
 * 5Y5Z
 * 5Y5Z
 * 输出
 * 0/10
 *
 * 示例3输入
 * 4Y5Z
 * 9Y
 * 输出
 * 5/9
 *
 * 思路：
 * 3A3B
 * 2A4B
 * 不解压直接比较，
 * 后缀字母相同，前缀数字不同的取最短的，如都是A，去掉后1A3B和4B
 * 后缀字母不同，直接取最短的，剩下3B和3B，结束
 * */
public class B59计算误码率 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        String op = in.nextLine();

        StringBuilder builder = new StringBuilder();
        int len = Math.min(ip.length(), op.length());
        for (int i = 1; i < len; i+=2) {
            // 如果后缀字母相同
            if (ip.charAt(i) == op.charAt(i)) {
                builder.append(Math.abs(Character.getNumericValue(ip.charAt(i - 1))
                        - Character.getNumericValue(op.charAt(i - 1)))).append(ip.charAt(i));
            } else {

            }
        }
    }
}
