package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B|8|高矮个子排队|排序算法|100|
 * 现在有一队小朋友，他们高矮不同，我们以正整数数组表示这一队小朋友的身高，如数组5,3,1,2,3。
 * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，每一个“高”位置的小朋友要比相邻的位置高或者相等；每一个“矮”位置的小朋友要比相邻的位置矮或者相等；要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
 * 移动距离的定义如下所示：第二位小朋友移到第三位小朋友后面，移动距离为1，若移动到第四位小朋友后面，移动距离为2。
 * 输入描述：
 *
 * 排序前的小朋友，以英文空格的正整数：4 3 5 7 8
 * 小朋友<100个
 * 输出描述：
 *
 * 排序后的小朋友，以英文空格分割的正整数：4 3 7 5 8
 * 输出结果为最小移动距离，只有5和7交换了位置，移动距离都是1
 * 示例：
 * 输入：
 * 4 1 3 5 2
 * 输出：
 * 4 1 5 2 3
 * 输入：
 * 1 1 1 1 1
 * 输出：
 * 1 1 1 1 1
 *
 * 注意：
 * 考虑非法输入情况，输出空数组
 *
 * 思路：
 * try-catch捕获非法输入情况
 * 最小移动距离：循环比较当前位置和后面位置大小，交换，高位为起点
 * 记着 无限序列 转换成List集合的方法：Arrays.stream(in.nextLine().split(" "))
 *                     .map(Integer::parseInt).collect(Collectors.toList());
 *
 *
 */
public class B8高矮个子排队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            // %取余单双数，单数前比后小的交换，双数前比后大的交换
            for (int i = 0; i < nums.size() - 1; i++) {
                if (i % 2 == 0) {
                    if (nums.get(i) < nums.get(i + 1)) {
                        Integer tmp = nums.get(i);
                        nums.set(i , nums.get(i + 1));
                        nums.set(i+1 , tmp);
                    }
                } else {
                    if (nums.get(i) > nums.get(i + 1)) {
                        Integer tmp = nums.get(i);
                        nums.set(i , nums.get(i + 1));
                        nums.set(i+1 , tmp);
                    }
                }
            }

            System.out.println(nums);

        } catch (Exception e) {
            System.out.println("[]");
        }
    }
}
