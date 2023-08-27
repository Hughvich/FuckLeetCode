package FkHzOD_B_latest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * B|77|荒岛求生|数据结构 / 栈|200|
 * 一个荒岛，左右两个港口，一群人逃生，往左走负数，往右走正数，
 * 两人相遇，数大的打败数小的，相同的同归于尽，打赢的减掉，
 * 输入：
 * 5 10 8 -8 -5
 * 输出：
 * 2
 *
 * 思路：
 * 两个栈记录正数和负数，
 * 遍历整个数组，两个栈分别弹出比较
 *
 * bug: 负数在左正数在右，算法失效
 */
public class B77荒岛求生 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> s1 = new Stack<>(); //正数栈
        Stack<Integer> s2 = new Stack<>(); //负数栈

        for (int num : nums) {
            if (num > 0)
                s1.push(num);
            else s2.push(Math.abs(num));
        }

        // 负数在左，正数在右的判断
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] < 0) {
                l++;
                System.out.println("!");
                if (nums[r] > 0)
                    r--;
                else break;
            }
            else break;
        }
//        System.out.println(l + " " + r);
        if (l >= r) {
            System.out.println(nums.length);
            return;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() > s2.peek())
                s1.push(s1.pop() - s2.pop());
            else if (s2.peek() > s1.peek())
                s2.push(s2.pop() - s1.pop());
            else {
                s1.pop();
                s2.pop();
            }
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.size() + s2.size());
    }

}
