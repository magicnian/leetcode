package array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * Created by liunn on 2018/3/1.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println( function1(nums));
    }


    /**
     * O(n)复杂度解法
     * 定义两个变量res和curSum
     * 其中res保存最终要返回的结果，即最大的子数组之和，curSum初始值为0
     * 每遍历一个数字num，比较curSum + num和num中的较大值存入curSum
     * 然后再把res和curSum中的较大值存入res，以此类推直到遍历完整个数组，可得到最大子数组的值存在res中
     *
     * @param nums
     * @return
     */
    public static int function1(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(res, curSum);
        }
        return res;
    }
}
