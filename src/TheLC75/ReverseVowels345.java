package TheLC75;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LC#345.Easy 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 *
 * 示例 1：
 *
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 *
 */
public class ReverseVowels345 {
    public static String reverseVowels(String s) {
//        Pattern pattern = Pattern.compile("[aeiou]");
//        Matcher matcher = pattern.matcher(s);

        // 匹配表pattern
        List<Character> pattern = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb  = new StringBuilder();
        List<Character> vowelList = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // 匹配字符串，用列表contains判断
            if (pattern.contains(s.charAt(i))) {
                vowelList.add(s.charAt(i));
                idxList.add(i);
            }

        }
        Collections.reverse(vowelList);
        System.out.println(idxList);
        System.out.println(vowelList);
        sb.append(s);
        for (int i = 0; i < idxList.size(); i++) {
            //
            sb.replace(idxList.get(i), idxList.get(i) + 1,
                    String.valueOf(vowelList.get(i)));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "AaAa";
        System.out.println(reverseVowels(s));
    }
}
