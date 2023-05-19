package Arrays.BinarySearch;

/**
 * LC#704.Easy
 * 《二分搜索问题》
 *
 * 最简单的【有序数组】的二分查找
 * 注意一定是【有序】的数组，即使用前需要对数组进行排序
 * 注意边界条件
 * 如果[l,h]左闭右闭区间，l = h 是有意义的，循环判断 有 等号，两边都需+1或者-1
 * 如果[l,h)左闭右开，l = h没有意义，循环判断 没 等号，只需一边+1或者-1
 *
 * 循环不变量原则：
 * 区间的定义就是不变量，每次循环时坚持根据区间的定义做边界处理，边界条件↑
 */
public class BinarySearch704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int a = 13;
        System.out.println(binarySearch(nums, a));
    }

    public static int binarySearch(int[] arr, int a) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] > a) {
                h = m - 1; //一定要注意在m的前后，下标加减1
            } else if (arr[m] < a){
                l = m + 1;
            } else return m;
        }
        return -1; //没有找到时l = h,会退出循环
    }
}
