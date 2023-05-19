package Arrays.BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchRenewal {

    public static int anotherBS (int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }else if (nums.length == 0) return -1;

        int h = nums.length;
        int l = 0;
        while (l < h) {
            int t = (h + l) / 2;
            if (nums[t] == target) {
                return t;
            } else if (nums[t] < target) {
                l = t + 1;
            } else {
                h = t - 1;
            }
            System.out.println(l +", "+ h);
        }
        System.out.println(l +", "+ h);
        return -1;

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 100;
        int[] numsRand = new int[n];
        for (int i = 0; i < n; i++) {
            numsRand[i] = rand.nextInt(100);
        }
        Arrays.sort(numsRand);
        int[] nums = {-1, 0, 4,6, 6, 6 ,8,11,34,39};
        int[] nums0 = {};
        int target = 6;
        System.out.println(Arrays.toString(numsRand));
        System.out.println(anotherBS(nums,target));
    }
}
