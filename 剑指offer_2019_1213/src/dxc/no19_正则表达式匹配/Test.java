package dxc.no19_正则表达式匹配;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/25 17:26
 */

public class Test {

    public static void main(String[] args) {

        String str = "aaa";
        String pattern = "ab*ac*a";

        System.out.println(Match.match(str.toCharArray(),pattern.toCharArray()));

    }
}
