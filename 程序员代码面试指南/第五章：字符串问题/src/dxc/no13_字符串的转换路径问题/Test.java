package dxc.no13_字符串的转换路径问题;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/18 22:37
 */
/*
* 问题：字符串的转换路径问题
* */
public class Test {

    public static void main(String[] args) {

        String[] strs = new String[]{"cab","acc","cbc","ccc","cac","cbb","aab","abb"};
        String start = "abc";
        String to = "cab";
        List<List<String>> res = GetMinPath.getMinPath(start,to,strs);
        for (List<String> stringPath : res){
            for (String str : stringPath){
                System.out.print(str+"-");
            }
            System.out.println();
        }

       /* List<String> list = new ArrayList<>();
        for (int i = 0;i < strs.length; i++){
            list.add(strs[i]);
        }
        list.add(start);

        HashMap<String,ArrayList<String>> nexts = GetMinPath.getNexts(list);*/

        /*for (int i = 0;i < list.size(); i++){
            System.out.print(list.get(i)+":");
            for (String nex : nexts.get(list.get(i))){
                System.out.print(nex+"-");
            }
            System.out.println();
        }*/

       /* HashMap<String,Integer> distance = GetMinPath.getDistances(start,nexts);
        System.out.println(distance);*/

    }
}






