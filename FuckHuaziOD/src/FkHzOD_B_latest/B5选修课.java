package FkHzOD_B_latest;

import java.util.*;

/**
 * B|5|选修课|数据结构|100|
 * 现有两门选修课，每门选修课都有一部分学生选修，每个学生都有选修课的成绩，
 * 需要你找出同时选修了两门选修课的学生，先按照 班级 进行划分，班级编号小的先输出，
 * 每个班级按照 两门选修课 成绩和 的 降序排序，成绩相同时按照学生的 学号id 升序排序。
 *
 * 输入描述
 * 第一行为第一门选修课学生的成绩
 * 第二行为第二门选修课学生的成绩，
 * 每行数据中学生之间以英文分号分隔，每个学生的学号和成绩以英文逗号分隔，
 * 学生学号的格式为8位数字(2位院系编号+入学年份后2位+院系内部1位专业编号+所在班级3位学号)，
 * 学生成绩的取值范围为[0,100]之间的整数，两门选修课选修学生数的取值范围为[1-2000]之间的整数。
 * 输出描述
 * 同时选修了两门选修课的学生的学号，如果没有同时选修两门选修课的学生输出NULL，
 * 否则，先按照班级划分，班级编号小的先输出，每个班级先输出班级编号(学号前五位)，
 * 然后另起一行输出这个班级同时选修两门选修课的学生学号，学号按照要求排序(按照两门选修课成绩和的降序，
 * 成绩和相同时按照学号升序)，学生之间以英文分号分隔。
 *
 * 示例1输入:
01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
 * 输出:
 * 01202
 * 01202008;01202021
 * 01203
 * 01203088
 * 说明:同时选修了两门选修课的学生01202021、01202008、01203088，这三个学生两门选修课的成绩和 分别为150、150、185,
 * 01202021、01202008属于01202班的学生，按照成绩和降序，成绩相同时按学号升序输出的结果为01202008:01202021,
 * 01203088属于01203班的学生，按照 成绩和 降序，成绩相同时按 学号升序 输出的结果为01203088，
 * 01202的班级编号小于01203的班级编号，需要先输出。
 *
 * 示例2输入:
01201022,75;01202033,95;01202018,80;01203006,90;01202066,100
01202008,70;01203102,85;01202111,80;01201021,75;01201100,88
 * 输出:
 * NULL
 * 说明:没有同时选修了两门选修课的学生，输出NULL。
 *
 * 思路：
 * 两个map，学生和成绩间的关系，
 *
 *
 */
public class B5选修课 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] grade1 = in.nextLine().split(";");
        String[] grade2 = in.nextLine().split(";");

        // 用来比对两组数据的map
        HashMap<String, Integer> studentIdMap = new HashMap<>();
        List<String[]> grade1List = new ArrayList<>();
        for (int i = 0; i < grade1.length; i++) {
            grade1List.add(grade1[i].split(","));
        }
        for (int i = 0; i < grade1List.size(); i++) {
            studentIdMap.put(grade1List.get(i)[0], Integer.parseInt(grade1List.get(i)[1]));
        }

        // 一个存答案的map
        HashMap<String, Set<Student>> studentMap = new HashMap<>();

        List<String[]> grade2List = new ArrayList<>();
        for (int i = 0; i < grade2.length; i++) {
            grade2List.add(grade2[i].split(","));
        }
        for (int i = 0; i < grade2List.size(); i++) {
            String id = grade2List.get(i)[0];
            // 列表2和列表1匹配，用表2的id去查表1的map
            if (studentIdMap.containsKey(id)) {
                // 计算匹配到的两个表的总分
                int totalScore = Integer.parseInt(grade2List.get(i)[1]) + studentIdMap.get(id);
                // 截取相同的id前缀
                String pre = id.substring(0,5);
                // 需要用Set把重复的过掉
                studentMap.computeIfAbsent(pre, k -> new TreeSet<>()).add(new Student(id, totalScore));
            }
        }

        if(studentMap.isEmpty())
            System.out.println("NULL");
        else {
            studentMap.forEach((key, value) -> {
                // 输出同班级编号
                System.out.println(key);
                StringBuilder res = new StringBuilder();
                value.forEach(student -> res.append(student.id).append(";"));
                System.out.println(res.substring(0, res.length() - 1)); //切掉末尾分号
            });
        }

    }

    // 需要比较分数，id，***********重点*************
    public static class Student implements Comparable<Student> {
        String id;
        int score;

        public Student(String id, int score) {
            this.id = id;
            this.score = score;
        }

        // ****************************高级写法：分数如果相同比较id****************************
        @Override
        public int compareTo(Student o) {
            // 分数降序，this在前，o在后，就是
            return score != o.score? Integer.compare(o.score, score) : id.compareTo(o.id);
        }
    }
}
