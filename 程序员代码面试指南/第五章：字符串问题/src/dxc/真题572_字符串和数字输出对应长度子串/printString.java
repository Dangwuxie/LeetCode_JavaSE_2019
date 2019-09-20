package dxc.真题572_字符串和数字输出对应长度子串;

/**
 * @author 灵魂编程者
 * @Title: printString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/20 9:29
 */
/*
* 题目：输入一串字符和一个数字，数字代表输出这个字符串多长的子串
* 比如：as1213,4-->as12
*       我12asda,4-->我12(中文字符占两个字节)
*       我12你sa,5-->我12,因为此时第五个是中文，此时不能输出半个中文，所以此时不输出
* */

public class printString {
    public static String truncateStr(String str,int len){
        if (str==null||str.equals("")||len==0){
            return null;
        }

        //转化为字节数组，然后创建一个临时变量，每遍历一次就增加一次
        int count = 0;
        char[] strArr = str.toCharArray();
        StringBuffer sb = new StringBuffer("");
        for (int i=0;i<strArr.length;i++){

            if (count<len){
                if (isChanese(strArr[i])){
                    if ((count+1)==len)
                        return sb.toString();
                        sb.append(strArr[i]);
                        count+=2;
                }else {
                    count+=1;
                    sb=sb.append(strArr[i]);
                }
            }else {
                break;
            }
        }

        return sb.toString();
    }

    public static boolean isChanese(char ch){
        String c = String.valueOf(ch);
        return c.getBytes().length>1?true:false;
    }

}
