package dxc.no17_打印从1到最大的n位数;

/**
 * @author dxc
 * @Title: Print1ToMax2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/20 18:58
 */
public class Print1ToMax2 {

    /*
    * 递归的方法输出全排列的n位数
    * */
    public static void print1ToMax2(int n){

        if (n <= 0){
            return;
        }

        int[] arr = new int[n];
        for (int i = 0;i < 10; i++){
            arr[0] = i;
            print1ToMax2core(arr,0);
        }

    }

    private static void print1ToMax2core(int[] arr,int index){

        if (index == arr.length - 1){
            //当index为3的时候，就可以输出了，
            //因为上一层递归已经将数组的最后一位赋值完毕
            Print1ToMax.printArr(arr);
            return;
        }

        for (int i = 0;i < 10; i++){
            arr[index+1] = i;
            print1ToMax2core(arr,index+1);
        }
    }

}
