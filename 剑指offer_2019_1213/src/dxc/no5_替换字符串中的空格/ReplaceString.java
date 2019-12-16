package dxc.no5_替换字符串中的空格;

/**
 * @author dxc
 * @Title: ReplaceString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/16 17:55
 */
/*
* 题目要求，给定一个含空格的字符串，要求将字符串中的空格替换%20
*
* */
public class ReplaceString {
    /*
    * 思路：一个空格替换成%20,长度增加了2，所以n个空格替换成%20后的长度为n+2*n
    * 可以创建一个替换全部空格后的新的字符串长度，利用字符数组替换，
    * 两个指针p1，p2，分别从两个数组的最后一位，p1碰到空格的时候，
    * p2指针就向前走三位，一次替换为0-2-%,知道原数组p1指向0下标的下一个；
    *
    * 时间复杂度为O(n);额外空间复杂度为O(),利用的是逆序复制的特点
    * */
    public static String replaceString(String str){

        if (str == null || str.length() <= 0){
            return null;
        }

        char[] originalArr = str.toCharArray();
        int oldLength = originalArr.length;
        int blank = 0;

        for (int i = 0;i < originalArr.length; i++){
            if (originalArr[i] == ' '){
                blank++;
            }
        }
        //新的字符数组的长度
        int newLength = oldLength + 2*blank;
        char[] newArr = new char[newLength];
        //定义两个指针开始复制数组
        int p1 = oldLength - 1;
        int p2 = newLength - 1;

        while (p1 >= 0){
            if (originalArr[p1] == ' '){
                newArr[p2--] = '0';
                newArr[p2--] = '2';
                newArr[p2--] = '%';
            }else {
                newArr[p2--] = originalArr[p1];
            }
            p1--;
        }
        //将转换成功的新数组转换成字符串返回去
        return String.valueOf(newArr);
    }
}









