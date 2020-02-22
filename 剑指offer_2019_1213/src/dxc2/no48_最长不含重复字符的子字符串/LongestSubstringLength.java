package dxc2.no48_最长不含重复字符的子字符串;

/**
 * @author dxc
 * @Title: LongestSubstringLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/20 15:05
 */
/*
* 题目要求：请从字符串中找出一个最长的不包含重复字符的子字符串，
* 计算该子字符串的长度；只包含'a'-'z'的字符26个；
* 例如'arabcacfr'中，最长的'rabc''acfr'这样
* */
public class LongestSubstringLength {

    /*
    * 实现思路，首先需要一个int型的长度为26的数组来保存每个字符出现的位置
    * 实际上每次出现就需要更新数组，下次会用到；
    * 从左到右遍历数组，如果第i个元素在前面没有出现过，那么继续cur++；
    * 如果出现了，此时需要判断距离，如果大于当前的的cur长度，那么继续cur++
    * 如果小于或者等于，此时说明cur这个长度包含上一个重复的元素，需要更新cur的值
    * 更新思路，就是于上一个之后的元素到当前的元素的距离，这个长度刚好没有重复元素；
    * */
    public static int getLongestSubstring(String str){

        char[] arr = str.toCharArray();
        //26长度的数组用来存储每个字符上次出现在字符串中的位置下标
        int[] position = new int[26];
        for (int i = 0;i < position.length; i++){
            position[i] = -1;
        }
        int curLength = 0;
        int maxLength = 0;

        for (int i = 0;i < arr.length; i++){

            int preIndex = position[arr[i] - 'a'];
            if (preIndex < 0 || (i-preIndex > curLength)){
                //说明没有重复或者与前面的相同字符不冲突;
                curLength++;
            }else {
                //此时说明冲突了，必须重新判断最长字串
                maxLength = curLength > maxLength ? curLength : maxLength;
                //就是说把前一个相同的字符去掉，把当前的字符包进去继续往后计数
                curLength = i - preIndex;
            }
            //更新当前的字符出现的位置
            position[arr[i] - 'a'] = i;
        }

        if (curLength > maxLength){
            maxLength = curLength;
        }

        return maxLength;
    }


}
