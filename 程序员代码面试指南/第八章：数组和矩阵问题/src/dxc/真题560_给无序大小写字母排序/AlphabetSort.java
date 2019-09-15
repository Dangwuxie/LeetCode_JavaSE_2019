package dxc.真题560_给无序大小写字母排序;

/**
 * @author 灵魂编程者
 * @Title: AlphabetSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 17:25
 */
public class AlphabetSort {
    public static void alphabetSort(char[] ch){
        //排序:思路，一共52个字母，创建一个字符数组，
        //奇数下标保存小写字母，偶数保存大写字母，然后按照下标遍历数组即可
        char[] charCount = new char[54];
        for (int i=0;i<ch.length;i++){
            if (ch[i]<='z'&&ch[i]>='a'){
                //是小写字母，保存到偶数下标，0，2，4，。。。
                charCount[(ch[i]-'a')*2]++;
            }else if (ch[i]<='Z'&&ch[i]>='A'){
                charCount[(ch[i]-'A')*2+1]++;
            }
        }
        print(charCount);
    }

    public static void print(char[] charCount){
        for (int i=0;i<charCount.length;i++){
            while (charCount[i]-- >0){
                if (i%2 == 0){
                    //是小字母
                    System.out.print((char)('a'+i/2));
                }else if (i%2 != 0){
                    //是大字母
                    System.out.print((char)('A'+(i-1)/2));
                }

            }
        }

    }
}
