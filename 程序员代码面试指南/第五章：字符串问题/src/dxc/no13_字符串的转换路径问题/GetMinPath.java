package dxc.no13_字符串的转换路径问题;


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

    public static List<List<String>> getMinPath(String start,String to,String[] strs){
        List<String> list = new ArrayList<>();
        for (int i = 0;i < strs.length; i++){
            list.add(strs[i]);
        }
        List<List<String>> res = getMinPaths(start,to,list);
        return res;
    }

    public static List<List<String>> getMinPaths(String start,String to,List<String> list){
        //先把start添加进去
        list.add(start);
        //下面就是获取每个字符串的nexts信息，一遍后面构建成的图；
        //图就是各个字符串之间的关系
        HashMap<String,ArrayList<String>> nexts = getNexts(list);
        //下面就是每个字符串到达start字符串的距离的统计
        HashMap<String,Integer> distances = getDistances(start,nexts);

        List<List<String>> res = new ArrayList<>();
        LinkedList<String> stringPath = new LinkedList<>();
        getShortsPaths(start,to,nexts,distances,stringPath,res);

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
            /*if (words.get(i).equals("abc")){
                System.out.println(111111);
            }*/
            nexts.put(words.get(i),getNext(words.get(i),dict));
        }

        return nexts;
    }

    //此方法获取每个字符串对应的list中存在的字符串List集合
    public static ArrayList<String> getNext(String word,Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char cur = 'a';cur <= 'z'; cur++){
            //26个英文字母，每个字母每次替换单词的不同位置
            for (int i = 0;i < chs.length; i++){
                if (chs[i] != cur){
                    char tmp = chs[i];
                    chs[i] = cur;
                    //如果Set中包含转换一个字母后的字符串
                    //就添加进list；
                    if (dict.contains(String.valueOf(chs))){
                        res.add(String.valueOf(chs));
                    }
                    /*if (word.equals("abc")){
                        if (String.valueOf(chs).equals("abb")
                                || String.valueOf(chs).equals("cbc")
                                || String.valueOf(chs).equals("acc")){
                            System.out.println(String.valueOf(chs));
                        }
                    }*/
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    //此方法根据获得的nexts信息，就是构建的字符串之间的图，然后获取每个字符串到start的距离
    public static HashMap<String,Integer> getDistances(
            String start,HashMap<String,ArrayList<String>> nexts){

        HashMap<String,Integer> distances = new HashMap<>();
        //先把start自己添加进去，自己到自己的距离是0
        distances.put(start,0);
        //下面的代码就是根据这个“图”来一步一步的求每个字符串到达start的距离
        //使用队列和哈希表set来一步一步的遍历图
        //就是利用的宽度遍历
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        Set<String> set = new HashSet<String>();
        set.add(start);
        while (!queue.isEmpty()){
            //当队列不为空的时候，不停的出队列，遍历图中没有遍历到的点
            String cur = queue.poll();
            //获取nexts中key为当前cur的value，这个value也就是
            //cur在list中所对应的变一个字母就在list中存在的字符串
            for (String str : nexts.get(cur)){
                //str就是cur在list中可以转换成的字符串
                //如果str已经标记过value，set中就已经存在，就不进入此if语句
                if (!set.contains(str)){
                    //如果进入此条件语句，那么就获得当前的str的值，
                    //然后str肯定就是cur的下一个字符串，就是get(cur)的值加1；
                    distances.put(str,distances.get(cur)+1);
                    //让此字符串入队列和哈希表
                    queue.add(str);
                    set.add(str);
                }
            }
        }
        //最后返回这个哈希表。
        return distances;
    }

    //此方法就是就收一个List<List<>>类型的数据结构，
    //保存所有to到start的字符串转换路径
    public static void getShortsPaths(String cur,String to,
                                      HashMap<String,ArrayList<String>> nexts,
                                      HashMap<String,Integer> distances,
                                      LinkedList<String> stringPath,
                                      List<List<String>> res){

        //stringPath保存的是单个的字符串转换路径
        //res保存的是多条路径
        //先把start保存下来，从start开始遍历图
        stringPath.add(cur);

        if (to.equals(cur)){
            //说明此时已经递归到了to这个字符串
            res.add(new LinkedList<String>(stringPath));
        }else {
            //否则继续向下递归
            for (String next : nexts.get(cur)){
                if (distances.get(next) == distances.get(cur)+1){
                    //如果下一个字符串到达start的距离刚好是前一个字符串的距离加1，
                    // 那么就进入此语句
                    //继续往下递归
                    getShortsPaths(next,to,nexts,distances,stringPath,res);
                }
            }
        }
        //检索并删除此列表的最后一个元素，
        //如果此列表为空，则返回 null 。
        //这个对应前面的stringPath.add(cur)，因为如果刚好to.equals(cur)，
        //就直接添加进res了，可是如果不满足if条件中的任何条件
        //就是说当前的字符串到start的距离不是依次递增+1的，就要删除此字符串；
        stringPath.pollLast();
    }

}








