package FkHzOD_B_old;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|22|快递运输|逻辑模拟|100|
 * 运送快递放在大小不等的长方体快递盒中，为了能够装载更多的快递同时不超载，计算最多能装多少个快递
 * 快递数最多1000个，货车载重最大50000
 *
 * 输入：第一行：每个快递的重量，逗号隔开
 * 第二行：货车的载重量
 * 输出：最多快递量
 *
 * 示例：
 * 输入：5,10,2,11
 * 20
 * 输出：3
 *
 * 思路：就是贪婪/贪心算法:
 * 排序，最小的最先装，直到装不下
 *
 */
public class B22快递运输 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> ip = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        ip.sort(Comparator.comparingInt(o -> o));

        int maxLoad = in.nextInt();
        int maxCount = 0;
        int totalLoad = 0;

        for (int i = 0; i < ip.size(); i++) {
            totalLoad += ip.get(i);

            if (totalLoad > maxLoad){
                break;
            }
            else {
                maxCount++;
            }
        }

        System.out.println(maxCount);
    }
}
