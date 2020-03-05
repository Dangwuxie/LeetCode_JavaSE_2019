package dxc3.no63_股票的最大利润;

/**
 * @author dxc
 * @Title: TheMaxValue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/25 10:52
 */
public class TheMaxValue {

    public static int getMaxValue(int[] arr){

        if (arr == null || arr.length < 1){
            return 0;
        }

        int maxProfit = 0;
        int minValue = arr[0];

        for (int i = 1;i < arr.length; i++){
            minValue = arr[i] < minValue ? arr[i] : minValue;
            int tmp = arr[i] - minValue;
            maxProfit = maxProfit < tmp ? tmp : maxProfit;
        }

        return maxProfit;
    }

}
