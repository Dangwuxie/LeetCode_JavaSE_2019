package dxc.no4_GetCountString;

/**
 * @author 灵魂编程者
 * @Title: GetCStringindex
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/24 0:06
 */

/*
* 扩展题目：反过来给你一个统计字符串,
* 再给定一个整数k，找到这个字符串中的第k个字符
* a_5_b_10_g_8  b_4_f_6_a_8  这种
*
* 思路：调用字符串的split方法分割就行
* 可是如果不允许调用String类的任何库函数，那么就需要遍历了
*
* */
public class GetCStringindex {
    public static void main(String[] args) {
        String str1 = "a_5_b_10_g_80";
        String str2 = "b_4_f_6_a_80";

        System.out.println(getCStringindex(str2,4));

    }

    public static char getCStringindex(String str,int index){
        if (str==null||str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        boolean flag = true;
        char pre = 0;
        int sum = 0;
        int num = 0;
        for (int i=0;i<chs.length;i++){
            if (chs[i] == '_'){
                flag = !flag;
            }else if (flag){
                //此时flag为true，代表此时到了字符阶段
                sum+=num;
                if (sum>index-1){
                    return pre;
                }
                pre = chs[i];
                num = 0;
            }else {
                //如果走到了此分支语句，代表此时还在统计字符出现的次数
                num = num*10+chs[i]-'0';

            }
        }

        //上面的for循环完了之后，
        //a_5_b_10_g_8比如这个，最后的数字并没有加在sum上，
        // 如果此时还没有判断出index
        //需要重新判断

        return (sum+num)>(index-1)?pre:0;
    }

}
