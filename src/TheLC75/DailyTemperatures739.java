package TheLC75;

import java.util.Arrays;
import java.util.Stack;

/**
 * LC#739.Med 每日温度 【单调栈】
 * 给定一个整数数组 temperatures ，表示每天的温度，
 * 返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 思路：
 * 单调栈，单调递增，
 * 后一个比前一个大，弹栈，计算距离并计入answer，小或相等，入栈，
 *
 */
public class DailyTemperatures739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        // 单调增栈用于记录位置
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            System.out.println(stack);
            // 如果后一个比前一个大，弹栈，计算距离并计入answer，
            while ((!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            // 其他情况：小或相等，入栈，
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
