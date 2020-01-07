package dxc.no14_自然数数组的排序;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/7 21:53
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,2,5};

        ArrSort.sort2(arr);

        for (int cur : arr){
            System.out.println(cur);
        }
    }
}
