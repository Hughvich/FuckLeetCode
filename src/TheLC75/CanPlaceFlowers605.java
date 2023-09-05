package TheLC75;

import java.util.Arrays;

/**
 * LC#605.Easy 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 * 不相邻座位问题，
 * 每三个0就可以种一个，不管前后
 * 在首尾补0，“防御型编程思想”
 *
 */
public class CanPlaceFlowers605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int[] newFB = new int[flowerbed.length + 2];
        newFB[0] = 0;
        newFB[newFB.length - 1] = 0;

        System.arraycopy(flowerbed, 0, newFB, 1, newFB.length - 1 - 1);

        System.out.println(Arrays.toString(newFB));
        for (int i = 1; i < newFB.length - 1; i++) {
            if (newFB[i - 1] == 0 && newFB[i] == 0 && newFB[i + 1] == 0) {
                newFB[i] = 1;
                n--;
            }
            if (n == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] fb = {0,0,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(fb,0));
    }
}
