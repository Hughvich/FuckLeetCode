package Arrays.RemoveElements;
/**
LC#844.easy

给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。

示例 1：
 输入：s = "ab#c", t = "ad#c"
 输出：true
 解释：s 和 t 都会变成 "ac"。

示例 2：
 输入：s = "ab##", t = "c#d#"
 输出：true
 解释：s 和 t 都会变成 ""。

示例 3：
 输入：s = "a#c", t = "b"
 输出：false
 解释：s 会变成 "c"，但 t 仍然是 "b"。

 所用到的知识：
 遍历String的两种方法：
 遍历string.charAt(i), 或者char[] chars = string.toCharArray()
 charAt() 效率高，不用额外空间

 模拟入栈出栈的操作：StringBuilder.append() / .deleteCharAt()
 核心逻辑：非#字符入栈，只要碰到#，弹掉前一个

 可以用栈（匹配问题），也可以双指针法：

*/

public class backspaceCompare844 {

    public static boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    //出入栈法
    private static String backspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c != '#') { //注意用单引号
                sb.append(c);
            }else if (sb.length() > 0) { //如果为#，直接把前面的一个弹掉
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    // 双指针法，空间复杂度可以降到O(1)。很不好理解
    // https://leetcode.cn/problems/backspace-string-compare/comments/
    public static boolean backspaceCompareDualPointer(String s, String t) {
        int sSkipNum = 0;
        int tSkipNum = 0;
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(true) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkipNum++;
                } else if (sSkipNum > 0) {
                    sSkipNum--;
                } else break;
                i--;
            }

            while (j >= 0) {
                if (s.charAt(j) == '#') {
                    tSkipNum++;
                } else if (tSkipNum > 0) {
                    tSkipNum--;
                } else break;
                j--;
            }

            if (i < 0 || j < 0) break;
            if (s.charAt(i) != t.charAt(j)) return false;
        }
        if (i == -1 && j == -1) return true;
        return false;
    }

    //一个力扣评论的评论里的解法
    //https://leetcode.cn/problems/backspace-string-compare/comments/
    public static String analyze(String s) {
        int slow = 0;

        int n = s.length();
        for (int fast = 0; fast < n; fast++) {
            if(s.charAt(fast) != '#') {
                char c = s.charAt(slow);
                c = s.charAt(fast);
                slow++;
            } else if (slow > 0) {
                slow--;
            }
        }
        return s.substring(0,slow);
    }

    public static void main(String[] args) {
        String s = "a#b#c"; //len = 5, i = 0 ~ 4
        String t = "a#fb##d#c";
        System.out.println(backspaceCompare(s,t));

        System.out.println(analyze(s));
    }
}
