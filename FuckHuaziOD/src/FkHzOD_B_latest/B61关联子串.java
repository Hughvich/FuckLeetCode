package FkHzOD_B_latest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * B|61|关联子串|字符串处理|100|
 * 给定两个字符串str1和str2，
 * str1进行排列组合，只要有一个为str2的子串，则认为s1是s2的关联子串，
 * 返回子串在s2中的位置，不是关联则返回-1
 * 示例1输入：
 * abc efghicbaiii
 * 输出：5
 * 示例2输入：
 * abc efghiccaiii
 * 输出：-1
 *
 * 思路：滑动窗口，记录
 * zhuanlan.zhihu.com/p/645492290
 * （答案不太对）
 */
public class B61关联子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> count = new HashMap<>();
        String s = in.nextLine();
        String s1 = s.substring(0, s.indexOf(' '));
        String s2 = s.substring(s.indexOf(' ') + 1);

        // 给s1每个字符记数
        for (int i = 0; i < s1.length(); i++) {
            count.put(s1.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        int len = s1.length();

        // 滑窗：添加滑窗-固定/非固定， 开始滑动，终止滑动
        // 这里的滑窗长度和str1一样
        for (int i = 0; i < len; i++) {
            char ch = s2.charAt(i);
            if (count.get(ch) != null) {
                if (count.get(ch) > 0)
                    len--;
                count.put(ch, count.getOrDefault(ch, 0) - 1);
            }
        }
        // 如果len==0，滑窗内全是在s2的字符
        if (len == 0)
            System.out.println(s2.indexOf(s1.charAt(0)));
        //否则开始滑窗，从1开始到s2.length - 1 - s1.length + 1 = s2.l - s1.l
        for (int i = 1; i < s2.length() - s1.length() + 1; i++) {
            char remove = s2.charAt(i - 1);
            char add = s2.charAt(i + s1.length() - 1);
            // 出滑窗的要还原
            if (count.get(remove) != null) {
                if (count.get(remove) >= 0)
                    len += 1;
                count.put(remove, count.get(remove) + 1);
            }

            // 进滑窗的要初始化
            if (count.get(add) != null) {
                if (count.get(add) >= 0)
                    len -= 1;
                count.put(add, count.get(add) - 1);
            }

            if (len == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
