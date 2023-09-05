package TheLC75;

import java.util.List;
import java.util.Stack;

/** 【没做完】
 * LC#901.Med 股票价格跨度 【单调栈】
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 *
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 *
 * 实现 StockSpanner 类：
 *
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 *
 *
 * 示例：
 *
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 *
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 *
 * 思路：
 * 单调栈，保存索引，
 * 后一个比前一个小，弹栈
 * 向前找第一个比今天价格price大的价格的日子i，i+1到今天就是答案
 */
public class StockSpanner901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        stockSpanner.next(75);
        stockSpanner.next(85);
    }
}

class StockSpanner {
    Stack<Integer> stack;
    static List<Integer> stocks;
    private static int idx = 0;

    public StockSpanner() {
        idx = -1;
    }

    public int next(int price) {
//        if (stack.isEmpty()) stack.push(0);
        idx++;

        while (!stack.isEmpty() && price >= stocks.get(stack.peek())) {
            stack.pop();
        }
        int res = stocks.isEmpty() ? idx + 1 : idx - stack.peek();
        stocks.add(price);
        stack.push(idx);
        return res;
    }
}
