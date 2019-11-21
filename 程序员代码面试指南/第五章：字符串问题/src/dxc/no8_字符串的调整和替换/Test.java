package dxc.no8_字符串的调整和替换;

import dxc.PrintCharArray;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/21 13:45
 */
public class Test {

    public static void main(String[] args) {

        char[] chars = new char[]{'*','2','4','*','1','7',0,0,0,0,0,0,0,0,0};

        char[] chars2 = new char[]{' ','2','4',' ','1','7',0,0,0,0,0,0,0,0,0};

        ReplaceAndAdjust.replaceString(chars2);
        PrintCharArray.printCharArray(chars2);

        ReplaceAndAdjust.modifyCharArray(chars);
        PrintCharArray.printCharArray(chars);
    }

}
