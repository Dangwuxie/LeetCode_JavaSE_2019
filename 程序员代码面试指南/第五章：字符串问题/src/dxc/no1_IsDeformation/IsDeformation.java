package dxc.no1_IsDeformation;

/**
 * @author 灵魂编程者
 * @Title: IsDeformation
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/10 22:32
 */
/*
* 判断两个字符串是否为变形词
* "123"/"213"返回true
* "123"/"2331"返回false
* 思路，用一个数长度为256，先遍历str1，遇到一个字符返回ASCII码表中对应的数字
* 以该数字为下标设置对应元素++，然后遍历str2，
* */
public class IsDeformation {
    public static void main(String[] args) {
        String str1 = "123bvc{/.";
        String str2 = "213avc{./";
        isDeformation(str1,str2);

    }

    public static void isDeformation(String str1,String str2){
        //如果两个字符串的长度不同，直接return
        if (str1.length() != str2.length()){
            return;
        }

        //下面就需要两个字符数组来保存两个str的字符了
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[1000];

        for (int i=0; i<chars1.length; i++){
            map[chars1[i]]++;
        }

        //然后遍历str2来消除，如果有map中有一个元素小于0，那就直接return false；

        for (int i=0; i<chars2.length; i++){
            if (--map[chars2[i]] == 0){
                System.out.println("不是变形词！");
                return;
            }
        }

        System.out.println("是变形词！");
    }
}
