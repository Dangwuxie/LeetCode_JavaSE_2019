package dxc.no8_字符串的调整和替换;

/**
 * @author 灵魂编程者
 * @Title: ReplaceAndAdjust
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/21 13:46
 */

/*
* 题目1：给你一个字符数组，右半区全是空字符(0),左半部分不含空字符，
* 但是需要将作伴区域的空格替换为%20,这个占3个空间，
* 所以替换后的右半区长度就是原来的长度，就上原来的空格长度的2倍；
* 假设右半区域的空间足够容纳扩展后的左半区域
*
* 题目2：给你一个字符数组，全是数字和“*”，然后要求调整后，
* “*”全部在数组的左边，数字在右边，而且数字原本的顺序不能发生改变；
* */
public class ReplaceAndAdjust {

    /*
    * 方法1思路：首先计算出替换之后的左半区的最后一个元素的位置，就是左半区的长度
    * 然后从左半区最后一个不为空的元素开始，如果碰到不是空格，就赋值
    * 否则就变成%20;
    *
    * 实现技巧，逆序复制
    * */
    public static void replaceString(char[] chas){

        if (chas == null || chas.length == 0){
            return;
        }

        int size = 0;
        int num = 0;//空格的长度

        for (size = 0;size < chas.length-1 && chas[size] != 0; size++){
            if (chas[size] == ' '){
                num++;
            }
        }
        //此时计算替换后的最后一个元素下标
        int j = size - 1 + num * 2;
        //开始替换
        for (int i = size-1;i >= 0;i--){
            if (chas[i] != ' '){
                chas[j--] = chas[i];
            }else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }
    /*
    * 题目2思路：
    * 跟前面的一样，碰到数字就复制，“*”不复制
    * 最后填满左半区“*”
    *
    * 实现技巧，逆序复制
    * */
    public static void modifyCharArray(char[] chars){
        if (chars == null || chars.length == 0){
            return;
        }

        int j = chars.length-1;
        for (int i = chars.length-1;i > -1; i--){
            if (chars[i] != '*'){
                chars[j--] = chars[i];
            }
        }

        while (j > -1){
            chars[j--] = '*';
        }
    }

}















