package FkHzOD_B_latest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B|48|拔河比赛|数据结构|100|
 * 身高优先，体重次之，参赛队伍派出10名选手，
 * 输入一个数组记录身高体重，全员数量大于10，
 * 输出大小为10的二维数组，排序后的身高体重
 *
 * 示例1输入：
181 70
182 70
183 70
184 70
185 70
186 70
180 71
180 72
180 73
180 74
180 75
 输出：
 186 70
 185 70
 184 70
 183 70
 182 70
 181 70
 180 75
 180 74
 180 73
 180 72


 */
public class B48拔河比赛 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> info = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) break;
            else {
                info.add(Arrays.stream(line.split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

//        System.out.println(info);

        Set<Member> memberList = new TreeSet<>();
        for (List<Integer> integers : info) {
            memberList.add(new Member(integers.get(0), integers.get(1)));
        }

        memberList.forEach(System.out::println);

    }

    public static class Member implements Comparable<Member> {
        int height;
        int weight;

        public Member(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }


        @Override
        public int compareTo(Member o) {
            if (this.height != o.height)
                return o.height - this.height;
            else
                return o.weight - this.weight;
        }

        @Override
        public String toString() {
            return height + " " + weight;
        }
    }
}
