package dxc.no12_数组中两个字符串的最小距离;

/**
 * @author 灵魂编程者
 * @Title: GetMinDistance
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/10 20:55
 */
/*
* 题目要求：给定一个字符串数组arr和两个字符串s1和s2，返回数组中两个字符串的最小距离
* 如果其中一个字符串不在数组中或者为null或者两个字符串相等，返回-1
*
* 例如strs=["1"."3""3""3""2""3"."1"],s1="1" s2="2"，返回2
* strs=["AB"],s1="AB",s2="CD";返回-1
* */
public class GetMinDistance {
    /*
    * 解决方法：遍历整个字符串数组，使用last1和last2分别标记最近一次出现s1,s2,的下标
    * 每当遍历到s1字符串时，距离就是i-last2;当遍历到s2时，距离就是i-last1
    * 使用一个minDistance不停更新记录最小距离
    * */
    public static int getMinDistance(String[] strArr,String s1,String s2){
        if (s1 == null || s2 == null){
            return -1;
        }
        if (s1.equals(s2)){
            return -1;
        }
        int last1 = -1;
        int last2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0;i < strArr.length; i++){
            if (strArr[i].equals(s1)){
                //注意，此处获取最小值必须是last不是-1的时候才能相减；
                //不然就会出错，因为-1的下标处并没有出现过对应的字符串
                minDistance = Math.min(last2 == -1 ? minDistance : i-last2,minDistance);
                last1 = i;
            }
            if (strArr[i].equals(s2)){
                minDistance = Math.min(last1 == -1 ? minDistance : i-last1,minDistance);
                last2 = i;
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}
