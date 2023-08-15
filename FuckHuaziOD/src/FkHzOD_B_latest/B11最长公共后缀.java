package FkHzOD_B_latest;

import java.util.Scanner;

/**
 * B|11|最长公共后缀|逻辑分析|100|
 * 编写一个函数来查找字符串数组中最长公共后缀，如果不存在，返回固定字符串@Zero
 * 字符串长度[2,1000]
 * 字符长度范围[1,126]
 * 示例1
 * 输入：["abc","bbc","c"]
 * 输出：“c”
 * 示例2
 * 输入：["aa","bb","cc"]
 * 输出：
 * "@Zero"
 *
 * 思路：
 * ans/res初始化为第一个字符串，遍历后面的字符串，依次比较，找出公共后缀
 * 如果ans为空，不存在返回@Zero
 *
 */
public class B11最长公共后缀 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ip = in.nextLine().replace("[","").
                replace("]","").replace("\"","").split(",");
        // 公共后缀初始化
        String res = ip[0];

        for (int i = 0; i < ip.length; i++) {
            // 倒着遍历, 对每一个字符串ip[i]
            int resLen = res.length();
            int strLen = ip[i].length();
            int j = 1;
            while (resLen - j >= 0 && strLen - j >= 0 &&
                    res.charAt(resLen - j) == ip[i].charAt(strLen - j)) {
                j++; // 两两比较，相同j往后加，最后的len - j + 1就是公共后缀索引
            }
            if (j == 1) {//相等于完全没有相同的
                System.out.println("@Zero");
                return; //return必需
            }
            res = res.substring(resLen - j + 1);
        }
        System.out.println(res);
    }
}
