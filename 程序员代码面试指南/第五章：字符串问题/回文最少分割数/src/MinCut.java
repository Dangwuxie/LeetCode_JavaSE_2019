/**
 * @author Dangxuchao
 * @Title: MinCut
 * @ProjectName 第五章：字符串问题
 * @Description: 回文最小分割数
 *
 * @date 2019/7/2 16:16
 */
public class MinCut {
    public static void main(String[] args) {
        String str1 = "ACDCDCE";
        String str2 = "ABCDEFF";
        String str3 = "AAAAABB";
        String str4 = "AAAAAAA";
        System.out.println(isMinCut(str1));
        System.out.println(isMinCut(str2));
        System.out.println(isMinCut(str3));
        System.out.println(isMinCut(str4));

    }
    public static int isMinCut(String str){
        //首先定义一个数组dp用来存放最小切割的次数；
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] dp = new int[len+1];

        //boolean一个二维数组；在计算dp数组的过程中，
        // 可以迅速判断出子串是否为回文串；
        //boolean数组的初始值为false;
        boolean[][] p = new boolean[len][len];
        dp[len] = -1;
        //然后两个指针从后向前遍历，每次记录下能切割成最大回文子串的次数；
        for (int i = len-1;i >= 0;i--){
            //每次进来将当前的dp[i]设置为最大值，
            //内层循环结束后得出dp[i]的最小值，
            //这个最小值就是str串中下标i至len-1串的切成回文数的最小切割次数；
            dp[i] = Integer.MAX_VALUE;
            //内层循环，就是说，从当前i所处的字符开始，
            //j一直遍历，因为i每次往前挪一个位置，就是减1，
            //减一之后，一开始的最少切割次数就是上次i内层循环
            //完之后得出来的最少切割次数+1，简单来说就是相当于把当前元素
            //直接单独切割出来；
            //然后往后遍历，如果能碰到哪个字符之后前后连接起来刚好凑成回文串
            //那么最少切割次数就是那个字符得下一个dp的值加1了，就是内层循环当前
            //计算出来的最少切割次数，
            //以此类推，最终dp[0]的值就是整个长串的最少回文分割数了；
            for (int j = i;j < len;j++){
                if (chars[i] == chars[j]&&(j-i<2 || p[i+1][j-1])){
                    //如果为true，那么代表子串从i到j的子串就是一个回文子串；
                    p[i][j] = true;

                    //然后求最小分割次数，也就是j字符后面的子串的分割次数加上1，
                    //因为从i到j是个回文子串
                    //此处要取dp[i]和dp[j+1]+1之间的最小值，
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}
/*
     输出结果:
        2
        5
        1
        0
 */









