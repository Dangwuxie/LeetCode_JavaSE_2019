package dxc.IntegerOfSum;

import java.util.Scanner;

/**
 * @author 灵魂编程者
 * @Title: Test1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/12 10:34
 */
public class Test1 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        Scanner scanner = new Scanner(System.in);
        strings[0] = scanner.next();
        strings[1] = scanner.next();

        //保证chars1数组永远是最大的那个数组
        char[] chars1 = strings[0].length()>strings[1].length()?
                strings[0].toCharArray():strings[1].toCharArray();
        char[] chars2 = strings[0].length()<=strings[1].length()?
                strings[0].toCharArray():strings[1].toCharArray();

        int[] sum = new int[chars1.length+1];
        //两个数组从最后一位开始相加，记住进位，然后从sum数组的第一位开始保存
        int temp = 0;
        for (int i=0;i<sum.length;i++){
            int tempsum = temp+(chars1[chars1.length-i-1]-'0')+(chars2[chars2.length-i-1]-'0');
            temp=0;
            if (tempsum>9){
                sum[i] = tempsum%10;
                temp = tempsum/10;
            }else {
                sum[i] = tempsum;
            }
            if (i==chars2.length-1)break;

        }
        //此时chars2已经加完了，剩下chars1的位数为char1.length-chars2.length
        for (int i=chars2.length;i<chars1.length;i++){
            int tempsum = temp+(chars1[chars1.length-i-1]-'0');
            temp=0;
            if (tempsum>9){
                sum[i] = tempsum%10;
                temp = tempsum/10;
            }else {
                sum[i] = tempsum;
            }
        }
        for (int i=sum.length-1;i>=0;i--){
            if (sum[i] != 0)
            System.out.print(sum[i]);
        }
        System.out.println();

    }
}
