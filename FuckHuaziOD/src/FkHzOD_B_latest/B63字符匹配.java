package FkHzOD_B_latest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * B|63|字符匹配|正则匹配|100|
 * 字符串数组，和一个字符规律pattern，识别那些字符可以匹配到pattern上
 * 输入：第一行：空格分割的多个字符串，单个字符串长度<100,字符串个数<100
 * 第二行：字符规律，长度<= 50
 * 输出：匹配字符串在数组中的下标（0-base），多个匹配下标升序并用逗号分割，均不匹配输出-1
 *
 * 输入：
 * ab aab
 * .*
 * 输出：
 * 0,1
 */
public class B63字符匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        String pattern = in.nextLine();
        Pattern compile = Pattern.compile("^" + pattern + "$");
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            Matcher matcher = compile.matcher(s[i]);
            if (matcher.matches())
                b.append(i).append(",");
        }
        if (b.isEmpty()) System.out.println(-1);
        else {
            System.out.println(b.substring(0, b.length() - 1));
        }
    }
}
