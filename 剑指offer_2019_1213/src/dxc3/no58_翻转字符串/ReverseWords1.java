package dxc3.no58_翻转字符串;

/**
 * @author dxc
 * @Title: ReverseWords1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 19:27
 */
public class ReverseWords1 {

    public static String reverseWords1(String str){

        if (str == null){
            return null;
        }

        char[] strs = str.toCharArray();
        //先整体反转
        reverseChars(strs,0,strs.length - 1);
        //然后每次碰到空格反转部分
        int begin = 0;
        int end = 0;
        for (int i = 0;i < strs.length; i++){
            if (strs[i] == ' '){
                end = i;
                reverseChars(strs,begin,end - 1);
                begin = i+1;
                end = i+1;
            }
        }

        return new String(strs);
    }

    private static void reverseChars(char[] strs,int begin,int end){

        while (begin < end){
            char tmp = strs[begin];
            strs[begin] = strs[end];
            strs[end] = tmp;
            begin++;end--;
        }

    }

}
