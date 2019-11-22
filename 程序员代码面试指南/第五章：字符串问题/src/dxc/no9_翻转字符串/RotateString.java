package dxc.no9_翻转字符串;

/**
 * @author 灵魂编程者
 * @Title: RotateString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/21 14:48
 */

/*
* 题目1：反转字符串；按照单词反转;
*
* */
public class RotateString {

    /*
    * 实现思路：
    *
    * */
    public static void rotateWord(char[] chars){

        if (chars == null || chars.length == 0){
            return;
        }
        //整体反转
        reverse(chars,0,chars.length-1);
        //单词内部反转
        int l = -1;
        int r = -1;
        for (int i = 0;i < chars.length; i++){
            //此循环就是开始反转单词
            if (chars[i] != ' '){
                l = i==0 || chars[i-1]==' ' ? i : l;
                r = i==chars.length-1 || chars[i+1]==' ' ? i : r;
            }

            if (l != -1 && r != -1){
                reverse(chars,l,r);
                l = -1;
                r = -1;
            }
        }
    }

    public static void reverse(char[] chars,int start,int end){
        char tmp = 0;
        while (start < end){
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

}
















