package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|67|报数游戏|逻辑分析 / 约瑟夫问题 |100|
 * 100个人围成一圈，每个人编号1开始到100，
 * 从1开始报数，报M的人自动退出，下一人从1开始报，直到剩余人数小于M
 * 问：最后剩余的人在原先的编号？
 * 输入：一个整数M
 * 输出：如果M<=1或 >=100输出ERROR!
 * 示例：
 * 输入：3
 * 输出：58,91
 * 说明：输入为3，最后剩两人
 * 示例2：
 * 输入：4
 * 输出：34,45,97
 *
 * 思路：
 * 约瑟夫环问题，
 * 模拟报数：设外部变量count = 1，报数一次+1，判断count是否超过M，超过置1
 * 遍历删除最头上的人，如果没到M，就加到末尾，到M的就不加
 *
 */
public class B67报数游戏 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        if (M <= 1 || M >= 100) {
            System.out.println("ERROR!");
            return;
        }

        List<Integer> people = new ArrayList<>(100);
        for (int i = 0; i < 100; i++)
            people.add(i + 1);

        int count = 1;
        while(people.size() >= M) {
            if (count == M)
                count = 1;
            else {
                count++;
//                if(count % M == 0)
                people.add(people.get(0));

            }
            // 每个人都删掉，如果不是M就加回去到末尾，形成一个环
            people.remove(0);
        }
        System.out.println(people);


    }
}
