package FkHzOD_B_latest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * B|15|报文重排序|字符串处理|100|
 * 对报文进行重传和重排序是常用的可靠性机制，重传缓冲区内有一定数量的子报文，每个子报文在原始报文中的顺序已知，现在需要恢复出原始报文。
 * 输入描述
 * 输入第一行为N，表示子报文的个数，0 < N <= 1000。
 * 输入第二行为N个子报文，以空格分开，子报文格式为字符串报文内容+后缀顺序索引，
 * 字符串报文内容由|a-z,A-Z)组成后缀为整形值，表示顺序。顺序值唯一，不重复。
 * 输出描述:
 * EN输出恢复出的原始报文。按照每个子报文的顺序的升席排序恢复出原始报文，顺序后缀需要从恢复出的报文中删除掉
 * 用例1输入:
 * 4
 * rolling3 stone4 like1 a2
 * 输出:
 * like a rolling stone
 * 说明:
 * 4个子报文的内容分别为roling,stone,like,a，顺序值分别为3，4，1，2，按照顺序值升序并删除掉顺序后缀得到恢复的原始报文: like a rolling stone
 *
 * 用例2
 * 输入:
 * 8
 * gifts6 and7 Exchanging1 all2 precious5 things8 kinds3 of4
 * // 注: 这里需要注意:and7与Exchanging1有两个空格
 * 输出:
 * Exchanging all kinds of precious gifts and things
 */
public class B15报文重排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] ip = in.nextLine().split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(String.valueOf(ip[i].charAt(ip[i].length() - 1)));
            ip[i] = ip[i].substring(0, ip[i].length() - 1);
            map.put(idx, ip[i]);
        }

//        System.out.println(map);
        for (int i = 1; i <= n; i++) {
            if (i != n)
                System.out.print(map.get(i) + " ");
            else System.out.print(map.get(i));
        }
    }
}
