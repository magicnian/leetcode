package array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 * Created by 94496 on 2018/2/24.
 */
public class SerachInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
//        System.out.println(function1(nums, target));
        System.out.println(function2(nums,target));
    }

    /**
     * 最简单的一种解法，暴力循环
     * 特殊情况会很慢
     * 如 nums=[1,2,3,4,5,6] target=6
     * 需要完整遍历整个数组
     * @param nums
     * @param target
     * @return
     */
    public static int function1(int[] nums, int target) {
        int size = nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                index = i;
                break;
            }
        }
        if(target>nums[size-1]){
            index=size;
        }
        return index;
    }

    /**
     * 两头遍历，预想是会比function1快
     * 事实是要慢，
     * 可能是判断过多，
     * 而且本身看上去不够简洁
     * @param nums
     * @param target
     * @return
     */
    public static int function2(int[] nums,int target){
        int index=0;
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(target<=nums[i]){
                index=i;
                break;
            }else if(target>nums[j]){
                index=j+1;
                break;
            }else if(target==nums[j]){
                index=j;
                break;
            } else if(nums[i]<target&&target<nums[j]){
                i++;
                j--;
            }
        }
        if(i>j){
            index=i;
        }
        return index;
    }


    /**
     * 类似二分法，
     * 比起function2优秀更多
     * 尤其是在数组非常大的情况下
     * 效率非常高
     * @param nums
     * @param target
     * @return
     */
    public static int function3(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = start + (end-start) / 2;
            if(nums[mid]<target) {
                start = mid + 1;
            } else if(nums[mid]>target) {
                end = mid - 1;
            } else
                return mid;
        }

        return start;
    }
}
