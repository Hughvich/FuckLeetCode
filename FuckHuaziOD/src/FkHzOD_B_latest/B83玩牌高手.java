package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|83|玩牌高手|逻辑分析|200|
 * 给定一个长度n的数组，表示选手在n轮内可选择的牌面分数，基于以下规则选牌，
 * 求所有轮结束后可获得最高的分数；
 * 1. 每轮可选该牌面，新总分数为加上该论牌面分数；
 * 2. 也可以不选牌面，直接到下一轮，总分还原为3轮前的分数，若轮次小于等于3，则置0
 * 3. 选手初始分数0，必须依次参加每一轮
 * 输入：
 * 1,-5,-6,4,3,6,-2
 * 输出：
 * 11
 * 说明：一共7轮，第一轮选择，
 * 分1，第二轮不选，分0，三不选，分0，
 * 四选，分4，五选，分7，六选，分13，七选，分11
 *
 * 思路：
 * 3轮以内，有负数就不选；
 * 3轮以后，当前数为负数时，看3轮前的总分与加上当前数的大小？
 *
 *
 * */
public class B83玩牌高手 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int[] total = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[0] > 0)
                total[0] = nums[0];
            else if (i <= 2) {
                if (nums[i] < 0)
                    total[i] = 0;
                else
                    total[i] = total[i - 1] + nums[i];
            } else {
                if (nums[i] < 0) {
                    // 前3轮和 小于 选当前牌的和，选当前牌
                    if (total[i - 3] <= total[i - 1] + nums[i])
                        total[i] = total[i - 1] + nums[i];
                    // 不选当前牌，回滚到i-3
                    else total[i] = total[i - 3];
                } else
                    total[i] = total[i - 1] + nums[i];
            }
        }
        System.out.println(Arrays.toString(total));
        System.out.println(total[nums.length - 1]);
    }
}
