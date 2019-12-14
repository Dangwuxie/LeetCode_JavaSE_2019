package dxc.no3_数组中重复的数字;

/**
 * @author dxc
 * @Title: MultNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/13 23:09
 */
/*
* 题目要求：找出数组中重复的数字，重复的数字可能存在多个
* 返回任意一个；
* */
public class MultNumber {
    /*
    * 思路1：题目要求是找出随机一个重复数字，
    * 所以求解的思路可以这样，找到第一个出现两次以上的数字就返回该数字
    *
    * 解法：从数组的第一个数字开始遍历，如果arr[i]==i，就接着扫描下一个数字
    * 如果arr[i]!=i，
    * 那么对比arr[i]和arr[arr[i]]，如果相等，那么就相等，就返回arr[i]
    * 否则就交换arr[i]和arr[arr[i]]
    * 此时继续上面的重复步骤，
    *
    * 时间复杂度为O(n),因为直接是在输入数组上进行的，因此额外空间复杂度为O(1);
    * */
    public static int mulNumber(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        for (int i = 0;i < arr.length; i++){
            //直接while循环，直接找到arr[i]=i，然后停止while循环
            //继续下一个数字；

            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    //如果出现相等，就直接返回当前的这个数字
                    return arr[i];
                }
                //否则就交换
                int temp = arr[i];
                //注意这里的交换，需要用temp作为下标，
                //否则在最后一步中arr[arr[i]]会改变，
                //造成死循环
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return 0;
    }
    /*
    * 思路2：不修改数组找出重复的数字
    * 此种方法需要额外O(n)的辅助空间
    * 大致思路就是创建一个n+1的辅助数组，逐一遍历原数组的每个数字复制到辅助数组
    * 如果原数组中复制的是数字m，则把他复制到辅助数组中下标为m的位置；
    * */
    public static int mulNumber2(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        //初始化的int数组里面的n个元素默认值为0
        int[] tmpArr = new int[arr.length];

        for (int i = 0;i < arr.length; i++){
            if (tmpArr[arr[i]] != 0){
                //说明此时tmpArr中下标为arr[i]处的元素不为0.
                // 说明已经出现过arr[i]这个元素
                return arr[i];
            }
            tmpArr[arr[i]]++;
        }
        return 0;
    }
    /*
    * 思路3：这种思路的时间复杂度为O(logn),空间复杂度为O(1)
    * 具体思路：在n+1长度的数组里的所有数字在1-n的范围内
    * 所以至少有一个数字是重复的
    * 假设8个数字{2,3,5,4,2,4,6,7};
    * 1-8的中间数是4，所以可以分成1-4，5-8，两部分，
    * 每次都是类似二分查找的方法，缩短查找范围
    * 最后找出1-7这7个数字中重复的数字
    * */
    public static int mulNumber3(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        int start = 1;
        int end = arr.length-1;

        while (start <= end){
            int mid = ((end-start) >> 1) + start;
            //统计当前start到mid的数字中出现在数组中的次数
            //如果大于mid-start+1，那么就在start-mid这些数字里面有重复数字
            //此时需要二分，继续缩小范围；
            int count = countRange(arr,start,mid);
            //判断一下
            if (start == end){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }

            if (count > (mid - start) + 1){
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return -1;
    }
    private static int countRange(int[] arr,int start,int end){
        int count = 0;

        for (int i = 0;i < arr.length; i++){
            if (arr[i] >= start && arr[i] <= end){
                count++;
            }
        }
        return count;
    }
}






