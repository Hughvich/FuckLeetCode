package Arrays.BinarySearch;
/*
二分求方根：分别用暴力解法和牛顿迭代法求平方根
区间划分：left ~ mid - 1, mid ~ right，middle需要向上取整（r + l + 1）/2，否则区间在下一轮不能缩小，无限循环
 */
public class mySqrt69 {

    private static double s;

    //二分法
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;

        if (x == 0 || x == 1) return x;

        while (left < right) {
            int ans =  left + (right - left + 1) / 2; //middle怎么确定，要硬记
            if (ans == x / ans) return ans;
                else if (ans > x / ans) {
                right = ans - 1;
            } else {
                left = ans;
            }
        }
        return left;
    }

    //牛顿迭代法
    public static int newtonSqrt(int x) {
        if (x == 0 || x == 1) return x;
        //根号s为x的正实根，切线近似值(x + s/x)/2
        s = x;

        return (int)sqrt(x);
    }

    public static double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) return x;
        else return sqrt(res);
    }

    public static void main(String[] args) {
        int x = 2;
        System.out.println(mySqrt(x));
        System.out.println(newtonSqrt(x));
    }

}
