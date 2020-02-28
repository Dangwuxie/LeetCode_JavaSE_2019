package dxc3.no58_翻转字符串;

/**
 * @author dxc
 * @Title: ReversePortionOfWords
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 21:30
 */
/*
*   给定字符串，旋转前k个字符到后面去
*   abcdefg --> cdefgab  这样的；
* */
public class ReversePortionOfWords {

    public static String getReverseWords(String str,int k){

        if (str == null || k < 0){
            return null;
        }

        char[] strs = str.toCharArray();

        reverseChars(strs,0,k - 1);
        reverseChars(strs,k,strs.length - 1);
        reverseChars(strs,0,strs.length - 1);

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
