package FkHzOD_B_latest;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * B|19|报文回路|数据结构|100|
 * GMP 协议中响应报文和查询报文，是维系组播通路的两个重要报文，
 * 在一条已经建立的组播通路中两个相邻的 HOST 和 ROUTER，
 * ROUTER 会给 HOST 发送查询报文，HOST 收到查询报文后给 ROUTER 回复一个响应报文，以维持相之间的关系，
 * 一旦这关系断裂，那么这条组播通路就异常”了。
 * 现通过某种手段，抓取到了 HOST 和 ROUTER 两者通讯的所有响应报文和查询报文，请分析该组播通路是否“正常”
 * 输入描述：
 * 第一行一个整数n，抓到的报文数量；
 * 后续n行每行两个整数d1和d2表示互通；
 * 输出描述：
 * 组播通路是否正常，正常True，否则False
 *
 * 示例1：
5
1 2
2 3
3 2
1 2
2 1
 *输出：True
 *
 * 思路：
 * map存储联通关系，但是拿二维数组存报文
 *
 */
public class B19报文回路 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = in.nextInt();
            }
        }
//        System.out.println(Arrays.deepToString(nums));
        // HashMap里套一个HashSet，建立去重后的map
        // ***硬记***
        HashMap<Integer, HashSet<Integer>> relation = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!relation.containsKey(nums[i][0]))
                relation.put(nums[i][0], new HashSet<>());
            if (!relation.containsKey(nums[i][1]))
                relation.put(nums[i][1], new HashSet<>());
            relation.get(nums[i][0]).add(nums[i][1]);
        }
//        System.out.println(relation);
        int flag = 0;
        for (Integer k : relation.keySet()) {
            for (Integer v : relation.get(k)) {
                // 遍历每个键下的值集，如果每个值作为键，存在对应的值，那么true，否则false
                if (!relation.get(v).contains(k)) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
