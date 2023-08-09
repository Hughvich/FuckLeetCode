package FkHzOD_B_old;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * B|39|磁盘容量排序|排序算法|100|
 * 磁盘容量MGT，给定n块磁盘容量，从小到大顺序进行 稳定排序
 * 单位可以重复出现，如3M12G9M容量即为3M + 12G + 9M，和12M12G相等
 * 输入描述：
 * 第一行整数n，2~100，磁盘个数，
 * 接下来n行，每行一个字符串，长度2~30，磁盘容量，
 * 由一个或多个格式为 容量大小+单位的子串组成，如10G6T，20M，3M12G9M
 *
 * 输出描述：
 * 输出n行，表示n块磁盘容量排序后的结果。
 *
 * 示例：
 * 输入：
 * 3
 * 1G
 * 2G
 * 1024M
 * 输出：
 * 1G
 * 1024M
 * 2G
 * 注：稳定排序，即相等的容量保留在原来的相对位置
 *
 * 示例2
 * 输入：
 * 3
 * 2G4M
 * 3M2G
 * 1T
 * 输出：
 * 3M2G
 * 2G4M
 * 1T
 *
 * 思路：
 * 难点：需要一个变量，找到GMT字符之前，保存数字的大小，然后排序
 * 用二维数组，保存索引+容量
 * HashMap？
 */
public class B39磁盘容量排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); //没有这一行会在接收倒数第一个输入时结束（？）

        // 索引-磁盘容量  二维数组，用于计算排序
        int[][] disk = new int[n][2];
        // 索引-磁盘容量+单位 键值对map，用于最后的结果输出
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 容量：各单位下数字的总和sum
            int sum = 0;
            int index = -1;
            String str = in.nextLine();
            map.put(i + 1, str); //第i + 1块磁盘
            for (int j = 0; j < str.length(); j++) {
                //第一次从0到j（不含），第二次j + 1开始，新j会找到下一个字母
                if(str.charAt(j) == 'M') {
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }

            disk[i][0] = i + 1;
            disk[i][1] = sum;
        }
        // 遍历二维数组，排序输出，第一顺序：磁盘容量，第二顺序：自然顺序
        Arrays.sort(disk, ((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] -o2[0]));
        for (int i = 0; i < n; i++) {
                System.out.println(map.get(disk[i][0]));
        }
    }
}
