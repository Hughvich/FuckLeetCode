package FkHzOD_B_old;

import java.util.Scanner;

/**
 * B|9|非严格递增连续数字序列|双指针|100|
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的 最长的 非严格递增 连续数字序列 的长度（如12234非严格递增连续）
 * 输入：(... 最大不超过255个字符)
 * abc2334019A334bc
 * 输出：
 * 4 （2234为所求序列）
 *
 * 其他示例：
 * 输入1：aaaaaaa44ko543j123j7345677781
 * 输出1：8 (34567778
 * 输入2：aaaaaa34567778a44ko543j123j71
 * 输出2：8 (34567778
 * 输入3：34567778a44ko543j123j7134567778aa
 * 输出4：9 (134567778
 *
 * 思路：
 * 3个分支条件：
 * 分支1：如果不是数字，当前长度直接置0，上一个数字也置0
 * 分支2：如果是数字，且大于上一个数字，当前长度+1，比较并更新最大长度, 更新上一个数字
 * 分支3：如果是数字，且小于上一个数字，当前长度置1，更新上一个数字
 *
 * 考字符串比较
 * char应该在 >= 0和 <= 9 之间
 *
*/
public class B9非严格递增连续数字序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int res = 0;
        int length = 0;
        char lastCh = '0';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= lastCh && ch <= '9') {
                length++;
                lastCh = ch;
                builder.append(lastCh);
                res = Math.max(length, res);
                System.out.println("max: " + builder);
            } else if (ch < lastCh && ch >= '0') {
                System.out.println("max: " + builder);
                length = 1;
                lastCh = ch;
                builder.delete(0, builder.length());
                builder.append(lastCh);
            } else {
                length = 0;
                lastCh = '0';
                builder.delete(0, builder.length());
            }

        }
        System.out.println(res);
    }
}
