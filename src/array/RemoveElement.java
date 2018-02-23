package array;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * <p>
 * 和removeDuplicates的解决方式相似
 * Created by liunn on 2018/2/23.
 */
public class RemoveElement {

    public static void main(String[] args) {

    }

    /**
     * keep two pointers ii and jj,
     * where ii is the slow-runner while jj is the fast-runner
     * <p>
     * When nums[j]nums[j] equals to the given value, skip this element by incrementing jj.
     * As long as nums[j] \neq valnums[j]≠val,
     * we copy nums[j]nums[j] to nums[i]nums[i] and increment both indexes at the same time.
     * Repeat the process until jj reaches the end of the array and the new length is ii
     *
     * @param nums
     * @param val
     * @return
     */
    public static int function1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 这种算法是弥补了第一种方法的不足
     * 试想：nums=[1,2,3,4,5] val=5
     * functio1会把整个数组遍历一遍
     * 这种情况下耗时会增加
     * <p>
     * 当遇到nums[i]=val时，交换当前值和nums[n]
     * 每次交换都会把和val相等的值往数组最后抛，
     * 并且每次都会变相的使数组的长度减1，
     * 这样效率会高很多
     *
     * @param nums
     * @param val
     * @return
     */
    public static int function2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


    /**
     * 举例
     * nums=[1,2,2,3,1] val=2
     * 想不明白……
     * @param nums
     * @param val
     * @return
     */
    public static int function3(int[] nums, int val) {
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++end] = nums[i];
            }
        }
        return ++end;
    }
}
