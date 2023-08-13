package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * B|90|用连续自然数之和来表达整数|滑动窗口|100|
 * 一个整数以连续的几个自然数之和表示，
 * 计算有几种连续自然数之和表达式，并打印
 *
 * 输入：一个目标整数T，1-1000之间
 * 输出：该整数所有表达式及其个数，
 *      自然数个数最少的表达式优先输出，
 *      每个表达式按自然递增的顺序输出，
 *      每个测试数据结束时，输出一行"Result:X"，其中X是最终的表达式个数
 * 示例1：
 * 输入：
 * 9
 * 输出：
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 * 示例2输入：10
 * 输出：
 * 10=10
 * 10=1+2+3+4
 * Result:2
 *
 * 思路：
 * 目标数n范围1-1000，可以用双层暴力求解
 * 外循环，内循环次数：肯定不超过目标数
 *
 * 内循环：用来建每一次的表达式， 不断+1，用SB累加，只要够n就跳到外循环
 */
public class B90用连续自然数之和来表达整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 先把自己打印了
        System.out.println(n + "=" + n);

        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int sum = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = i; sum < n; j++) {
                sum += j;
                System.out.println("sum:" + sum);
                System.out.println("builder:" + builder);
                if (sum == n) {
                    System.out.println("entered");
                    builder.append(j);
                    res.add(n + "=" + builder);
                    break;
                }
                builder.append(j).append("+");
            }
        }
        // 按照res里的string长度升序排序
        res.sort(Comparator.comparingInt(String::length));
        res.forEach(System.out::println);
        System.out.println("Result:" + (res.size() + 1));
    }
}
