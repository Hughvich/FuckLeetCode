package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
 * switch - case 多分支条件句
 *
 */
public class B20数大雁 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();

        LinkedList<Integer> q = new LinkedList<>();
        int u = 0, a=0, c=0;

        ArrayList<Integer[]> res = new ArrayList<>();
        for (int i = 0; i < ip.length(); i++) {
            switch (ip.charAt(i)) {
                case 'q':
                    q.add(i);
                    break;
                case 'u':
                    if (u + 1 <= q.size())
                        u++;
                    break;
                case 'a':
                    if(a + 1 <= u)
                        a++;
                    break;
                case 'c':
                    if (c + 1 <= a)
                        c++;
                    break;
                case 'k':
                    if (c >= 1) {
                        res.add(new Integer[] {q.removeFirst(), i});
                        u--;
                        a--;
                        c--;
                    }
                    break;
                default:
                    System.out.println(-1);
                    return;
            }
        }
        if (res.size() == 0) {
            System.out.println(-1);
            return;
        }

    }
}
