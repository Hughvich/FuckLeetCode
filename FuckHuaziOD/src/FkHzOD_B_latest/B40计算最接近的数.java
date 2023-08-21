package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|40|计算最接近的数|逻辑分析 / 滑动窗口?|100|
 * 给定一个数组X和正整数K,请找出使表达式：
 * X[i]-X[i+1]--X[i+K-1]
 * 结果最接近于数组中位数的下标i,如果有多个i满足条件，请返回最大的i.其中，数组中位数：长度为N的数组，按照元素的值大小升序排列后，下标为N/2元素的值
 * 备注 1.数组X的元素均为正整数
 * 2.X的长度n取值范围：2≤n≤1000
 * 3.K大于0目小于数组的大小
 * 4.i的取值范围：0≤i<1000
 * 5.题目的排序数组X[N]的中位数是X[N/2]
 * 用例
 * 输入：[50,50,2,3],2
 * 输出：1
 * 1.中位数为50:[50,50,2,3]升序排序后变成
 * [2,3,50,50],中位数为下标4/2=2的元素50
 * 说明
 * 2.计算结果为1:X[50,50,2,3]根据题目计算X[i]-…-X[i+k-1]得出三个数0(X[0]-X[1]=50-50)、48 (X[1]-X[2]=50-2)和-1(X[2]-X[3]=2-3),
 * 其中48最接近50,因此返回下标1。
 *
 * 思路：可以不用滑动窗口，
 * 先排序，求中位数，再计算最接近的数字即可
 *
 *
 */
public class B40计算最接近的数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().replace("[", "").replace("]", "").split(",");
        int N = s.length - 1;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int K = Integer.parseInt(s[N]);

//        System.out.println(Arrays.toString(nums));
//        System.out.println(K);

        int[] numsSorted = Arrays.copyOf(nums, N);
        Arrays.sort(numsSorted);
        // 中位数
        int mid = numsSorted[N / 2];
        int min = Integer.MAX_VALUE;

        int res = -1;
        // 计算X[i]-…-X[i+k-1]
        for (int i = 0; i < N - K + 1; i++) {
            int count = nums[i];
            for (int j = i + 1; j < i + K; j++) {
                count -= nums[j];
            }
            // 计算X[i]-…-X[i+k-1]和中位数距离abs
            int abs = Math.abs(count - mid);
            min = Math.min(min, abs);
            if (min == abs)
                res = i;
        }
        System.out.println(res);
    }
}
