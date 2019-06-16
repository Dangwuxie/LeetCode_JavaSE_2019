import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: CountSort
 * @ProjectName leetcode_排序
 * @Description: 计数排序
 * @date 2019/6/16 10:29
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sorted = countSort(array);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] countSort(int[] array) {
        //首先第一步，得到数列的最大值跟最小值，计算出差值d
        //这个d将作为新countArray数组的大小
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //创建统计数组，统计相应元素个数
        //此处d+1的原因就是max-min之间包括的元素个数就是d+1个；
        int[] countArray = new int[d + 1];
        //然后开始统计，每次出现的对应的元素下标处加1；
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        //第三部，上面已经统计完毕，
        //下面给统计数组做变形，后面的元素等于前面的元素之和；
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        //变形完了之后我们每次就可以根据编写后的排列来找到排序后的正确位置
        //倒叙遍历原数组，从统计数组中找到正确位置，然后输出到结果数组；
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }
}
