package FkHzOD_B_old;

import java.util.*;

/**
 * B|86|运维日志排序|排序算法|100|
 * 运维工程师采集到某产品线网运行一天产生的日志n条，
 * 现需根据日志时间先后顺序对日志进行排序；
 * 日志时间格式为H:M:S.N，小时：分钟：秒：毫秒
 * 时间可能没有补0
 *
 * 输入描述：第一行输入一个整数n表示日志条数，1<=n<=100000
 * 接下来n行输入n个时间
 * 输出描述：
 * 时间升序排序之后的时间
 * 如果有两个时间相同按输入顺序；
 *
 * 示例：
 * 输入：
2
01:41:8.9
1:1:09.211
 * 输出：
 * 1:1:09.211
 * 01:41:8.9
 *
 * 示例2：
 * 输入：
 * 3
 * 23:41:08.023
 * 1:1:09:211
 * 08:01:22.0
 * 输出：
 * 1:1:09:211
 * 08:01:22.0
 * 23:41:08.023
 *
 * 思路：直接将时间戳转换为最小单位，统一单位后比较
 */
public class B86运维日志排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> time = new LinkedList<>();

        in.nextLine();

        for (int i = 0; i < n; i++) {
            time.add(in.nextLine());
        }

        time.sort(Comparator.comparingLong(B86运维日志排序::getTime));
        time.forEach(System.out::println);
    }

    public static long getTime(String s) {
        String[] t1 = s.split(":");
        String[] t2 = t1[2].split("\\.");

        int h = Integer.parseInt(t1[0]) * 3600 * 1000; // h -> ms
        int m = Integer.parseInt(t1[1]) * 60 * 1000; // m -> ms
        int sec = Integer.parseInt(t2[0]) * 1000; // s -> ms
        int n = Integer.parseInt(t2[1]); // ms
        return h + m + sec + n;

    }
}
