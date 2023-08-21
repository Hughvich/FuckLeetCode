package FkHzOD_B_latest;

import java.util.*;

/**
 * B|41|人气最高的店铺|逻辑分析|100|
 * 某购物城有m个商铺，现决定举办一场活动选出人气最高店铺。活动共有n位市民参与，每位市民只能投一票，但1号店铺如果给该市民发放q元的购物补贴，该市民会改为投1号店铺。
 * 请计算1号店铺需要最少发放多少元购物补贴才能成为人气最高店铺(即获得的票数要大于其他店铺)，如果1号店铺本身就是票数最高店铺，返回0。
 * 输入描述:
 * 第一行为小写逗号分割的两个整数n，m，其中第一个整数n表示参与的市民总数，第二个整数m代表店铺总数，1<= n, m <= 3000.
 * 第2到n+1行，每行为小写逗号分割的两个整数p，q，表示市民的意向投票情况，其中每行的第一个整数p表示该市民意向投票给p号店铺，第二个整数q表示其改投1号店铺所需给予的q元购物补贴，1 <= p <= m,1<= q <= 10^9.不考虑输入的格式问题
 * 输出描述
 * 1号店铺需要最少发放购物补贴金额。
 * 示例1 输入:
 * 5,5
 * 2,10
 * 3,20
 * 4,30
 * 5,40
 * 5,90
 * 输出:
 * 50
 * 说明:
 * 有5个人参与，共5个店铺。
 * 如果选择发放 10元+20元+30元=60元 的补贴来抢2.3.4号店铺的票，总共发放了60元补贴
 * (5号店铺有2票，1号店铺要3票才能胜出)
 * 如果选择发放 10元+40元=50元 的补贴来抢2.5号店铺的票，总共发放了50元补贴
 * (抢了5号店铺的票后，现在1号店铺只要2票就能胜出)
 * 所以最少发放50元补贴
 * 示例2 输入:
5,5
2,10
3,20
4,30
5,80
5,90
 * 输出:
 * 60
 * 说明:
 * 有5个人参与，共5个店铺.
 * 如果选择发放 10元+20元+30元=60元 的补贴来抢2.3.4号店铺的票，总共发放了60元补贴(5号店铺有2票，1号店铺要3票才能胜出)
 * 如果选择发放 10元+80元=90元 的补贴来抢2,5号店铺的票，总共发放了90元补贴(抢了5号店铺的票后，现在1号店铺只要2票就能胜出)所以最少发放60元补贴
 *
 * 思路
 * 动态的排序规则，首先按照店铺id技术，统计每个店铺初始有多少票，
 * 只要1号店铺发和其他店铺一样的钱，这个人就会改投1号，1号店加，其他店铺减
 * 回溯遍历方式，1号店对后续投票情况排列组合，
 *
 * */
public class B41人气最高的店铺 {

    public static int money;
    public static int result = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ip = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = ip[0];
        int m = ip[1];
        // 每个人投票信息，List - Array二维数组
        List<int[]> voters = new ArrayList<>();
        //
        Map<Integer, Integer> shops = new HashMap<>();
        shops.put(1, 0);
        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            if (nums[0] != 1)
                voters.add(new int[] {nums[0], nums[1]});
            shops.put(nums[0], shops.getOrDefault(nums[0], 0) + 1);
        }
//        System.out.println(voters);
//        System.out.println(shops);
        backfill(voters, new ArrayList<>(), 0, shops);
        System.out.println(result);
    }

    private static void backfill(List<int[]> voters, List<int[]> changeVoters, int idx, Map<Integer, Integer> shops) {
        // 判断1号店铺是否是第一名，且需要的钱最少
        if (check(changeVoters, shops) && result > money)
            result = money;
        else {
            for (int i = idx; i < voters.size(); i++) {
                changeVoters.add(voters.get(i));
//                changeVoters.forEach(ints -> System.out.println(Arrays.toString(ints)));
//                System.out.println("____________________");
                backfill(voters, changeVoters, i+1, shops);
                changeVoters.remove(changeVoters.size() - 1);
            }
        }
    }

    /**
     *  判断1号店铺是否是第一名，且需要的钱最少
     * @param changeVoters
     * @param shops
     * @return
     */
    private static boolean check(List<int[]> changeVoters, Map<Integer, Integer> shops) {
        Map<Integer, Integer> newShops = new HashMap<>(shops);
        money = 0;
        for (int[] voter:changeVoters) {
            int shopId = voter[0];
            money += voter[1];
            // 1号店的人气+1，voter本来投的shopId店人气-1
            newShops.put(shopId, newShops.get(shopId) - 1);
            newShops.put(1, newShops.get(1) + 1);
        }
        // newShops的人气 降序排序，用List<Map.Entry<>>
        List<Map.Entry<Integer, Integer>> compareList = new ArrayList<>(newShops.entrySet());
        compareList.sort((a,b) -> b.getValue() - a.getValue());
        // 人气第一的店铺id：
        int topShopId = compareList.get(0).getKey();
        // 如果1号店排第一，且第一名的投票大于第二名的/只有1号店一家
        return topShopId == 1 && (compareList.size() == 1 ||
                compareList.get(0).getValue() > compareList.get(1).getValue());
    }
}
