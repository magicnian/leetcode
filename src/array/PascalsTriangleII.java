package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liunn on 2018/2/28.
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> res = function1(rowIndex);
        for (Integer i:res) {
            System.out.println(i);
        }

    }

    public static List<Integer> function1(int rowIndex){
        List<Integer> res = new LinkedList<>();
        if(rowIndex==0) {
            res.add(1);
            return res;
        }
        else if(rowIndex==1){
            res.add(1);
            res.add(1);
            return res;
        }else{
            res.add(1);
            for(int i=1;i<=rowIndex-1;i++){
                List<Integer> t = function1(rowIndex-1);
                res.add(t.get(i-1)+t.get(i));
            }
            res.add(1);
        }
        return res;
    }


    public static List<Integer> function2(int rowIndex){
        List<Integer> res = new LinkedList<>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=i-1;j>=1;j--){
                int tmp = res.get(j-1)+res.get(j);
                res.set(j,tmp);
            }
            res.add(1);
        }
        return res;
    }

    /**
     * 没有从递归的思想去想这个问题
     * 解法非常巧妙
     * 有很大的数学推理在其中
     * @param rowIndex
     * @return
     */
    public static List<Integer> function3(int rowIndex){
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        long prev = 1;
        long rowIndexPlusOne = rowIndex + 1;
        for(int i = 1; i <= rowIndex; i++){
            prev = (prev * (rowIndexPlusOne - i)) / i;
            result.add((int)prev);
        }
        return result;
    }
}
