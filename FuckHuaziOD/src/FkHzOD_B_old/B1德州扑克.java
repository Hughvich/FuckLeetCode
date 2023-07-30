package FkHzOD_B_old;

import java.util.*;

/**
 * B|1|德州扑克|数据结构|200|
 * 六种牌型：1-同花顺Straight Flush，2-四条Four of a Kind，3-葫芦Full House，4-同花Flush，5-顺子Straight，6-三条Three of a Kind
 * 说明：5张牌不会出现牌大小花色完全相同的牌
 *      编号小的牌型较大，如同花顺比四条大
 *      包含A的顺子：10 J Q K A 和 A 2 3 4 5
 * 输入：5行，每行为一张牌大小和花色，2-10，JQKA，花色：红桃-H，黑桃-S，梅花-C，方块-D
 * 输出：牌型序号，符合多种牌型取最大的牌型序号输出
 *
 * 示例1：
 * 输入：
 * 4 H
 * 5 S
 * 6 C
 * 7 D
 * 8 D
 * 输出：
 * 5
 *
 * 示例2：
 * 输入：
 * 9 S
 * 5 S
 * 6 S
 * 7 S
 * 8 S
 * 输出：
 * 1
 * 既是1又是5，输出1
 *
 * 用到的数据结构及方法：
 * List<List<String>>：add
 * ***重点***Map<>：entrySet, put，get,getOrDefault，getValue, ...
 *
 *
 */
public class B1德州扑克 {

    public static void main(String[] args) {
        // 把输入的5组数加入到二维数组inputCards中
        Scanner in = new Scanner(System.in);
        List<List<String>> inputCards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String line = in.nextLine();
            // nums构建一张牌的数组【数字，花色】
            List<String> nums = new ArrayList<>();
            String num = "";
            // 对一张牌的一行输入遍历
            for (int j = 0; j < line.length(); j++) {
                // 碰到中间空格就添加第一个数字
                if(line.charAt(j) == ' ') {
                    nums.add(num);
                    num = "";
                } else {
                    num += line.charAt(j);

                }
//                System.out.println("num= "+num);

            }
            // 添加第二个字母，即花色
            nums.add(num);
//            System.out.println("nums: "+nums);
            inputCards.add(nums);
//            System.out.println("inputCards: "+inputCards);
        }
//        System.out.println(inputCards);

        // inputCards里的数字此时还是字符串类型，将其转换为数字
        Map<String, Integer> cards = new HashMap<>();
        for (int i = 2; i <= 10; i++) {
            cards.put(""+i, i);
        }
//        cards.put("2", 2);
//        cards.put("3", 3);
//        cards.put("4", 4);
//        cards.put("5", 5);
//        cards.put("6", 6);
//        cards.put("7", 7);
//        cards.put("8", 8);
//        cards.put("9", 9);
//        cards.put("10", 10);
        cards.put("J", 11);
        cards.put("Q", 12);
        cards.put("K", 13);
        cards.put("A", 14);

        // 数字花色分为两组
        List<String> nums = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        System.out.println("cards: " + cards);
        inputCards.forEach(card -> {nums.add(card.get(0));
            colors.add(card.get(1)); });

        System.out.println("colors" + colors);


        // 按照cards对nums排序？？？
//        Collections.sort(nums, Comparator.comparingInt(cards::get));
        nums.sort((a, b) -> cards.get(a) - cards.get(b));
        System.out.println("nums: " + nums);

        // 核心逻辑：检查6种牌型
        if (isStrFlush(cards,nums,colors)) System.out.println(1);
        else if (isFour(nums)) System.out.println(2);
        else if (isFullHouse(nums)) System.out.println(3);
        else if (isFlush(colors)) System.out.println(4);
        else if (isStraight(cards, nums)) System.out.println(5);
        else if (isThree(nums)) System.out.println(6);
        else System.out.println(0);

    }
    // 牌型1：检查是否是同花顺，即 同花&&顺子
    public static boolean isStrFlush(Map<String, Integer> cards, List<String> nums, List<String> colors) {
        return isStraight(cards,nums) && isFlush(colors);
    }

    // 牌型2：检查是否是四条， 四张同数字+单张
    public static boolean isFour(List<String> nums) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String num : nums) {
            // getOrDefault：查count，没有是0+1，有则原基础上+1
            count.put(num, count.getOrDefault(num,0) + 1);
        }
        // 牌只有两种数字
        if (count.size() == 2) {
            // 为什么以下两种方法不能return true？？？
//            count.entrySet().forEach(entry -> {
//                if (entry.getValue() == 4 || entry.getValue() == 1) return true;
//            });
//            count.forEach((String key, Integer value) -> {
//                if (value == 4 || value == 1) {
//                    return true;
//                }
//            });
            for (Map.Entry<String, Integer> entry : count.entrySet()) { // **********记住这种MAP遍历法************
                if (entry.getValue() == 4 || entry.getValue() == 1) return true;
            }
        }
        return false;
    }
    // 牌型3：检查是否是葫芦，三张相同数字+对子
    public static boolean isFullHouse(List<String> nums) {
        Map<String, Integer> count = new HashMap<>();
        nums.forEach(num -> {
            count.put(num, count.getOrDefault(num, 0) + 1);
        });
        if (count.size() == 2) {
            for (Map.Entry<String, Integer> entry:count.entrySet()) {
                if (entry.getValue() == 3 || entry.getValue() == 2) return true;
            }
        }
        return false;
    }

    // 牌型4：检查是否是同花，用HashSet去除color重复，大小为一则只有一种
    public static boolean isFlush(List<String> colors) {
        return new HashSet<>(colors).size() == 1;
    }
    // 牌型5：检查是否是顺子
    public static boolean isStraight(Map<String, Integer> cards, List<String> nums) {
        // 对于A，2，3，4，5，的情况
        if (nums.get(0).equals("2") &&
                nums.get(1).equals("3") &&
                nums.get(2).equals("4") &&
                nums.get(3).equals("5") &&
                nums.get(4).equals("A")) {
            System.out.println("ureka!");
            return true;
        }

        // 其他顺子的逻辑：前一个牌数字+1应该等于后一个牌
        for (int i = 1; i < nums.size(); i++) {
            int num1 = cards.get(nums.get(i - 1));
            int num2 = cards.get(nums.get(i));
            // 如果不是以上逻辑false，否则跳过为true
            if (num1 + 1 != num2) return false;
        }
        return true;
    }

    // 牌型6：检查是否是三条，三张同数字
    public static boolean isThree(List<String> nums) {
        Map<String, Integer> count = new HashMap<>();
        nums.forEach(num -> {
            count.put(num, count.getOrDefault(num, 0) + 1);
        });
        if (count.size() == 3) {
            for (Map.Entry<String, Integer> entry:count.entrySet()) {
                if (entry.getValue() == 3) return true;
            }
        }
        return false;
    }
}
