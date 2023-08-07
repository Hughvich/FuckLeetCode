package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|27|喊七的次数重排|约瑟夫问题|100|
 * N个人围成一圈，顺时针从1到N编号，
 * 编号1的人开始报数，下一个人的数字为上一个人加1，但当喊出来数字为7或其倍数或含7，要喊“过”；
 * 假定N个人都没有失误地正确时机喊出“过”，喊到K时，统计每个人喊“过”的次数；
 * 现给定一个长度N的数组，存储打乱了顺序的每个人喊“过”的次数，把它还原成正确的顺序，
 * 即数组的第i个元素存储编号i的人喊“过”的次数。
 *
 * 输入：一行，空格分隔，喊“过”的次数，K不提供，<= 200,数字个数就是N（数组长度）
 * 输出：一行，空格分隔，顺序正确的喊“过”的次数
 *
 * 示例1
 * 输入：0 1 0
 * 输出：1 0 0
 * 说明：只有一次喊过，编号1的人遇到了7，所以1 0 0
 *
 * 示例2
 * 输入：0 0 0 2 1
 * 输出：0 2 0 1 0
 * 说明：
 * 一共三次喊过，在7 14 17，按顺序编号2的人需要7 17，编号4的人遇到14
 *
 * 思路：
 * 直接遍历7出现的次数就行，以数组长度N为限，不用管数组顺序
 */
public class B27喊7的次数重排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> n = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int N = n.size();
        int sum = n.stream().mapToInt(integer -> integer).sum();
        int i = 1; //循环索引
        int numOf7 = 0; // 7出现的次数
        int[] res = new int[N];
        Arrays.stream(res).forEach(j -> j = 0);

        while (numOf7 < sum) {
//            System.out.println("------ i= " + i);
            if (i % 7 == 0 || String.valueOf(i).contains("7") ) {
                numOf7++;
//                System.out.println("numOf7: " + numOf7);
                res[i % N - 1]++;
//                System.out.println(Arrays.toString(res));
            }
            i++;
        }
        for (int k = 0; k < N; k++) {
            System.out.print(res[k] + " ");
        }
    }
}
