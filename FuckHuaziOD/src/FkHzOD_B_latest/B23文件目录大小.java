package FkHzOD_B_latest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B|23|文件目录大小|DFS|100|
 * 一个文件目录的数据格式为：目录id，本目录中文件大小，(子目录id列表）。
 * 其中目录id全局唯一，取值范围[1, 200]，本目录中文件大小范围[1, 1000]，
 * 子目录id列表个数[0,10]例如 : 1 20 (2,3) 表示目录1中文件总大小是20，有两个子目录，id分别是2和3
 * 现在输入一个文件系统中所有目录信息，以及待查询的目录 id ，返回这个目录和及该目录所有子目录的大小之和。
 * 输入描述
 * 第一行为两个数字M，N，分别表示 目录的个数 和待查询的 目录id ,1 ≤ M ≤ 100，1 ≤ N ≤ 200
 * 接下来M行，每行为1个目录的数据：
 * 目录id 本目录中文件大小 (子目录id列表)
 * 子目录列表中的子目录id以逗号分隔。
 * 输出描述
 * 待查询目录及其子目录的大小之和
 *
 * 示例1：
3 1
3 15 (0)
1 20 (2)
2 10 (3)

 * 输出：45
 * 说明：目录1大小20，包含一个子目录2大小为10，子目录2包含目录3大小为15，总大小为20+10+15=45
 *
 * 示例2：
5 2
4 20 ()
5 30 ()
2 10 (4,5)
1 40 ()
6 0 ()

 * 输出：60
 * 目录2 包含 2个子目录 4和5，总大小10+20+30=60
 *
 * 思路：
 * 树结构，返回这个目录及其所有子目录大小之和，求当前节点及其所有叶子节点值的和
 * 通过两个map，一个k：目录号，v：子目录列表；另一个：k：目录号，v：容量
 *
 */
public class B23文件目录大小 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        HashMap<Integer, List<Integer>> dirMap = new HashMap<>();
        HashMap<Integer, Integer> capMap = new HashMap<>();
        List<Integer> dir = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String[] line = in.nextLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int cap = Integer.parseInt(line[1]);
            String dirStr = line[2];
            // 两个map加入
            if (!dirMap.containsKey(k))
                dirMap.put(k, new LinkedList<>());
            if (!capMap.containsKey(k))
                capMap.put(k, cap);
            // 如果有子目录，就加进去
            if (dirStr.length() > 2) {
                dirMap.get(k).addAll(Arrays.stream(dirStr.substring(1, dirStr.length() - 1).split(","))
                        .map(Integer::parseInt).collect(Collectors.toList()));
            }

//            System.out.println(dirMap);
//            System.out.println(capMap);
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(n);
        int sum = 0;

        // 关键逻辑，不断找子key，加入LinkedList，pop，加入
        while (list.size() > 0) {
            int k = list.pop();
            if (capMap.containsKey(k)) {
                sum += capMap.get(k);
                list.addAll(dirMap.get(k));
            }
            System.out.println(list);
        }
        System.out.println("sum: " + sum);
    }
}
