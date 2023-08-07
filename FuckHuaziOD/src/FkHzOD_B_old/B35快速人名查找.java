package FkHzOD_B_old;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|35|快速人名查找|回溯算法|100|
 * 好像是深度优先？？？
 * https://blog.csdn.net/BYZLZ119/article/details/131063261
 * 给一个字符串，表示用,分开的人名。然后给定一个字符串，进行快速人名查找，符合要求的输出。
 * 快速人名查找要求:人名的每个单词的连续前几位能组成给定字符串，一定要用到每个单词
 *
 * 输入描述: 第一行是人名，用‘，’分开的人名，第二行是查找字符串
 * 输出描述：输出满足要求的人名
 *
 * 示例
 * 输入：
 * zhang san,zhang san san
 * zs
 * 输出：
 * zhang san
 *
 * 输入：
 * zhang san san,zhang an sa,zhang hang,zhang seng,zhang sen a
 * zhas
 * zhang an sa,zhang seng
 *
 * 思路：
 * 必须是dfs递归算法
 * 每个单词p 前i 个字符 去匹配目标 abbr(exp)的前j 个字符
 * 要记住base condition：单词pi或目标ej有任一方用完了所有的长度
 *
 *
 */
public class B35快速人名查找 {

    // 深度优先算法，abbr是目标字串，pi和ej是匹配索引
    public static boolean dfs(List<String> names, int pi, String abbr, int ej) {
        // base condition：单词pi或目标ej有任一方用完了所有的长度
        if (pi == names.size() || ej == abbr.length())
            return pi == names.size() && ej == abbr.length();

        // 开始匹配，对于names[pi]，和abbr[ej]首字母一定匹配，否则false
        String name = names.get(pi);
        if (name.charAt(0) != abbr.charAt(ej))
            return false;

        // 其他情况，name和多个abbr匹配
        int i = 1;
        while (i < name.length() && ej + i < abbr.length()
                && name.charAt(i) == abbr.charAt(ej + i)) {
            if (dfs(names, pi + 1, abbr, ej + i + 1))
                return true;
            i++;
        }

        // 首字母匹配，那么直接进行下一个匹配
        return dfs(names, pi + 1, abbr, ej + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        List<String> ip= Arrays.stream(in.nextLine().split(",")).collect(Collectors.toList());
        List<String> ip = Arrays.asList(in.nextLine().split(","));
        String abbr = in.nextLine();
        String ans = "";
        for (String fullName : ip) {
            List<String> names = Arrays.asList(fullName.split(" "));
            if (dfs(names, 0, abbr, 0))
                ans = ans.isEmpty() ? fullName : ans + "," + fullName;
        }
        System.out.println(ans);
    }
}
