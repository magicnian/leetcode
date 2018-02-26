package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * Created by liunn on 2018/2/26.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    /**
     * 大致思路
     * 先将数组排序
     * 然后按顺序取一个元素
     * 其余的元素取两个
     * 保证这两个元素和要等于sum-第一个元素
     * 取这两个元素时，先取头部和尾部元素
     * 求和，如果等于sum,放进返回List中
     * 如果小于sum，说明头部元素太小，往后取一个
     * 如果大于sum，说明尾部元素太大，往前取一个
     * 同时按顺序判断前后两个元素是否相等可以避免重复值
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //保证第一个元素不重复，经过排序后
            //只要第一个元素不重复，整个list也不会重复
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                //low,high,分别取数组最小和最大值
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
