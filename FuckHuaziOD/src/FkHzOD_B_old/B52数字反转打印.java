package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * B|52|数字反转打印|逻辑模拟|100|
 * （小华是一个对数字很敏感的小朋友,...）
 * 数字多行排列，第一行1个数，第二行2个，第三行3个，第n行n个，
 * 奇数行正序排列，偶数行逆序排列，数字依次累加
 * 每个数字占据4个位置，不足四位用星号*补位，如1***
 * 数字之间相邻4个空格，打印顺序按照正序逆序交替打印，
 * 最后一行数字顶格，第n - 1行相对第n行缩进四个空格
 *
 * 输入描述：
 * 一行输入为N，表示打印多少行，N在1~30
 * 输出描述：即以上打印规则
 *
 * 示例1：
 * 输入
 * 2
 * 输出
 *     1***
 * 3***    2***
 *
 * *星号表示数字不满4位时的补位，符号X表示数字间的空格
 *
 * 思路：
 * 输出一个金字塔，金字塔数字需要用到递归，
 * f(n - 1) + n - 1 表示每层第一个数字（翻转之前的）
 *
 */
public class B52数字反转打印 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<List<String>> lists = new ArrayList<>();
        // 按金字塔层数N，一层一层往下加
        for (int i = 1; i <= N; i++) {
            List<String> list = new ArrayList<>();
            int firstNum = firstNumber(i);

//            System.out.println("firstNum: " + firstNum);

            // 最头上（最左边）有一个空格，每次增加一层，多加一格
            lists.forEach(x -> x.add(0, "    "));

//            System.out.println("lists init: " + lists);

            // j就是同一行list的循环
            for (int j = 0; j < i; j++) {
                String temp = firstNum++ +"***";
//                System.out.println("temp: " + temp);
                list.add(temp.substring(0,4)); //每一个数字占据4格，超过的截掉

//                System.out.println("temp.substring(0,4): " + temp.substring(0,4));

                if (j != i - 1)
                    list.add("    "); //最后一个之前都加空格
            }
            if (i % 2 == 0)
                Collections.reverse(list);
            lists.add(list);

//            System.out.println("lists final: " + lists);
        }
        lists.forEach(x -> {
            StringBuilder res = new StringBuilder();
            for (String s:x) {
                res.append(s);
            }
            System.out.println(res);
        });
    }

    // 递归产生金字塔数
    public static int firstNumber(int n) {
        if (n == 1) return 1;
        return firstNumber(n - 1) + n - 1;
    }
}
