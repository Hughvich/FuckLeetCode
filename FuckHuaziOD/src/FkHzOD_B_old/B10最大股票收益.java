package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|10|最大股票收益|贪心算法|200|
 *
 * ******相似题6 力扣LC#122.买卖股票的最大时机******
 * 某段连续时间内股票价格，计算通过买入卖出可获得的最大收益。
 * 输入一个大小为n的数price(p1,p2,p3,...pn),pi是第i天的股票价格。
 * pi的格式为股票价格（非负整型）加上货币单位Y（人民币）或者S（美元），这里规定1美元=7人民币，如123Y=861S
 * 输入：一个包含交易周期内各天股票价格的字符串，空格分隔
 * 输出：一个整型数代表在交易周期n天内能获得的最大收益，n<=10000
 * 示例：
 * 输入：2Y 3S 4S 6Y 8S
 * 输出：76
 *
 * 思路：
 * 可用动态规划，但不能硬记，
 * 贪心算法，局部最优解，只要后面一天价格高于今（当前）天的，就在今天买入，后一天卖出
 * 连续涨也算是连续每天卖出再买入
 * 连续跌则不进行交易
 */
public class B10最大股票收益 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<Integer> inputList= new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                // 第一种char转为int方式
                inputList.add((input.charAt(i - 1) - '0') * 7);
            } else if (input.charAt(i) == 'Y') {
                // 第二种char转为int方式
                inputList.add(Integer.parseInt(String.valueOf(input.charAt(i - 1))));
            }
        }

        int revenue = 0;
        for (int i = 0; i < inputList.size() - 1; i++) {
            if (inputList.get(i) < inputList.get(i + 1)) {
                revenue += inputList.get(i + 1) - inputList.get(i);
            }
        }
        System.out.println(revenue);
    }
}
