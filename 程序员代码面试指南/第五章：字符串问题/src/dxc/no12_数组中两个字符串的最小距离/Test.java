package dxc.no12_数组中两个字符串的最小距离;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/10 20:55
 */
public class Test {

    public static void main(String[] args) {
        String[] strs = new String[]{"1","3","3","3","2","3","1"};
        String[] strs2 = new String[]{"AB"};

        System.out.println(GetMinDistance.getMinDistance(strs,"1","2"));
        System.out.println(GetMinDistance.getMinDistance(strs2,"1","2"));
    }
}
