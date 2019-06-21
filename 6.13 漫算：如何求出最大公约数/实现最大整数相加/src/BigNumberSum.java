/**
 * @author Dangxuchao
 * @Title: BigNumberSum
 * @ProjectName 漫算：如何实现大整数相加
 * @Description: 给出两个很大的整数，要求实现程序求出两个整数之和；
 * 思路：这种题肯定不是定义个long类型就能解决的，
 * 需要通过数组求出，数组的每一位元素就是大整数的每一个数位；
 * 把每个整数倒序存进数组里面，方便进位运算；
 * 每次计算相同下标处的元素并且加上上一个坐标相加时产生的进位；
 *
 *
 * @date 2019/6/21 20:38
 */
public class BigNumberSum {

    public static String  addBigNumber(int[] arrA,int[] arrB){
        int[] result = new int[arrA.length];

        //下面从下标为0的地方开始加，什么时候判断停止呢，
        // 当加到较大整数下标为maxLength的时候；
        //temp为临时的进位判断
        for (int i = 0;i < arrA.length;i++){
            int temp = result[i] + arrA[i] + arrB[i];

            if (result[i] >= 10){
                temp -= 10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }

        //将result数组再次逆序并转成String类型；

        StringBuilder sb = new StringBuilder();

        boolean findFirst = false;

        for (int i = result.length-1;i >= 0;i--){
            if (!findFirst){
                if (result[i] == 0)
                continue;

                findFirst = true;
            }

            sb.append(result[i]);


        }

        return sb.toString();
    }

}
