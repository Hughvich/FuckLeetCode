package FkHzOD_B_old;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B|88|任务总执行时长|逻辑模拟|100|
 * 任务编排服务负责对任务进行组合调度。参与编排的任务有两种类型，
 * 其中一种执行时长为taskA，另一种执行时长为taskB。
 * 任务一旦开始执行不能被打断，且任务可连续执行。
 * 服务每次可以编排num个任务。请编写一个方法，生成每次编排后的任务所有可能的总执行时长。
 *
 * 输入描述：
 * 第1行，分别为第1种任务执行时长 taskA，第2种任务执行时长 taskB，这次要编排的任务个数num，逗号分隔
 * 输出描述：
 * 数组形式返回所有总执行时长，从小到大排列
 * 补充说明：
 * 每种任务数量都大于可以编排的任务数量
 * taskA,taskB > 0
 * num 0-100000
 *
 * 示例
 * 输入：
 * 1,2,3
 * 输出：
 * [3,4,5,6]
 * 可执行3次A，或者2次A 1次B，1次A 2次B，3次B，得到3，4，5，6
 *
 * 思路：
 * 循环num + 1次，开始全A，每次A少一个，B多一个，最后全B
 *
 */
public class B88任务总执行时长 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        int A = list.get(0);
        int B = list.get(1);
        int num = list.get(2);
        if (num == 0)
            System.out.println("[]");
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < num + 1; i++) {
            int sum = A * (num - i) + B * i;
            set.add(sum);
        }
        System.out.println(set);
    }
}
