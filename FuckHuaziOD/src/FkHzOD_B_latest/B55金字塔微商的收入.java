package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * B|55|金字塔/微商的收入|数据结构|100|
 * 微商金子塔模式，下级赚100，上交15，
 * 输入：第一行N，表示N行，
 *      后N行表示N个代理商，每行三个数：
 *      代理商代号 上级代号 赚的钱
 * 输出：顶级代理商代号 赚的钱
 * 输入：
1 0 223
2 0 323
3 2 1203
 * 输出：
 * 0 105
 * 思路：
 * 将代理商代号降序排序，遍历得HashMap，
 * key是上级代号，value是所得收入
 *
 */
public class B55金字塔微商的收入 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = new int[n][3];
        for (int i = 0; i < n; i++) {
            mat[i][0] = in.nextInt();
            mat[i][1] = in.nextInt();
            mat[i][2] = in.nextInt();
        }
        // key是上级代号，value是所得收入
        HashMap<Integer, Integer> relationMap = new HashMap<>();
        Arrays.sort(mat, (o1, o2) -> o2[1] - o1[1]);

        int top = mat[mat.length - 1][1];

        for (int[] cur:mat) {
            int id = cur[0];
            int supId = cur[1];
            int income = cur[2];

            if (relationMap.containsKey(id))
                income += relationMap.get(id);
            //relationMap.getOrDefault(supId, 0)下级收入，有则累加，无则为0
            relationMap.put(supId, relationMap.getOrDefault(supId, 0) + income / 100 * 15);
            System.out.println(relationMap);
        }

        System.out.println(top + " " + relationMap.get(top));
    }
}
