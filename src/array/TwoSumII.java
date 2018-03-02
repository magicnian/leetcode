package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p>
 * 和two sum不同的地方是给定的数组是排过序的，并且返回的索引数组也要排序
 * Created by liunn on 2018/3/2.
 */
public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4};
        int target = 6;
        function1(numbers, target);
    }

    /**
     * 参考的two sum的做法，用hash table
     * 但是因为给定的数组是排过序的，有更好的方案
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] function1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] r = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int c = target - numbers[i];
            if (!map.containsKey(c)) {
                map.put(numbers[i], i);
            } else {
                if (map.get(c) > i) {
                    r[0] = i + 1;
                    r[1] = map.get(c) + 1;
                } else {
                    r[0] = map.get(c) + 1;
                    r[1] = i + 1;
                }
                break;
            }
        }
        return r;
    }

    /**
     * 从数组两头同时开始遍历
     * 如果和比target小，说明需要向右移
     * 如果和比target大，说明需要向左移
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] function2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
