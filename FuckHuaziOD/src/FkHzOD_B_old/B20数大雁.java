package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|20|数大雁|逻辑模拟|100|
 * 一群大雁往南飞，给定一个字符串记录地面上的游客听到的大雁叫声，请给出叫声最少由几只大雁发出；
 * 大雁发出的完整叫声为"quack",因为有多只大雁同时叫，字符串可能混合多个"quack"，
 * 大雁依次完整发出"quack"，5个字母按顺序完整存在才能记数为一只大雁，不完整或者没有按顺序不予记数；
 * 输入：一个字符串，包括大雁"quack"叫声，长度1~1000，字符种类只有quack5个字母；
 * 输出：大雁的数量
 * 
 * 示例1：
 * 输入：quackquack
 * 输出：1
 *
 * 思路：
 * 找出连续的quack，当中间出现不同的字母，开新的空间存储，
 * 如果出现的不能成为新quack就不能输出-1，同时不能组完全的也-1，
 * 最后 新开空间数 就是个数
 *
 * 用到：
 * switch - case - break多分支条件句
 *
 */
public class B20数大雁 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();

        // 用一个数列记录“候选者”，如果后面有完整的quack序列则 弹出q
        LinkedList<Integer> q = new LinkedList<>();
        int u = 0, a=0, c=0;

        ArrayList<Integer[]> res = new ArrayList<>();
        for (int i = 0; i < ip.length(); i++) {
            switch (ip.charAt(i)) {
                case 'q':
                    // 如果是q，加就行
                    q.add(i);
                    System.out.println("q= " + q);
                    break;
                case 'u':
                    // 如果是u，必须要有q，且不超过q，因为++后刚好等于q
                    if (u + 1 <= q.size()){
                        u++;
                        System.out.println("u= " + u);
                    }
                    break;
                case 'a':
                    // 如果是a，同上，必须要有u
                    if(a + 1 <= u) {
                        a++;
                        System.out.println("a= " + a);
                    }
                    break;
                case 'c':
                    // 必须要有a
                    if (c + 1 <= a) {
                        c++;
                        System.out.println("c= " + c);
                    }
                    break;
                case 'k':
                    if (c >= 1) {
                        // 必须要至少有一个c，一个完整的序列就出现了，首尾记录到res中，
                        // 并弹出第一个q，减一个u，a，c，记录最后一位k 的出现点i
                        res.add(new Integer[] {q.removeFirst(), i});
                        u--;
                        a--;
                        c--;
                        System.out.println("k");
                    }
                    break;
                // 其他字母直接 -1
                default:
                    System.out.println(-1);
                    return;
            }
            System.out.println("i====== " + i);
            res.forEach(r -> System.out.println(Arrays.toString(r)));
        }
        // 没有完整quack序列
        if (res.size() == 0) {
            System.out.println(-1);
            return;
        }

        // 至少有一只
        int max_count = 1;
        for (int i = 0; i < res.size(); i++) {
            // 至少有一只，答案不为0，要么是无法识别的其他生物，要么就有一只，0只的情况除非没有声响
            int count = 1;
            for (int j = i + 1; j < res.size(); j++) {
                // 关键逻辑：如果前一个quack完整循环最后一位k在第二个quack循环头q之前，则记数一只
                if (res.get(i)[1] >= res.get(j)[0]) {
                    count++;
                    System.out.println("count= " + count);
                }
            }
            max_count = Math.max(max_count, count);
        }
        System.out.println(max_count);
    }
}
