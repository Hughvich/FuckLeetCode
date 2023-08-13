package FkHzOD_B_old;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * B|95|字符串中找出连续最长的数字串|正则匹配|100|
 * 字符串中找到连续最长的数字串并返回
 * 如果存在长度相同的，返回最后一个
 * 如果没有，返回空串""
 *
 * 数字可以由0-9，小数点.，正负号±组成，长度包括所有符号
 * 小数点，正负号仅能出现一次，小数点两边必须是数字，正负号仅能出现在开头且后面必须有数字
 * 示例1：
 * 1234567890abcd9.0+12345.678.9ed
 * 输出
 * +12345.678
 *
 * 思路：对于小数点正负号判断，用正则表达式
 * 小数点，正负号仅能出现一次：即匹配零次或一次，？或者{0，1}
 * 小数点两边必须是数字: [0-9]+\\.？[0-9]+
 * 正负号仅能出现在开头且后面必须有数字：匹配一次或多次：{1,}
 *
 * 但实际上的匹配：([+-]?[0-9]+\\.？[0-9]+)
 * 但实际上的匹配：([+-]?\\d+\\.？\\d+)
 *
 */
public class B95字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        builder.append(in.nextLine());

        //两种都行
//        Matcher matcher = Pattern.compile("([+-]?[0-9]+\\.?[0-9]+)").matcher(builder);
        Matcher matcher = Pattern.compile("([+-]?\\d+\\.?\\d+)").matcher(builder);
        String res = "";
        int maxLength = 0;

        while (matcher.find()) {
            String group = matcher.group();
            if (group.length() >= maxLength) {
                maxLength = group.length();
                res = group;
            }
        }
        System.out.println(res);
    }
}
