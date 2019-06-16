import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName leetcode_排序
 * @Description: 寻找全排列的下一个数字；字典序算法：
 * 题目要求：输入12345，返回12354；输入12345，返回12435；输入12435，返回12453；
 *
 * 解题思路：固定的几个数字全排列后，顺序和逆序是两种极端情况；
 * 可以这么做，尽量保持高位不变，低位在最小的范围里面变换顺序；
 *
 * 3个步骤：
 * 从后往前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界；
 * 让逆序区域的前一位和逆序区最小的的元素交换位置；
 * 把原来的逆序区域转变成为顺序区域；
 *
 * @date 2019/6/16 14:28
 */
public class Test {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,9,8,6,7,5};
        int[] ints =  findNearestNumber(numbers);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] findNearestNumber(int[] numbers){
        int index = findTransferPoint(numbers);
        System.out.println(numbers[index]);
        if (index == 0){
            return null;
        }
        int[] numberCopy = Arrays.copyOf(numbers,numbers.length);

        exchangeHead(numberCopy,index);
        System.out.println(Arrays.toString(numberCopy));
        //把原来的逆序区域改成顺序
        resverse(numberCopy,index);

        return numberCopy;
    }
    public static void resverse(int[] numbersCopy,int index){
        for (int i = index,j = numbersCopy.length-1;i < j;i++,j--){
            int temp = numbersCopy[i];
            numbersCopy[i] = numbersCopy[j];
            numbersCopy[j] = temp;
        }
    }
    private static void exchangeHead(int[] numbers,int index){
        int head = numbers[index-1];
        for (int i = numbers.length-1;i > 0;i--){
            if (head < numbers[i]){
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }
    public static int findTransferPoint(int[] numbers){
        for (int i = numbers.length-1;i >= 0;i--){
            if (numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }
}
