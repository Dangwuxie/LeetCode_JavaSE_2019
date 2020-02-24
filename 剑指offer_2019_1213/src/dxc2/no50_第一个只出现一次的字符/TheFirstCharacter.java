package dxc2.no50_第一个只出现一次的字符;

/**
 * @author dxc
 * @Title: TheFirstCharacter
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/21 17:35
 */
/*
* 用类似于哈希表的方法，用一个长度为26的数组保存每个字符出现的次数
* 第一遍遍历的时候记录出现的次数
* 第二次找第一个是1的元素
* */
public class TheFirstCharacter {

    public static char getFirstCharacter(String str){

        if (str == null || str.length() == 0){
            return '0';
        }

        char[] strs = str.toCharArray();
        int[] numbers = new int[26];

        for (int i = 0;i < strs.length; i++){
            numbers[strs[i] - 'a']++;
        }
        for (int i = 0;i < numbers.length; i++){
            if (numbers[i] == 1){
                return (char)(i + 'a');
            }
        }

        return '0';
    }

}
