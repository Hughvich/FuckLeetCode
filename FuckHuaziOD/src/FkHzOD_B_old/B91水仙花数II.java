package FkHzOD_B_old;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * B|91|水仙花数II|递归算法|100|
 * 给定非空字符串s，将该字符串分割成一些子串，使每个子串的ASCII码值的和均为水仙花数（三位数）
 * 若分割不成功，返回0
 * 若成功却不唯一，返回-1
 * 若成功且唯一，返回分割后的子串数目
 *
 * 输入字符串，最大长度200
 * 示例：
 * 输入：abc
 * 输出：0
 *
 * 示例2：
 * 输入：f3@d5a8
 * 输出：-1
 * 说明：可成功分割但结果不唯一，f3和@d5a8; f3@d5和a8
 *
 * 示例3：
 * 输入：AXdddF
 * 输出：2
 * 可分为AX 和 dddF
 *
 *
 */
public class B91水仙花数II {

    public static LinkedList<Integer> resList = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        int count = 2;
        find(ip, count);

        int res = 0;
        if (resList.size() > 1)
            res = -1;
        else if (resList.size() == 1)
            res = resList.get(0);
        System.out.println(res);
    }

    public static void find(String ip, int count) {
        for (int i = 1; i < ip.length(); i++) {
            String sub1 = ip.substring(0,i);
            String sub2 = ip.substring(i);
            if (checkIsFlower(sub1)) {
                if (checkIsFlower(sub2))
                    resList.add(count);
                else find (sub2, count++);
            }
        }
    }

    public static boolean checkIsFlower (String str) {
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sum += chars[i];
        }
        int i = sum % 10; // 获得十位
        int j = sum / 10 % 10; // 获得个位
        int k = sum / 100; // 获得百位
        return Math.pow(i,3) + Math.pow(j,3) + Math.pow(k,3) == sum;
    }
}
