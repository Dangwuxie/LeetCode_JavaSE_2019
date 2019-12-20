package dxc.no13_字符串的转换路径问题;


import java.lang.reflect.Array;
import java.util.*;

/**
 * @author dxc
 * @Title: GetMinPath
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/18 22:39
 */

/*
* 题目要求：
* */
public class GetMinPath {

    public static void getMinPath(String start,String to,String[] strs){
        List<String> list = new ArrayList<>();
        for (int i = 0;i < strs.length; i++){
            list.add(strs[i]);
        }
        List<List<String>> res = getMinPaths(start,to,list);
    }

    private static List<List<String>> getMinPaths(String start,String to,List<String> list){
        //先把start添加进去
        list.add(start);
        //下面就是获取每个字符串的nexts信息，一遍后面构建成的图；
        //图就是各个字符串之间的关系
        HashMap<String,ArrayList<String>> nexts = getNexts(list);

        List<List<String>> res = new LinkedList<>();
        return res;
    }

    //此方法是获取list中每个字符串变化一个字符后在list存在的字符串集合，字符串以及对应下一个字符串的集合；
    public static HashMap<String,ArrayList<String>> getNexts(List<String> words){
        Set<String> dict = new HashSet<>(words);
        HashMap<String,ArrayList<String>> nexts = new HashMap<>();

        for (int i = 0;i < words.size(); i++){
            nexts.put(words.get(i),new ArrayList<>());
        }

        for (int i = 0;i < words.size(); i++){
            nexts.put(words.get(i),getNext(words.get(i),dict));
        }
        return nexts;
    }

    //此方法获取每个字符串对应的list中存在的字符串List集合
    public static ArrayList<String> getNext(String word,Set<String> dict){
        ArrayList<String> list = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char cur = 'a';cur <= 'z'; cur++){
            //26个英文字母，每个字母每次替换单词的不同位置
            for (int i = 0;i < chs.length; i++){
                char tmp = chs[i];
                chs[i] = cur;
                //如果Set中包含转换一个字母后的字符串
                //就添加进list；
                if (dict.contains(String.valueOf(chs))){
                    list.add(String.copyValueOf(chs));
                }
                chs[i] = tmp;
            }
        }
        return list;
    }
}








