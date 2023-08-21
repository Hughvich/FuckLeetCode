package FkHzOD_B_latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * B|38|支持优先级的队列|数据结构|100|
 * 实现一个支持优先级的队列，高优先级 先出队列，同优先级 先进先出；
 * 如果两个输入数据相同且优先级相同，后一个数据不入队列被抛弃，如果(10,1),(10,1)
 * 队列存储整数；优先级 1 - n 逐渐增高
 * 输入描述：一组待存入队列的数据（内容和优先级）
 * 输出描述：队列的数据，不再体现优先级
 * 示例1：
 * (10,1),(20,1),(30,2),(40,3)
 * 输出：
 * 40,30,10,20
 * 后两个10和20优先级相同，按输入顺序
 * 示例2：
 * (10,1),(10,1),(30,2),(40,3)
 * 输出：
 * 40,30,10
 *
 * 思路：
 * 自定义排序
 * 优先队列pq
 * 括号换掉，replaceAll
 *
 * PriorityQueue使用方法：
 * .poll()，.peek()取出优先级最高的，最靠前的
 */
public class B38支持优先级的队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().replaceAll("\\(", "").replaceAll("\\)", "").split(",");

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length; i+=2) {
            int num = Integer.parseInt(s[i]);
            int priority = Integer.parseInt(s[i + 1]);
            Data data = new Data(num, priority);
            pq.add(data);
        }
        System.out.println(Arrays.toString(pq.toArray()));

        ArrayList<Integer> result = new ArrayList<>();
        Data tail = pq.poll();
//        System.out.println("tail: " + tail);
        // 防止重复机制：tail是上个循环的尾，top是本次循环的头，排序后的头尾相等意味着两个data完全相同，不加入result
        while (tail != null) {
//            System.out.println("------------------------");
            Data top = pq.peek();
//            System.out.println("top: " + top);
            if (!tail.equals(top))
                result.add(tail.num);
            tail = pq.poll();
//            System.out.println("tail: " + tail);
//            System.out.println(result);
        }

        System.out.println(result);

    }

    // 静态比较类Data
    public static class Data implements Comparable<Data> {
        int num;
        int priority;

        public Data(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
        // 按priority降序排列
        @Override
        public int compareTo(Data o) {
            return o.priority - this.priority;
        }

        // 重写equals方法，num和priority都要相等
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            Data myComparator = (Data) obj;
            return this.num == myComparator.num && this.priority == myComparator.priority;
        }

        @Override
        public String toString() {
            return "{" + num + ", " + priority + '}';
        }
    }
}
