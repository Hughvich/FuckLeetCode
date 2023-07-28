package FkHzOD_B_old;

import java.util.*;

/**
 * B|7|统计射击比赛成绩|排序算法|100|
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和 进行降序 排名并输出选手ID
 * 条件：
 * 1. 一个选手的多个射击成绩分数，次序不固定
 * 2. 如果成绩少于3个，忽略该选手
 * 3. 两个选手成绩之和相等，按其ID降序排列
 * 输入：
 * 第一行，一个整数N，共进行了N次射击，产生N个成绩分数，2-100
 * 第二行，一个长度为N整数序列，参与每次射击选手ID，0-99
 * 第三行，一个长度为N整数序列，每次射击选手对应的成绩，0-100
 * 输出：
 * 符合题设条件的降序排名后的选手ID序列
 *
 * 示例1
 * 输入：
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 * 输出：
 * 5,3,7,4
 *
 * 思路：
 * 各种List的用法，
 * 各种Map的用法，
 * stream()里的map(), filter(), sorted(), collect(), toList(),
 *
 */
public class B7统计射击比赛成绩 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
//        List<Integer> id = Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toList();
//        List<Integer> score = Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toList();
        // 可以用以上stream()
        // 也可以用逗号和换行分隔符
        in.useDelimiter("[,\n]");
        List<Integer> id = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            id.add(in.nextInt());
        }
        for (int i = 0; i < N; i++) {
            score.add(in.nextInt());
        }

        // 生成map
        Map<Integer, List<Integer>> IDScore = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // getOrDefault如果相同id，获取前面生成的列表，否则生成新的
            List<Integer> list = IDScore.getOrDefault(id.get(i), new LinkedList<>());
            list.add(score.get(i));
            IDScore.put(id.get(i), list);
        }

        // 用StringBuilder修改最后结果
        StringBuilder builder = new StringBuilder();

        IDScore.entrySet().stream().filter(x -> x.getValue().size() >= 3)
                .sorted((o1, o2) -> {
                    Integer sum1 = sumScore(o1.getValue());
                    Integer sum2 = sumScore(o2.getValue());
                    if (sum1.equals(sum2))
                        return o2.getKey() - o1.getKey(); // 相同分数按照id大小降序
                    else
                        return sum2 - sum1; // 分数降序
                })
                .map(Map.Entry::getKey) // 拿到id
                .forEach(x -> builder.append(x).append(",")); //遍历id，中间加上逗号

        System.out.println(builder.substring(0, builder.length() - 1));

    }

    private static Integer sumScore(List<Integer> list) {
        list.sort(Integer::compareTo); //升序排序
        int sum = 0;
        for (int i = list.size() - 1; i > list.size() - 3; i--) {
            sum += list.get(i);
        }
        return sum;
    }
}
