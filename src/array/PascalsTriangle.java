package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * Created by liunn on 2018/2/28.
 */
public class PascalsTriangle {

    public static void main(String[] args) {

    }


    /**
     * 迭代的方法，不符合要求
     * 但是能返回对应numRows的数组
     *
     * @param numRows
     * @return
     */
    public static int[] function1(int numRows) {
        if (numRows == 1) return new int[]{1};
        else if (numRows == 2) return new int[]{1, 1};
        else {
            int[] nums = new int[numRows];
            nums[0] = 1;
            nums[numRows - 1] = 1;
            for (int i = 1; i < numRows - 1; i++) {
                nums[i] = function1(numRows - 1)[i - 1] + function1(numRows - 1)[i];
            }
            return nums;
        }
    }

    /**
     * 本质思想和function1一样
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> function2(int numRows) {
        List<List<Integer>> res = new LinkedList<>();

        //如果numRows为0，返回空list
        if (numRows == 0) {
            return res;
        }

        //第一个list固定为[1]
        res.add(new LinkedList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new LinkedList<>();
            List<Integer> preRow = res.get(i - 1);

            //list第一个元素固定为1
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            //list最后一个元素固定为1
            row.add(1);

            res.add(row);
        }

        return res;
    }


    /**
     * 没有用到递归，从0开始
     * 每次计算都会用pre存下当前值
     * 下次计算时再用pre
     * 这样的好处是空间复杂度降低很多
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> function3(int numRows) {
        int[][] lists = new int[numRows][];
        int[] pre = null;

        for (int i = 0; i < numRows; i++) {
            int[] list = new int[i + 1];
            list[0] = 1;
            if (pre == null) {
                lists[i] = list;
                pre = list;
                continue;
            }
            for (int i1 = 1; i1 <= i; i1++) {
                int size = pre.length;

                if (i1 + 1 <= size) {
                    list[i1] = pre[i1] + pre[i1 - 1];
                } else {
                    list[i1] = 1;
                }

            }
            lists[i] = list;
            pre = list;

        }

        return (List) Arrays.asList(lists);
    }
}
