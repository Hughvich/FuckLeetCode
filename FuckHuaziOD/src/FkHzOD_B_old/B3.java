package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * B|3|分苹果|位运算|100|
 * AB两个人把苹果分两堆，A按照二进制加法计算 等分 苹果，不计算进位，12+5=9 （1100+0101=9），
 * B按十进制加法，包括正常进位，满足A的情况下获取苹果重量最多，无法满足A时输出-1
 * 输入：苹果的数量和每个的重量，输出：满足A下B获取的苹果总重量
 * 范围:
 * 1<= 总苹果数量 <=20000
 * 1<= 每个苹果重量 <= 10000
 * 输入1：
 * 3
 * 3 5 6
 * 输出1：
 * 11
 * 输入2：
 * 8
 * 7258 6579 2602 6716 3050 3564 5396 1773
 * 输出2：
 * 35165
 *
 * 思路：
 * 不进位的二进制加法，等同于 异或^ ，不一样为1，一样为0 xor = (-a n b) u (a n -b)
 *
 * 按照A的目标：等分，如果能等分，所有苹果异或的结果为0
 * 如果取出最小的苹果分给A，两堆必然相等，因为异或为0
 *
 * 位运算：
 * a = 0101
 * b = 1100
 * a &= b: a = 1100
 * |=: 1101
 * 异或^=: 1001
 * 非~
 *
 */
public class B3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意接收int的方法
        int num = Integer.parseInt(in.nextLine());
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            weights.add(in.nextInt());
        }

        int weightA = 0;
        int weightB = 0;
        // 将最小的挑出来
        weights.sort(Comparator.comparingInt(o -> o));
        int min = weights.get(0);

        for (int i = 0; i < num; i++) {
//            weightA = weightA ^ weights.get(i);
            weightA ^= weights.get(i);
            weightB += weights.get(i);
        }

        if (weightA == 0)
            System.out.println(weightB - min);
        else
            System.out.println(-1);

    }
}
