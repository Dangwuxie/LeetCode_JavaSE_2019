package dxc.no20_表示数值的字符串;

/**
 * @author dxc
 * @Title: IsNumeric
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/27 22:45
 */
/*
* 题目要求：给定字符串，判断是否表示的是数值
* 例如：+100,5e2,-123,3.12,-1E-16,都是可以的
* 但12e,1a2.12,1.1.2,+-5,12e+5.2都不符合；
* 遵循A[.[B]][e|Ec]、或者 .B[e|EC],
* 就是说，A部分是整数部分，小数点后面的B是小数点后面部分，
* 然后e+数值C，代表指数部分，
* 整数部分和指数部分可以是正负开头的0-9的数位串
* B是0-9的数位串，不能有正负号；
*/
/*
* 这题目没做好！
* */
public class IsNumeric {
    /*
    * 解题思路：分A\B\C三个部分检查
    * 注意B部分没有正负号
    * */
    public static boolean isNumeric(String str){

        if (str == null){
            return false;
        }

        char[] strs = str.toCharArray();
        //首先，扫描整数A部分，可以是-+开头
        //scanA返回值表示如果A部分如果正确，就返回小数点的下标
        //否则就返回-1；
        int aIsNumeric = scanAC(strs,0);

        if (aIsNumeric != -1 && aIsNumeric < strs.length && strs[aIsNumeric] == '.'){
            //如果整数部分正确，而且碰到了小数点就进入此部分
            aIsNumeric = scanB(strs,aIsNumeric);
        }

        if (aIsNumeric != -1 && aIsNumeric < strs.length
                && (strs[aIsNumeric] == 'e' || strs[aIsNumeric] == 'E')){
            //此时说明小数部分也正确，如果存在指数部分，就继续判断
            aIsNumeric = scanAC(strs,aIsNumeric);
        }

        if (aIsNumeric == -1){
            return false;
        }else {
            return true;
        }
    }

    private static int scanAC(char[] strs,int index){
        //第一个判断符号后，再判断数字
        if (strs[index] == '+' || strs[index] == '-'){
            index++;
        }
        //此处不可以可以有正负号，只能有一个符号
        while (index < strs.length){
            if (strs[index] >= '0' && strs[index] <= '9'){
                index++;
            }else if (strs[index] == '.' || strs[index] != 'e' || strs[index] != 'E'){
                return index;
            }else {
                return -1;
            }
        }
        return index;
    }

    private static int scanB(char[] strs,int index){
        //次数没有被正负号，碰到e、E就停止
        while (index < strs.length){

            if (strs[index] >= '0' && strs[index] <= '9'){
                index++;
            }else if (strs[index] != 'e' || strs[index] != 'E'){
                return index;
            }else {
                return -1;
            }
        }
        return index;
    }

}
