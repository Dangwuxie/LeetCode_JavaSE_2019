package dxc2.no38_字符串全排列;

/**
 * @author dxc
 * @Title: RegroupString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/10 13:25
 */
/*
* 题目要求：字符串全排列；打印出所有的排列；
* */
public class RegroupString {

    /*
    * 思路：递归实现，每次把字符串分成两部分，第一个字符，后面的所有字符
    * 每次递归中，依次交换第一位字符与剩下的所有字符，交换后递归
    * 递归回来后重新交换回来；
    * 最直接的思路就是，每次递归函数里面的字符串，每个字符都能作为首字符
    *
    * 然后再递归剩下的字符串。剩下的字符串也是这个思路;直到begin指向字符串的末尾
    * begin始终指向每一次字符串的第一个字符，就是需要排列的字符串的第一个字符；
    * */
    /*
    * a\b\c举例子
    * "a"开头->"bc"
    *       -->"b"开头->"c"
    *           -->输出
    *       -->"c"开头->"b"
    *           -->输出
    * “b”开头->"ac"
*           -->"a"开头->"c"
*               -->输出
*           -->"c"开头->"a"
*               -->输出
    * "c"开头->"ba"
    *       -->"b"开头->"a"
    *           -->输出
    *       -->"a"开头->"b"
    *           -->输出
    * */
    public static void regroupString(String string){

        if (string == null){
            return;
        }

        reGroupCore(string.toCharArray(),0);

    }

    private static void reGroupCore(char[] strings,int begin){

        if (begin == strings.length){
            //此时字符数组已经递归完毕，直接输出这一层递归的排列结果
            System.out.println(new String(strings));
            return;

        }else {

            for (int i = begin;i < strings.length; i++){

                char tmp = strings[i];
                strings[i] = strings[begin];
                strings[begin] = tmp;
                //将当前的首字符交换之后递归.每次递归都是首字母和剩下的字符，两部分
                reGroupCore(strings,begin + 1);
                //递归之后再次转换回来
                tmp = strings[i];
                strings[i] = strings[begin];
                strings[begin] = tmp;
            }

        }

    }
}
