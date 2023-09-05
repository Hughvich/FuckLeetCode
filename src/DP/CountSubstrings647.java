package DP;

import java.util.Arrays;

/**
 * LC#647.Med 回文子串 【DP动态规划】
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 思路：
 * 双指针，i左j右，dp[i][j]表示是否是回文串，
 * 递推公式：s[i] == s[j]的情况下，j - 1大于1时，
 * 如果dp[i + 1][j - 1] == true，那么dp[i][j] == true，
 * 遍历顺序：从下往上，从左往右，i倒序，j正序
 */
public class CountSubstrings647 {
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // j为右指针，要比i大
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if(dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        String s = "abba";
        /*
        abba,bb,a,b,b,a
        [[true, false, false, true],
        [false, true, true, false],
        [false, false, true, false],
        [false, false, false, true]]


         */
        System.out.println(countSubstrings(s));
    }
}
