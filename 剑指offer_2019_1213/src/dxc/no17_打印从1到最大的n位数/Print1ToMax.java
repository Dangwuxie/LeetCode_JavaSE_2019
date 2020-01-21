package dxc.no17_打印从1到最大的n位数;

/**
 * @author dxc
 * @Title: Print1ToMax
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/20 12:51
 */
/*
* 输入n，打印从1到最大的n位十进制数。
* */
public class Print1ToMax {

    public static void print1ToMax(int n){
        if(n <= 0){
            System.out.println("输入错误！");
            return;
        }
        //用数组解决数组长度要加1的原因是最后最高位进位时需要判断。
        //比如3位，999，就需要1000来判断临界点，四位。
        int[] arr = new int[n+1];

        while(!increment(arr)){
            printArr(arr);
        }
    }


    private static boolean increment(int[] arr){
        boolean isOverFlow = false;
        int high = 0;//进位
        for (int i = arr.length-1;i >= 0; i--){

            int iSum = arr[i] + high;//除了最后一位，高位每次加进位high
            if (i == arr.length-1){
                //如果是最后一位，直接自增1；
                iSum++;
            }
            arr[i] = iSum % 10;
            if (iSum > 9){
                //此时需要进位
                if (i == 1){
                    //此时如果是进位到第一位，代表已经到达最大数
                    isOverFlow = true;//表示已经输出完毕；自增完毕；
                }else {
                    high = 1;
                }
            }else {
                //如果此时当前位没有产生进位，就直接break就行了；
                break;
            }
        }

        return isOverFlow;
    }

    public static void printArr(int[] arr){

        boolean isBeginning0 = false;

        for (int i = 0; i < arr.length; i++){

            if (!isBeginning0 && arr[i] != 0){
                isBeginning0 = true;
            }
            if (isBeginning0){
                System.out.print(arr[i]);
            }
        }
        //换行
        System.out.println();
    }
}
