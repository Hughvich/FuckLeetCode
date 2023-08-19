package FkHzOD_B_latest;

import java.util.*;
import java.util.regex.Pattern;

/**
 * B|16|字符串摘要|字符串处理|100|
 * 给一个字符串的摘要算法，请输出给定字符串的摘要值
 * 如果出现连续字符（忽视大小写），则输出该字符（小写）+连续出现的次数
 * 如果非连续，则输出该字符（小写）+该字母之后字符串中出现该字母的次数
 * 对按照以上方式表示后的字符串进行排序，字母和紧随的数字作为一组进行排序，数字大的在前，数字相同的按字母排序
 *
 * 输入：aabbcc
 * 输出：a2b2c2
 *
 * 思路：用正则表达式，
 */
public class B16字符串摘要 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, cnt + 1);
            } else {
                map.put(c, 1);
            }
        }

        //排序一步比较关键，用list.getValue排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> o: list) {
            System.out.print(o.getKey()+""+o.getValue());
        }

    }
}
