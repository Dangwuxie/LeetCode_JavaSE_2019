package dxc.no9_不重复打印排序数组中相加和为给定值的所有二元组和三元组;

/**
 * @author dxc
 * @Title: PrintUniqueArr
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/1 16:57
 */
/*
* 题目要求：给定一个数组arr和一个整数k，
* 分别输出数组中相加和为k的二元组和三元组
* */
public class PrintUniqueArr {

    /*
    * 思路1：求三元组，由于是已经排序完成，所以可以通过两个指针left\right从两头遍历
    * 判断是否和与k相等，另外还需要防止输出相同的二元组，此时就需要判断一下arr[left]\
    * 和arr[left-1]是不是相等，若是相等，就不输出当前的二元组
    * */
    public static void printUniqueArr1(int[] arr,int k){
         if (arr == null || arr.length < 2){
             return;
         }

         int left = 0;
         int right = arr.length-1;

         while(left < right){
             if (arr[left]+arr[right] > k){
                 right--;
             }else if (arr[left]+arr[right] < k){
                 left++;
             }else {
                 //此时就是相加和等于k值，此时需要判断一下是不是重复了
                 //如果没有重复，那么就输出当前的二元组
                 if (left == 0 || arr[left] != arr[left-1]){
                     System.out.println(arr[left]+"-"+arr[right]);
                 }
                 right--;
                 left++;
             }
         }

    }
    /*
    * 思路2：输出三元组，跟前面的道理差不多，就是从第一个元素开始，
    * 每次三元组的第一个元素都要保证跟之前的元素是不相同的；
    * 然后剩下的两个数字就再后面的子数组中寻找
    *
    * */
    public static void printUniqueArr2(int[] arr,int k){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0;i < arr.length; i++){
            if (i == 0 || arr[i] != arr[i-1]){
                printArr(arr,i,i+1,arr.length-1,k-arr[i]);
            }
        }

    }

    //注意此处的最后一个参数kVal的值
    private static void printArr(int[] arr,int i,int left,int right,int kVal){
        while(left < right){
            if (arr[left]+arr[right] > kVal){
                right--;
            }else if (arr[left]+arr[right] < kVal){
                left++;
            }else {
                //此时就是相加和等于k值，此时需要判断一下是不是重复了
                //如果没有重复，那么就输出当前的二元组
                if (left == i+1 || arr[left] != arr[left-1]){
                    System.out.println(arr[i]+"-"+arr[left]+"-"+arr[right]);
                }
                right--;
                left++;
            }
        }
    }

}
