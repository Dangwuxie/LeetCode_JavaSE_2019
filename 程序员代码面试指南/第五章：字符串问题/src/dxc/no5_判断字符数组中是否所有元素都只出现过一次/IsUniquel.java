package dxc.no5_判断字符数组中是否所有元素都只出现过一次;

/**
 * @author 灵魂编程者
 * @Title: IsUniquel
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/20 19:37
 */
/*
* 题目要求：
* 给定一个字符类型数组chas[]，判断其中的所有字符是否都只出现过一次
* 例如：chas=['a','b','c']，返回true
* chas=['1','2','1'],返回false；
*
* */
public class IsUniquel {
    /*
    * 思路1：使用一个boolean数组，遍历一遍，
    * 如果出现第二次就会直接返回false
    * 这个做法利用了boolean数组元素的默认值是fasle的作用
    *
    * */
    public static boolean isUniquel(char[] chas){
        if (chas == null){
            return true;
        }

        boolean[] booleans = new boolean[256];

        for (int i = 0;i < chas.length; i++){
            if (booleans[chas[i]]){
                //此处就是利用了默认值
                return false;
            }
            booleans[chas[i]] = true;
        }

        return true;
    }

}














