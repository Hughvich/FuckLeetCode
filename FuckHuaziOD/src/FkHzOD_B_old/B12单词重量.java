package FkHzOD_B_old;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * B|12|单词重量|逻辑模拟|100|
 * 每个句子由多个单词组成，句子中的每个单词长度都可能不一样，
 * 假设每个单词长度Ni为该单词的重量，求整个句子的平均重量V
 * 示例：
 * 输入：
 * Who Love Solo
 * 输出：
 * 3.67
 *
 */
public class B12单词重量 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int weight = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                weight++;
            } else num++;
        }
        double s = (double) weight / (num + 1);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(s));
    }
}
