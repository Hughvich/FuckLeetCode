package TheLC75;

/**
 * LC#1071.Easy 字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 *
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * 字符串长度1000以内
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 * 思路：
 */
public class GcdOfStrings1071 {
    public static String gcdOfStrings(String str1, String str2) {
        // 交换顺序，s1大，s2小
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        // (不用判断)特殊情况：直接是子串
//        if (str1.length() > str2.length() && str1.length() % str2.length() == 0) {
//            for (int i = 0; i < str1.length(); i+= str2.length()) {
//                if (!str2.equals(str1.substring(i, i + str2.length()))) {
//                    return "";
//                }
//            }
//            return str2;
//        } else {
            // 否则，欧几里得算法，获得最大公约数
            int x = str1.length();
            int y = str2.length();
            while (y != 0) {
                int tmp = x % y;
                x = y;
                y = tmp;
            }
            String gcdStr = str2.substring(0, x);
//            System.out.println(gcdStr);
            for (int i = 0; i < str1.length(); i+=x) {
                if (!str1.substring(i, i + x).equals(gcdStr)) {
                    return "";
                }
            }
            for (int i = 0; i < str2.length(); i+=x) {
                if (!str2.substring(i, i + x).equals(gcdStr)) {
                    return "";
                }
            }
            return gcdStr;
        }

//    }

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABCABC";
        System.out.println(gcdOfStrings(str1, str2));
    }
}
