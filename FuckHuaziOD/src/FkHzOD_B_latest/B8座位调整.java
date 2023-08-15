package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|8|座位调整|逻辑分析|100|
 * 疫情期间课堂的座位进行了特殊的调整，不能出现两个同学紧挨着，必须隔至少一个空位，
 * 给一整数数组，desk表示当前占座情况，若干0 和1组成，0表示空着，1表示占位，
 * 不改变原有座位秩序情况下，还能安排几个人？
 *
 * 输入：一行，占座情况
 * 输出：还能坐几个人数量
 *
 * 示例：
 * 1,0,0,0,1
 * 输出：
 * 1
 * desk[2]可坐一个人
 *
 * 思路：
 * 当前位置x为0空位的情况下，检查两边也是空位，则可坐人，0变1，
 * 需要考虑边界，
 *
 */
public class B8座位调整 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] desk = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int avail = 0;

        if (desk[0] == 0 && desk[1] == 0) {
            desk[0] = 1;
            avail++;
        }

        for (int i = 1; i < desk.length - 1; i++) {
            if (desk[i] == 0) {
                if (desk[i - 1] == 0 && desk[i + 1] == 0) {
                    desk[i] = 1;
                    avail++;
                }
            }
        }

        if (desk[desk.length - 1] == 0 && desk[desk.length - 2] == 0) {
            desk[desk.length - 1] = 1;
            avail++;
        }

        System.out.println(avail);
    }

}
