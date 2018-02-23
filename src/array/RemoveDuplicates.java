package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * 去重问题优先考虑map容器的key不可以重复特性
 * Created by liunn on 2018/2/23.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3};
        System.out.println(function1(nums));
        System.out.println(function2(nums));
    }

    /**
     * 使用map容器key值不能重复的特性
     *
     * @param nums
     * @return
     */
    public static int function1(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], null);
        }
        return map.keySet().size();
    }

    /**
     * 非jdk容器实现
     * 因为给的数组是已经排过序的
     * 所以可以遍历整个数组，前后两个
     * 对比，不相同的全部往数组最前面排
     * 相同的往后排
     * len可以理解为指针
     * 如[1,2,2,3,3]
     * len初始指向nums[1]，循环从nums[1]开始
     * 第一次循环发现nums[0]和nums[1]不相同，
     * nums[len]=nums[1],将nums[1]赋值给nums[1]
     * len向后移动一位，指向nums[2]
     * 第二次循环发现nums[1]和nums[2]相同，
     * len不移动，仍然指向nums[2]
     * 第三次循环发现nums[2]和nums[3]不相同，
     * nums[len]=nums[2],将nums[3]赋值给nums[2]
     * len向后移动一位，指向nums[3]
     * 第四次循环发现nums[3]和nums[4]相同，
     * len不移动，仍然指向nums[3]
     * 最后数组就变成了[1,2,3,2,3]
     * 整套算法就是将不同的元素往数组前面排，
     * 保证数组前面的元素一定是不同的，后面的不管
     *
     * @param nums
     * @return
     */
    public static int function2(int[] nums) {
        int len = 1;
        for (int i = 1, size = nums.length; i < size; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    /**
     * 原理同function2,但是function2运行更快
     * @param nums
     * @return
     */
    public static int funciton3(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
