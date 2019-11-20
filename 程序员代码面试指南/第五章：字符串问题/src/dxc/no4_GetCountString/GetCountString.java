package dxc.no4_GetCountString;

/**
 * @author 灵魂编程者
 * @Title: no4_GetCountString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/23 23:22
 */

/*
* 题目是：给一个字符串str，返回它的统计字符串；
*
* 例如：aaabbaddfffe 转换为a_3_b_2_a_1_d_2_f_3_e_1;
* 就是这个样子，定义一个常量num记录当前遍历的字符出现的个数
* 比如a，三次num加三次变成3；第四个字符的时候，与前一个字符不一样
* num重新变成1，然后又开始，当前字符出现一次就加一次；
* 当前字符发生变化的时候，比如a变到b时，应该是这样res+"_"+num+b
* 到下一次的是时候，num继续在res后面加，就是b的个数，然后加上c，
* 当执行到最后一个字符的时候，并没有加上num，
* 所以执行完后需要再次与空字符串仪器调用一次appendString方法；
*
* */
public class GetCountString {

    public static String getCountString(String str){
        if (str == null||str.equals("")){
            return null;
        }

        char[] chs = str.toCharArray();
        int num = 1;
        String res = String.valueOf(chs[0]);
        for (int i=1;i<chs.length;i++){
            if (chs[i]!=chs[i-1]){
                res = appendString(res,String.valueOf(num),String.valueOf(chs[i]));
                num = 1;
            }else {
                num++;
            }
        }
        return appendString(res,String.valueOf(num),"");

    }

    public static String appendString(String s1,String s2,String s3){
        return s1+"_"+s2+(s3.equals("")?s3:"_"+s3);
    }

}
