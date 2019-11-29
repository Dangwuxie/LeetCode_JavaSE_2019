package dxc.no11_删除多余字符得到的字典序最小的字符串;

/**
 * @author 灵魂编程者
 * @Title: RemoveDuplicateLetters
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/29 20:57
 */

/*
* 题目要求：给定一串字符，其中全都是小写的字母，有重复，求删除重复元素之后字符串
* 具有最小的字典数；
*
* */
public class RemoveDuplicateLetters {

    /*
    * 实现思路：
    * 先利用一个数组map保存一下当前字符串数组中有哪些字符以及他们出现的次数
    * 然后使用循环遍历，每次遍历到一个字符时map所在下标处自减1，如果某一次减1后为0.
    * 此时就需要求得当前下标处前面的所有字符中字典序最小的并且第一个出现的字母，
    * 使用res保存最终字符数组，然后res的下标自增1，等待下一个字母；
    * 此时又需要重新上面的步骤，重新获取字符串，重新遍历字符串，遍历上一步保存下来的
    * 那个元素的下一个元素起始，遍历的过程中如果碰到之前保存进res的元素，就将该处的map下标置为-1；
    *
    * */

    /*
    * 要点：所谓的每次遍历依次删除最小的字典数字母
    * 就是将map中所在下标的元素变成-1；
    * 后面遍历的时候加上一个判定条件就是map的元素不等于-1才能继续；
    * */
    public static String getMinString(String str){

        char[] res = new char[26];
        char[] strs = str.toCharArray();
        int[] map = new int[26];

        for (int i = 0;i < strs.length; i++){
            map[strs[i]-'a']++;
        }

        int index = 0;
        int R = 0;//用来遍历字符数组
        int L = 0;//用来限定需要遍历的字符数组的左边界；

        //限定条件，当R没有到strs的最后一个字符的时都需要继续循环；
        while (R != strs.length){
            if (map[strs[R] - 'a'] == -1 || --map[strs[R] - 'a'] > 0){
                //说明此时所遍历的字符要么是已经加入res的，
                // 要么就是字符串后面还有相同的字符
                R++;
            }else {
                //此时就是当前遍历到的字符是最后一个字符
                //此时就需要找出但当前字符前面的最小字典序的字符；
                int pink = 0;
                for (int i = L;i <= R; i++){
                    if (map[strs[i]-'a'] != -1 && ( pink == 0 || strs[i] < strs[pink])){
                        pink = i;
                    }
                }
                //此时pink所在的字符就是当前所要找的最小字典序的字符
                res[index++] = strs[pink];
                //将之前自减1的元素全部加回来
                ///仅限于pink+1之后至R的元素
                for (int i = pink+1; i <= R; i++){
                    if (map[strs[i] - 'a'] != -1){
                        map[strs[i] - 'a']++;
                    }
                }
                //将当前求出来的pink在map所在的数字置为-1；
                map[strs[pink] - 'a'] = -1;
                //R\L重新改变字符界限
                L = pink+1;
                R = L;
            }
        }
        return String.valueOf(res,0,index);
    }
}
