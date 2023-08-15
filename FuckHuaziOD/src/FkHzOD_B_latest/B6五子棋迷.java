package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B|6|五子棋迷|逻辑分析|100|
 * 张兵和王武是五子棋迷，工作之余经常切磋棋艺。这不，这会儿又下起来了。走了一会儿，轮张兵了，对着一条线思考起来了，这条线上的棋子分布如下
 * 用数组表示: -1 0 1 1 1 0 1 01 1
 * 棋子分布说明:
 * 1.-1代表白子，0代表空位，1 代表黑子
 * 2.数组长度L,满足 1 < L < 40,且L为奇数
 * 你得帮他写一个程序，算出最有利的出子位置。最有利定义
 * 1.找到一个空位(0)，用棋子(1/-1)填充该位置，可以使得当前子的最大连续长度变大
 * 2.如果存在多个位置，返回最靠近中间的较小的那个坐标;
 * 3.如果不存在可行位置，直接返回-1:
 * 4.连续长度不能超过5个(五字棋约束)
 * 输入描述:
 * 第一行: 当前出子颜色
 * 第二行: 当前的棋局状态
 * 输出描述
 * 1个整数，表示出子位置的数组下标
 *
 * 示例1
 * 输入:
 * 1
 * -1 0 1 1 1 0 1 0 1 -1 1
 * 输出:5
 * 说明:
 * 当前为黑子 (1)，放置在下标为5的位置，黑子的最大连续长度，可以由3到5
 *
 * 示例2
 * 输入:
 * -1
 * -1 0 1 1 1 0 1 0 1 -1 1
 * 输出:1
 * 说明:
 * 当前为白子，唯一可以放置的位置下标为1，白子的最大长度，由1变为2
 *
 * 示例3
 * 输入:
 * 1
 * 0 0 0 0 1 0 0 0 0 1 0
 * 输出:5
 * 说明:可行的位置很多，5最接近中间的位置坐标
 *
 * 改自LC#424 替换后的最长重复字符，
 * 如何将一个字符串改变K个字符，变成一个连续串，
 * 如果当前字符串中出现次数最多的字母个数+k大于串总长度，那么满足条件
 * 思路：
 * 双指针，滑动窗口法
 * 尽量选中间位置
 *
 * left，right窗口两端，maxLen窗口内同棋子数量，
 * 如果窗口大小 - maxLen > k, 说明不能在k范围内将空位0变为同棋子（1或-1），
 * 则遍历后返回窗口大小
 * 在LC#424 k是变化的，这里k=，改变其中一个0位为1或-1，变成连续子串，
 *
 */
public class B6五子棋迷 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.nextLine();
        int[] field = new int[39];
        String[] ip = in.nextLine().split(" ");
        for (int i = 0; i < ip.length; i++) {
            field[i] = Integer.parseInt(ip[i]);
        }
        //或者以下方式将一行空格数组转为int[]
//        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxVal = Integer.MIN_VALUE; // 总数最大的？？
        int midDist = 0; //到中位的距离？
        int resIndex = -1; //答案索引
        int count = ip.length;
        for (int i = 0; i < count; i++) {
            System.out.println("i: " + i);
            // 有空位，就窗口围绕，
            if (field[i] == 0) {
                int left = i - 1;
                int right = i + 1;
                int leftCount = 0;
                int rightCount = 0;
                // 左边是1或-1，左界数+1，左界左移
                //leftCount < maxVal - 1是什么？
                while (left >= 0 && field[left] == target && leftCount < maxVal - 1){
                    System.out.println("entered left");
                    leftCount++;
                    System.out.println("leftCount++: " + leftCount);
                    left--;
                }

                if (leftCount > 4) {
                    System.out.println("leftCount > 4");
                    continue;
                }

//                rightCount = leftCount; // ？？？
                // 右界是1或-1，右界数+1，右界右移
                while (right < count && field[right] == target && rightCount < maxVal - 1) {
                    System.out.println("entered right");
                    rightCount++;
                    System.out.println("rightCount++: " + rightCount);
                    right++;
                }

                int totalCount = leftCount + rightCount;
                int disToMid = Math.abs(i - count / 2);

                // midDist要最小，即最靠中间
                if (totalCount > maxVal || (totalCount == maxVal && disToMid < midDist)) {
                    maxVal = totalCount;
                    System.out.println("totalCount: " + totalCount);
                    resIndex = i;
                    System.out.println("resIndex: " + resIndex);
                    midDist = disToMid;
                    System.out.println("midDist: " + midDist);
                }
            }
        }
        System.out.println(resIndex);
    }
}
