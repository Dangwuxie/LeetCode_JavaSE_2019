package dxc.no4_无序数组最小的k个数.NlogN的方法;

/**
 * @author 灵魂编程者
 * @Title: FindMinKNums
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/21 22:53
 */

/*
* O(NlogN)的实现思路：
* 利用数组堆实现，始终维持一个大小为k的堆，大顶堆，
* 先将数组的前k个数字放进去，这期间每放进去一个数字就进行一次堆调整
* 始终维持堆的k个元素最大的元素在堆顶
* 从第k+1个数开始，如果有比堆顶元素小的数字，就交换，然后调整堆
* 遍历完数组之后，这个堆中的所有元素就是当前数组中最小的k个数字
*
* */
public class FindMinKNums {

    public static int[] findMinKnums(int[] arr,int k){
        if (arr.length<1||k>arr.length){
            return arr;
        }
        int[] kHeap = new int[k];//用数组实现的堆
        //先将arr中的前k个数字放进去并且调整堆
        for (int i=0;i<k;i++){
            insertHeap(kHeap,arr[i],i);
        }

        //从第k个数开始，不断地调整当前堆
        for (int j=k;j<arr.length;j++){
            if (arr[j]<kHeap[0]){
                kHeap[0] = arr[j];
                heapify(kHeap,0,k);
            }
        }

        return kHeap;
    }

    private static void insertHeap(int[] kHeap,int value,int index){
        kHeap[index] = value;
        //构建堆的过程中每次都要调整堆
        //将当前大元素往上浮
        while (index != 0){
            //数组实现的堆中通过子下标求父节点下标就是，(index-1)/2
            int parent = (index-1)/2;
            if (kHeap[parent]<kHeap[index]){
                //如果父节点比子节点小，子节点上浮
                swap(kHeap,parent,index);
                index = parent;//index变成当前浮上去的坐标，准备跟下一次比较；
            }else {
                break;
            }
        }
    }

    private static void heapify(int[] kHeap,int index,int heapSize){
        //此方法就是每次将堆顶元素改变之后调整堆
        int left = 2*index+1;
        int right = 2*index+2;
        int largest = index;

        while (left<heapSize){
            if (kHeap[left]>kHeap[index]){
                largest = left;//先将下标下浮，后面再交换值
            }

            if (right<heapSize && kHeap[right]>kHeap[largest]){
                //注意此处的判断是right跟largest判断的，上一个if语句可能会更改
                largest = right;
            }

            if (largest != index){
                //一旦largest发生下浮，就会进入此循环，将下标对应的元素下浮
                swap(kHeap,largest,index);
            }else {
                //如果此时largest并没有发生改变，
                //说明本次while循环中并没有发生改变
                //说明此时元素已经下浮到指定位置了
                //直接break就行
                break;
            }
            index = largest;//index走到largest的位置，此时两个数相同；
            left = index*2+1;//次数乘index和largest都可以
            right = index*2+2;

        }

    }

    private static void swap(int[] kHeap,int parent,int index){
        int temp = kHeap[parent];
        kHeap[parent] = kHeap[index];
        kHeap[index] = temp;
    }
}
