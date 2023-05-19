package Arrays.RemoveElements;

/**
 * LC#278.Easy
 * 《双指针问题》
 *
 * n个版本[1, 2, 3, ..., n]找出导致之后所有版本出错的第一个错误版本
 * 调用bool isBadVersion(version)接口来判断版本号version是否在单元测试中出错
 *
 * [1, 2, 3, ..., n]: [f f f f f f...f f f f t t t ...... t t t]
 * 此类为逼近类二分搜索，找到第一个...【某分界线】的索引，
 * 循环判断有等号，两边都需+1或者-1，return只能left //退出循环的时候，要么是left == right+1，要么是left+1 == right
 * 循环判断没等号，只需一边+1或者-1，return left和right都可
 *
 */
public class FirstBadVersion278 extends VersionControl { //
    public int firstBadVersion(int n) {
        int l = 0;
        int h = n;
        while (l < h) {
            int m = l + (h - l) / 2; // (l + h) / 2 可能会导致溢出
            if (!isBadVersion(m)) {
                l = m + 1; //m为false至少+1才是答案
            } else {
                h = m; //m为true不能+1，因为有可能这个m就是第一个true即答案
            }
        }
        return l; //最后出循环时l = h，即为所要找的
    }

    public static void main(String[] args) {

    }

}

class VersionControl { //一个假的"Arrays.RemoveElements.VersionControl" 接口，以及 "isBadVersion(version)"， 仅用于演示和不报错.
    public boolean isBadVersion(int version) {
        return true;
    }
}