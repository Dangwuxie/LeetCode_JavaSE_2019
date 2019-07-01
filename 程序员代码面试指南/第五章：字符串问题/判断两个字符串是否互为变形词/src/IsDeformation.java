import java.util.ArrayList;
import java.util.List;

/**
 * @author Dangxuchao
 * @Title: IsDeformation
 * @ProjectName 第五章：字符串问题
 * @Description:
 * 题目：给定两个字符串str1和str2,如果str1和str2中出现的字符种类一样并且
 * 每种字符出现的次数也是一样的，那么str1和str2互为变形词；实现函数判断
 * 两个字符串是否互为变形词；
 *
 * 举例：
 * str1 = "123"  str2 = "231"  返回true
 * str1 = "123"  str2 = "1234"  返回false
 *
 * 题目分析：
 * 我是这样想的，如果长度不相等呢，直接返回false，
 * 否则用两个整形集合分别存入两个字符串的每个元素，
 * 然后开始遍历其中一个集合，跟另外一个对比，如果包含某一个元素，
 * 就同时删除当前两个集合中的这个元素，如果元素重复，而且是互为
 * 变形词的话，那也是再一次同时删除元素，循环出来后，判断两个集合
 * 长度是否为0，若是，就是互为变形词，否则就不是，返回false；
 *
 * @date 2019/7/1 18:14
 */
public class IsDeformation {
    public static void main(String[] args) {
        String str1 = "121122adf@@!]]]";
        String str2 = "121122daf@!@]]]";

        System.out.println(isDeformation(str1,str2));

    }

    public static boolean isDeformation(String str1,String str2){

        if (str1 == null || str2==null || str1.length() != str2.length()){
            return false;
        }

        List<Character> str1List1 = new ArrayList<>();
        List<Character> str2List2 = new ArrayList<>();

        for (int i = 0;i < str1.length();i++){
            str1List1.add(str1.charAt(i));
            str2List2.add(str2.charAt(i));
        }

        for (int i = 0;i<str1List1.size();i++){
            if (str2List2.contains(str1List1.get(i))){
                //此处仅删除集合2的元素，是因为，如果同时删除
                //集合1的对应的相同元素的话，循环遍历下标就会
                //出错，所以仅删除集合2的元素
                //后面直接判断集合2的元素是否删除干净就行
                str2List2.remove(str1List1.get(i));
            }
        }

        /*
        下面就是，直接判断两个集合是否都为空，
        若是，说明两个字符串互为变形词，否则就不是；
         */

        if (str2List2.size()!=0){
            return false;
        }

        return true;
    }
}






















