package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|32|数字游戏|逻辑分析|100|
 * 小明玩一个游戏，系统发n + 1张牌，每张牌有一个整数，第一张给小明，后n张按照发牌顺序排成连续的一行，
 * 需要小明判断，后n张牌中，是否存在连续的若干张牌的和，可以整除小明中牌上的数字
 * 输入：多组，每组输入有两行，
 * 第一行两个整数n和m，空格隔开，m代表发给小明牌上的数字，
 * 第二行有n个数，代表后续发的n张牌上的数字，以空格隔开，
 * 输出：对于每组输入如果满足条件输出1，否则输出0
 * 示例1：
 * 输入：
 * 6 7
 * 2 12 6 3 5 5
 * 10 11
 * 1 1 1 1 1 1 1 1 1 1
 * 输出：
 * 1
 * 0
 * 说明：两组输入，
 * 第一组小明的牌为7，再发6张牌，第1，2两张之和14，可以整除，输出1
 * 第二组小明的牌11，发10张牌，10张和10无法整除11，输出0
 *
 * 思路：
 * LC#974
 * 前缀和，对k取模，余数相同的一对可以得到答案，
 * 这一对中，左开右闭区间即答案，如
 * A = [4,5,0,-2,-3,1]
 * 前缀和 P = [4,9,9,7,4,5]
 * 对于P取K=5的模mod = [4,4,4,2,4,0]
 * 所以mod[0]和mod[1]为4，则A[1]可被k整除，
 * 同理，mod[0]和mod[2]为4，则A[1]+A[2]可被整除，
 * A[1]+A[2]+A[3]+A[4]，A[2]，A[2]+A[3]+A[4]，A[3]+A[4]可被整除
 *
 * 2 12 6 3 5 5，7
 * 0?2,14,20,23,28,33
 * 0?2,0,6,2,0,5
 *
 */
public class B32数字游戏 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            String[] s = line.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            in.nextLine();
            //A = [2 12 6 3 5 5]
            //补0的A：0 2 12 6 3 5 5
            //前缀和pre = [0, 2, 14, 20, 23, 28, 33]
            //前缀和取模mod = [0, 2, 0, 6, 2, 0, 5]
            //mod排序，前后比较，有相等的就符合条件
            int sumPre = 0;
            int[] pre = new int[n + 1]; // 记录前缀和的数组
            int[] mod = new int[n + 1]; // 记录前缀和被模后的数组
            for (int i = 0; i < n; i++) {
                sumPre += nums[i];
                pre[i + 1] = sumPre;
                mod[i + 1] = pre[i + 1] % m;
            }

            Arrays.sort(mod);
            boolean modable = false;
            for (int i = 0; i < mod.length - 1; i++) {
                if (mod[i] == mod[i + 1])
                    modable = true;
            }
            if (modable)
                System.out.println(1);
            else
                System.out.println(0);

        }
    }
}
