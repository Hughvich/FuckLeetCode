package Strings;

import java.util.HashSet;

/**
 * 给定一个字符串，查找最长子字符串的长度，不重复字符。
 *
 * 输入一串字符：比如给出："abaabcdd"，最长子字符串为："abcd"，那么程序输出结果为 4
 * 又或者给出："bbabcdedff"，最长子字符串为："abcde"，输出结果为 5
 *
 *
 *
 */
public class LengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String str) {
        HashSet<Character> set = new HashSet<>();
        int s = 0, f = 0, ans = 0;
        // s记录重复的次数
        while (f < str.length() - 1) { //s < str.length() && f < str.length()
            System.out.println("_________");
            System.out.println("s: " + s);
            System.out.println("f: " + f);
            if (!set.contains(str.charAt(f))) {
                set.add(str.charAt(f));
                f++;
                ans = Math.max(ans, f - s);
            } else {
                set.remove(str.charAt(s));
                s++;
            }
            System.out.println("ans: " +ans);
            System.out.println(set);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbabcdedff"));
    }
}
