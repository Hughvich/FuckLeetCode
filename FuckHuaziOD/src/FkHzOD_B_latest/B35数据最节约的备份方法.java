package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|35|数据最节约的备份方法|二分法|100|
 * 若干个文件，刻录光盘的方式进行备份，假设每张光盘容量是500MB，求使用光盘最少的文件分布方式，
 * 所有文件大小都是整数MB，且不超过500MB，文件不能分割，分卷打包
 * 输入描述：组文件大小的数据
 * 输出：使用光盘的数量
 * 补充说明：不考虑输入数据不合法的情况，假设最多输入100个文件，
 * 示例1：
 * 100,500,300,200,400
 * 输出：
 * 3
 * 说明：
 * 三张光盘：(100,400),(200,300),(500)
 * 示例2：
 * 100,100,200,300
 * 输出：
 * 2
 *
 * 思路：
 * 二分法，target是输出光盘数？
 * mid为假定光盘数，放得下往左移，否则右移
 */
public class B35数据最节约的备份方法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] files = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(files);

        int left = 0;
        int right = files.length + 1; //为什么 + 1 ？？？
        while (left < right){
            int mid = left + (right - left) / 2;
            if (calculate(mid, files)) {
//                System.out.println("right");
                right = mid;
            }
            else
                left = mid + 1;
        }
        System.out.println(left);
    }

    private static boolean calculate(int numDisk, int[] files) {
        int[] disks = new int[numDisk];
        for (int i = 0; i < numDisk; i++) {
            disks[i] = 500;
        }
        for (int i = files.length - 1; i >= 0; i--) {
            Arrays.sort(disks);
//            System.out.println(Arrays.toString(disks));
            // 一直把最右边的（最大的）磁盘循环放入文件（减掉容量）
            if (disks[numDisk - 1] >= files[i]) {
                disks[numDisk - 1] -= files[i];
//                System.out.println(numDisk - 1);
            }
            else return false;
        }
        return true;
    }
}
