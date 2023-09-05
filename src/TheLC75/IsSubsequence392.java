package TheLC75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC#392.Easy 判断子序列 【双指针】
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * 快慢指针，slow指向子串，遍历母串，slow到达length表示子串全部找见
 */
public class IsSubsequence392 {
    public static boolean isSubsequence(String s, String t) {
            int slow = 0;
            for (int fast = 0; fast < t.length(); fast++) {
                if (slow >= s.length())
                    break;
                if (s.charAt(slow) == t.charAt(fast))
                    slow++;
            }
            System.out.println(slow);
            return slow == s.length();
    }

    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
        String s = "", t = "";
//        String s = "a", t = "ab";
        System.out.println(isSubsequence(s,t));
    }
}
