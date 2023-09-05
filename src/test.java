import java.io.BufferedInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //以下只为把二维输入转为二维数组，很臃肿
        /*
        int n = in.nextInt();
        in.nextLine();
        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tmpstrs = in.nextLine().split(" ");
            int tmpLen = tmpstrs.length;
            int[] nums = new int[tmpLen];
            for (int j = 0; j < tmpLen; j++) {
                nums[j] = Integer.parseInt(tmpstrs[j]);
            }
            mat[i][0] = nums[0];
            mat[i][1] = nums[1];
        }

         */

        // 位运算
        /*
        int sum = 0;
        int x = 259;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (x >> (i * 8)); // 256 >> 0 = 256 8个0, >> 8 = 1, >> 16 = 0, >> 24 = 0
            System.out.println("sum: " + sum);
        }

        System.out.println(256 >> 16);

         */
        //优先队列测试
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(7);
        System.out.println(Arrays.toString(pq.toArray()));

        System.out.println(n);
        */

        //GCD欧几里得最大公因数算法
        /*
        int x = 6;
        int y = 3;
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        System.out.println(x);

        System.out.println("ABCDEF".substring(3));

         */

        List<Integer> numList = List.of( 20, 100, 10, 12, 5, 13);
        List<Integer> subList1 = numList.subList(0, 2);
        List<Integer> subList2 = numList.subList(3, 6);
        System.out.println(subList1);
        System.out.println(subList2);

    }

}
