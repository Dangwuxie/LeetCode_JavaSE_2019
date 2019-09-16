package dxc.求一个字符串中的最大数字子串;

import java.util.Scanner;

/**
 * @author 灵魂编程者
 * @Title: Test3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/16 20:22
 */
public class Test3 {
    public static void main(String[] args) {
        smallestRange();
    }
    static int smallestRange() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int a2 = Integer.parseInt(a);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        System.out.println(a);
        int[] ints = new int[strings.length];
        for (int i=0;i<strings.length;i++){
            ints[i] = Integer.parseInt(strings[i]);
        }
        return 3;
    }
}
