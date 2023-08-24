package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|70|数列描述|逻辑分析|100|
 * 数列A[n]，每一项记录上一项有“几个几”，
 * A[0] = 1,A[1] = 11,A[2] = 21,A[3] = 1211,A[4] = 111221,
 *
 * 输入n，输出第n项的值，如输入4，输出111221
 *
 * 思路：
 * 双层循环，外层n，里层每上个A[n]的长度
 * count记数，val字面值，stringbuilder拼接
 * 把每个A[i - 1]toCharArr，遍历，如果前一个ch==后一个ch，count++，
 * 否则count置1，val等于后一个ch，sb拼接
 * 关键是要 内外循环 都要拼接
 *
 *
 */
public class B70数列描述 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<String> A = new ArrayList<>();
        A.add("1");
//        A.add("11");

        for (int i = 1; i <= n; i++) {
//            System.out.println("---------");
            StringBuilder builder = new StringBuilder();
            int count = 1;
            char[] chars = A.get(i - 1).toCharArray();
            char val = chars[0];
            for (int j = 1; j < chars.length; j++) {
//                System.out.println("________");
                if (chars[j] == chars[j - 1]) {
                    count++;
                } else {
                    builder.append(count).append(val);
                    System.out.println("builderInner: " + builder);
                    count = 1;
                    val = chars[j];
                }
            }
            builder.append(count).append(val);
            System.out.println("builderOuter: " + builder);
            A.add(builder.toString());
            if (i == n) {
                System.out.println(builder);
                return;
            }
        }
    }
}
