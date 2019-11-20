package dxc.no5_判断字符数组中是否所有元素都只出现过一次;

/**
 * @author 灵魂编程者
 * @Title: IsUniquel2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/20 19:55
 */
public class IsUniquel2 {
    /*
    * 思路2：要求额外空间复杂度为O(1)的情况
    * 利用非递归的堆排来实现
    * */
    public static boolean isUniquel2(char[] chas){

        if (chas == null){
            return true;
        }

        heapSort(chas);

        for (int i = 1;i < chas.length; i++){
            if (chas[i-1] == chas[i]){
                return false;
            }
        }

        return true;
    }

    //非递归方式实现堆排
    public static void heapSort(char[] chars){
        for (int i = 0;i < chars.length; i++){
            insertHeap(chars,i);
        }

        for (int i = chars.length-1;i > 0; i--){
            swap(chars,0,i);
            heapify(chars,0,i);
        }
    }

    public static void insertHeap(char[] chars,int i){
        int parent = 0;
        while (i != 0){
            parent = (i-1)/2;
            if (chars[parent] < chars[i]){
                swap(chars,parent,i);
            }else {
                break;
            }
        }
    }
    //堆的调整
    public static void heapify(char[] chars,int i,int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        while (left < size){

            if (chars[left] > chars[i]){
                largest = left;
            }

            if (right < size && chars[right] > chars[i]){
                largest = right;
            }

            if (largest != i){
                swap(chars,largest,i);
            }else {
                break;
            }

            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    public static void swap(char[] chars,int a,int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}



















