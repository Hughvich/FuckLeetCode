package FkHzOD_B_old;

import java.util.Scanner;

/**
 * B|2|字符串子序列II|字符串|100|
 * 字符串target和source，判断target是否为source的子序列，字符串仅包含英文小写字母
 * source可以很长：~=500,000，target短：<= 100
 * 找出最后一个子序列的起始位置(0-base)，找不到返回-1
 *
 * 输入：
 * abc
 * abcaybec
 * 输出：3
 * （两个子序列，取较大）
 *
 */
public class B2字符串子序列II {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String source = in.nextLine();

        // 两个指针t，s
        // 从末尾遍历(使索引最靠右，最大)，如果t和s相符，都向前移位，否则只移动s
        int t = target.length() - 1;

            for (int i = source.length() - 1; i >= 0; i--) {
                if (target.charAt(t) == source.charAt(i)) {
                    t--;
                    // 如果target遍历完，返回最后一个位置
                    if (t < 0) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        System.out.println(-1);
    }
}
