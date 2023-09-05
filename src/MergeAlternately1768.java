/**
 * LC#1768.Easy交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 *
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 *
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 */
public class MergeAlternately1768 {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        String longer = word1.length() > word2.length() ? word1 : word2;
        int i = 0, j = 0, k = 0;
        while (i < word1.length() && j < word2.length()) {
            if (k++ % 2 == 0)
                builder.append(word1.charAt(i++));
            else
                builder.append(word2.charAt(j++));
        }
        if (i - 1 > j)
            builder.append(longer.substring(i));
        else
            builder.append(longer.substring(j));

        return builder.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pqrstuvwxyz";
        System.out.println(mergeAlternately(word1,word2));
    }
}
