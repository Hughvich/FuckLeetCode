package FkHzOD_B_old;

import java.util.*;
import java.util.stream.IntStream;

/**
 * B|17|整数对最小和|逻辑模拟|100|
 * 给定两个整数数组array1，array2，数组元素按 升序排列
 * 假设从array1，2中分别取出一个元素可构成一对元素，现需要取出k对，
 * 并对取出的所有元素求和，计算和的最小值
 * 注意：两对元素如果对应于array1，array2中的两个下标均相同，则视为同一元素
 *
 * 输入描述：
 * 两行数组array1，array2，每行首个数字为数组大小size，∈(0,100]，元素大小∈(0,1000]
 * 接下来一行为正整数k：0 < k <= array1.size() * array2.size()
 * 输出描述：满足要求的最小和
 *
 * 示例1 输入
 * 3 1 1 2
 * 3 1 2 3
 * 2
 * 输出
 * 4
 * （取以下两组：
 *  a1[0] - a2[0] = [1,1]
 *  a1[1] - a2[0] = [1,1]
 *  求和 1+1+1+1 = 4）
 *
 *  数组大小有限，暴力法,
 *  遍历两数组，求所有相加结果，排序后输出前K个的和
 *
 */
public class B17整数对最小和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        int n1 = in.nextInt();
        for (int i = 0; i < n1; i++) {
            a1.add(in.nextInt());
        }
        int n2 = in.nextInt();
        for (int i = 0; i < n2; i++) {
            a2.add(in.nextInt());
        }
        int k = in.nextInt();

        List<Integer> K = new ArrayList<>();
        // K = [2,3,4,2,3,4,3,4,5]
        int[] nums = new int[2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                nums[0] = (a1.get(i));
                nums[1] = (a2.get(j));
//                    int sum = IntStream.of(nums).sum();
                int sum = nums[0] + nums[1];
                K.add(sum);
            }
        }
        K.sort(Comparator.comparingInt(o -> o));

        int sumK = 0;
        for (int i = 0; i < k; i++) {
            sumK += K.get(i);
        }
        System.out.println(sumK);
    }
}
