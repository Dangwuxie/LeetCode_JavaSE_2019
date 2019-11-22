package dxc.no9_翻转字符串;

import dxc.PrintCharArray;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/21 14:48
 */
public class Test {

    public static void main(String[] args) {
        String str = "dog loves pig";
        char[] chars = str.toCharArray();
        RotateString.rotateWord(chars);
        PrintCharArray.printCharArray(chars);
    }
}
