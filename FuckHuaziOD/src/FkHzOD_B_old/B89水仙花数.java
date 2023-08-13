package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|89|水仙花数|逻辑模拟|100|
 * 水仙花数：n位正整数，个位数n次方和等于其本身
 * 输入：第一行：整数n，3到7之间
 *      第二行：正整数m，
 * 输出：返回长度n的第m个水仙花数，个数从0编号，
 * 若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积
 * 输入不合法，返-1
 *
 * 示例
 * 输入
 * 3
 * 0
 * 输出
 * 153
 *
 * 示例2输入
 * 9
 * 1
 * 输出
 * -1 （超出范围）
 *
 * 思路：
 * 暴力法，就算10^7并不大，所以可以暴力
 * 遍历N位数的每一个数，从10^(N-1)到10^N，比如N=3，就从100遍历到1000（相当于999）
 */
public class B89水仙花数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // 超出3或7的范围：
        if (n < 3 || n > 7)
            System.out.println(-1);

        List<Integer> ans = new ArrayList<>();

        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);

        for (int i = start; i < end; i++) {
            int sum = 0;
            int bit = start; //位数从10^(n-1)位（最高位）开始
            // 找出水仙花数
            while (bit >= 1) {
                // 这一步即自己的最高位数到十位数，
                // 每一位数n次方后相加，最核心的一步
                sum += Math.pow((i / bit) % 10, n);
                bit /= 10;
            }
            // 再加到个位数(这一步合并到上面循环里)
//            sum += Math.pow(i % 10, n);

            //只要遍历到是水仙花数，就加进去
            if (sum == i)
                ans.add(i);
            // 编号从0开始，所以m+1
            if (ans.size() == m + 1) {
                System.out.println(i);
                break;
            }
        }

        // 如果m大于所有的水仙花数量，循环结束后再判断
        if(ans.size() < m)
            System.out.println(m * ans.get(ans.size() - 1));
    }

}
