package FkHzOD_B_latest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * B|60|增强的 strstr|正则匹配|100|
 * c语言有个库函数strstr实现在字符串中查找第一次出现字符串的位置，未找到返回null，
 * 增强strstr，使用带可选段的字符串来模糊查询，返回首次出现位置
 * 可选段使用"[]"标识，表示该位置是可选段中任意一个字符即可满足匹配条件，比如"a[bc]"可匹配ab或ac
 * 目标字符串中可选段可能出现多次
 *
 * 输入：两个字符串，源字符串和目标字符串
 * 输出：源字符串中，匹配字符串相对于源字符串地址的偏移（从0），没有匹配返-1
 * 示例1输入：
 * abcd
 * b[cd]
 * 输出：
 * 1
 * 说明：bc或bd相对于abcd偏移1
 *
 *
 */
public class B60增强的strstr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String origin = in.nextLine();

        // 不知.replaceAll("\\[(.*?)\\]", "[$1]");做了什么
        String target = in.nextLine().replaceAll("\\[(.*?)\\]", "[$1]");
        System.out.println(target);

        Matcher matcher = Pattern.compile(target).matcher(origin);
        System.out.println(matcher.find() ? matcher.start() : -1);
    }
}
