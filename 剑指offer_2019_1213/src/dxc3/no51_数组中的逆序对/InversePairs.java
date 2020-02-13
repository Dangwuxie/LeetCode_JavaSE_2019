package dxc3.no51_数组中的逆序对;

/**
 * @author dxc
 * @Title: InversePairs
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/12 14:54
 */
public class InversePairs {
    /*
    * 思路：归并排序的思路，合并的过程中左边的数组与右边的数组比较
    * 两个指针p1/p2,分别指向两个子数组的最右端，每次比较
    * 如果左边的比右边的大，那么此时右边数组包括指针指向在内的左边的数字，
    * 有几个，那么逆序对数加几；
    * 临时数组用来保存当前两个子数组排序合并后，然后需要复制给原数组；
    * 改变原数组的结构；
    * */
    public static int inversePairs(int[] arr){

        if (arr == null || arr.length == 0){
            return 0;
        }
        //辅助数组
        int[] copy = new int[arr.length];
        /*for (int i = 0;i < arr.length; i++){
            copy[i] = arr[i];
        }*/
        int res = inversePairsCore(arr,copy,0,arr.length-1);

        return res;
    }

    private static int inversePairsCore(int[] arr,int[] copy,int start,int end){

        if (start == end){
            //说明此时已经是一个数一个组了；
            copy[start] = arr[start];
            return 0;
        }
        //如果不是一个数，就继续分割
        int half = (end - start) / 2;
        //左边部分递归统计
        int leftCount = inversePairsCore(arr,copy,start,start+half);
        //右边部分递归统计
        int rightCount = inversePairsCore(arr,copy,start+half+1,end);

        int i = start + half;
        int j = end;
        int count = 0;
        int copyIndex = end;
        while (i >= start && j >= start + half + 1){
            //合并两个子数组
            if (arr[i] > arr[j]){
                //统计个数
                copy[copyIndex--] = arr[i--];
                count += j - start - half;
            }else {
                copy[copyIndex--] = arr[j--];
            }
        }
        //下面把没有拷贝完的子数组添加进去，copyIndex--就可以了；
        for (;i >= start; i--){
            copy[copyIndex--] = arr[i];
        }
        for (;j >= start+half+1; j--){
            copy[copyIndex--] = arr[j];
        }

        for (int cur = start;cur <= end; cur++){
            arr[cur] = copy[cur];
        }

        return leftCount+rightCount+count;
    }
}
