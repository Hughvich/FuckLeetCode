package FkHzOD_B_old;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B|25|乱序整数排序两数之和绝对值最小|双指针|100|
 * 给定一随机整数数组nums，可能存在正整数和负整数，
 * 在该数组中找出两个数，和的绝对值|nums[x]+nums[y]|最小，从小到大 返回两个数及绝对值
 * 输入：空格分隔的无序整数序列字符串，最多1000个整数，范围-65535 ~ 65535
 * 输出：两个数，最小两数之和绝对值
 *
 * 示例输入：
 * -1 -3 7 5 11 15
 * 输出：
 * -3 5 2
 *
 * 思路1：分支判断：三种情况：两正，两负，一正一负
 * 先排序，再二分法。找最靠近target的数
 * 两正两负：找到|x|最小的数，最靠近0的数，再找到第二小的，0就是target
 * 一正一负：对于任一负数target x，找最靠近其|x|的正数
 * 以上方法有点繁琐，索引需要用得66
 *
 * 思路2：按绝对值排序，取相邻数之和比较
 * 0 -1 2 -3 5 -8 10
 * 但实际上排序速度如果是n2，和直接暴力比较一样
 *
 * 思路3：TreeSet双层暴力比较，
 * TreeSet集合，不重复，排序，无索引不能遍历
 *
 *
 */
public class B25乱序整数序列两数之和绝对值最小 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ip = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 用于测试，1000个随机数
//        Random random = new Random();
//        int[] ip = new int[1000];
//        for (int i = 0; i < ip.length; i++) {
//            ip[i] = (int) ((int) Math.pow(-1, random.nextInt() % 2) * (Math.random() * 65535));
//        }
//        Arrays.sort(ip);
        System.out.println(Arrays.toString(ip));
        int min = Integer.MAX_VALUE;

        Set<Integer> res = new TreeSet<>();
        // 存答案不用TreeSet也行，
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < ip.length - 1; i++) { // 注意遍历范围，length - 1
            for (int j = i; j < ip.length; j++) {
                Integer a = ip[i];
                Integer b = ip[j];
                int sum = Math.abs(a + b);
                if (sum < min && !a.equals(b)) {
                    min = sum;
                    result.clear();
                    result.add(a);
                    result.add(b);
                    result.sort(Comparator.comparingInt(o -> o));
                    res.clear();
                    res.add(a);
                    res.add(b);

                }
            }
        }
        if (res.size() != 0)
//            res.forEach(integer -> System.out.print(integer + " "));
            result.forEach(integer -> System.out.print(integer + " "));
        System.out.println(min);
    }


}
