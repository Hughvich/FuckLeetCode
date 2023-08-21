package FkHzOD_B_latest;

import java.util.*;

/**
 * B|39|乘坐保密电梯|回溯法/递归|100|
 * 有一座保密大楼，你从0楼到达指定楼层m，必须这样的规则乘坐电梯：
 * 给定一个数字序列，每次根据序列中的数字n上升n层或者下降n层，
 * 前后两次操作的方向 必须相反，规定首次的方向向上，自行组织序列的顺序按规定操作到达指定楼层。
 * 求解到达楼层的序列组合，如果不能到达楼层，给出小于该楼层的最近序列组合。
 * 说明：操作电梯时不限定楼层范围，必须对序列中的每个项进行操作，不能只使用一部分
 * 输入描述：
 * 第一行：期望的楼层，范围1-50；序列总个数，取值范围1-23
 * 第二行：序列，每个取值范围1-50
 * 输出描述：
 * 能够到达楼层或者小于该楼层最近的序列
 * 示例1：
 * 5 3
 * 1 2 6
 * 输出：
 * 6 2 1
 * 说明：1 2 6 和 6 2 1均为可行解，按处理大值原则结果为6 2 1
 * 思路：
 * 向上和向下分为正负两个数组，一组向上up，一组向下down，总和为total，期望楼层target，
 * 则数组和：upSum - downSum <= target，upSum + downSum = total,
 * 转换为：total - 2downSum <= target, 或 2upSum - total <= target，
 * 求解其中一半的数组即up或者down，
 *
 */
public class B39乘坐保密电梯 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        List<Integer> floors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            floors.add(in.nextInt());
        }

        int minDis = Integer.MAX_VALUE;
        int sum = floors.stream().mapToInt(Integer::valueOf).sum();

        // 找出下降层数
        ArrayList<Integer> downs = new ArrayList<>();
        boolean isSolved = false;
        solve(target, sum, floors, minDis, n/2, new ArrayList<>(), 0, downs, isSolved);

        for (Integer down : downs) {
            floors.remove(down);
        }

        Collections.reverse(floors);
        Collections.reverse(downs);

        String res = "";
        // 上升下降交替存在
        for (int i = 0; i < floors.size(); i++) {
            res += floors.get(i) + " ";
            if (i < downs.size())
                res += downs.get(i) + " ";
        }

        System.out.println(res);

    }

    private static void solve(int target, int sum, List<Integer> floors, int minDis, int n,
            ArrayList<Integer> list, int idx, ArrayList<Integer> downs, boolean isSolved) {
        if (isSolved)
            return;
        if (n != 0) {
            for (int i = 0; i < floors.size(); i++) {
                list.add(floors.get(i));
                solve(target, sum, floors, minDis, n - 1, list, idx  +1, downs, isSolved);
                list.remove(list.size() - 1);
            }
        } else {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                count += list.get(i);
            }
            int dis = Math.abs(sum - 2 * count - target);
            if (dis == 0) {
                downs = new ArrayList<>(list);
                isSolved = true;
            } else if (minDis > dis) {
                minDis = dis;
                downs = new ArrayList<>(list);
            }
        }

    }
}
