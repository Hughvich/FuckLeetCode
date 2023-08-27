package FkHzOD_B_latest;

import java.util.Scanner;

/**
 * B|89|整数编码|字符串 / 进制|100|
 * 实现一个整数编码方法，使得待编码的数字越小，编码后所占用的字节数越小
 * 编码规则：
 * 1. 7位一组，每个字节低7位用于存储待编码数字的补码
 * 2. 字节的最高位表示后续是否还有字节，置1表示还有，置0表示当前字节为最后一个字节
 * 3. 采用 小端序编码，低位和低字节放在低地址上
 * 4. 编码结果按16进制数 字符格式输出，小写字母转换为大写
 * 输入：字符串表示的非负整数
 * 输出：字符串表示的编码后的16进制码流
 * 示例1：
 * 0
 * 输出：00（不足两位补零）
 *
 * 示例2：
 * 100
 * 输出：
 * 64（0110 0100只需一个字节编码，直接16进制为64）
 *
 * 示例3：
 * 1000
 * 输出：
 * E807(0011 1 110 1000需要两个字节，低7位110 1000，第一个字节1110 1000编码为E8，
 * 第二个字节0000 0111，编码为07，小端序则低字节E8在前，07在后)
 */
public class B89整数编码 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String binary = Integer.toBinaryString(num);
        int len = binary.length();
        StringBuilder builder = new StringBuilder();

        // 倒序，保证低位在前，高位在后
        for (int i = len; i > 0; i-=7) {
            // 每7位为一个开始位，将字节分为每7位一组
            int start = Math.max(i - 7, 0);
            String bin = binary.substring(start, i);

            // 最高的头部，不到7位,将剩余位置补0
            if (bin.length() < 7) {
                StringBuilder head = new StringBuilder();
                for (int j = 0; j < 7 - bin.length(); j++) {
                    head.append("0");
                }
                bin = head.append(bin).toString();
            }
            // 低位-7，会>0，高位-7，会<=0，所以高位头补0，低位头补1
            bin = i - 7 <= 0 ? "0" + bin : "1" + bin;

            // 最终答案二进制转十六：bin转为hex
            String hex = Integer.toHexString(Integer.parseInt(bin, 2)).toUpperCase();
            // 如果只有一位，补零；
            if (hex.length() == 1)
                hex = "0" + hex;
            builder.append(hex);
        }
        System.out.println(builder);
    }
}
