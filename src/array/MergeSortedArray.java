package array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * <p>
 * <p>
 * Created by liunn on 2018/2/27.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[20];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 4;
        nums1[3] = 7;
        nums1[4] = 9;

        int[] nums2 = new int[]{3, 5, 6, 7, 8};

        function1(nums1, 5, nums2, 5);
    }

    /**
     * 代码量确实少，但是不推荐，
     * nums1初始化时有大量的0，
     * 最后sort的时候大量的0会
     * 占用前面的位置
     * 并且运行效率低
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void function1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 大致思路
     * 从两个数组的尾部开始做比较
     * 较大的放到nums1的尾部
     * 递减直至first或者second小于0
     * 可能出现的情况是nums1的前几个元素较大
     * 这是first会先小于0，但是前几位较小的元素在nums2,
     * 需要将nums2中的前几位元素放到nums1中（前几位有last值确定）
     * 执行效率是function1的十几倍……
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void function2(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[last] = nums1[first];
                first--;
            } else {
                nums1[last] = nums2[second];
                second--;
            }
            last--;
        }

        if (first < 0) {
            for (int i = 0; i <= last; i++) {
                nums1[i] = nums2[1];
            }
        }
    }
}
